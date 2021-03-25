package util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {
    @Value("${SECRET_KEY}")
    private String secretKey;

    private Key key;

    public String generateToken(Long id){
        key = Keys.hmacShaKeyFor((secretKey+secretKey).getBytes());

        Map<String, Object> header = new HashMap<>();
        header.put("typ", "JWT");
        header.put("alg", "HS256");

        //1시간
        Long expTime = 1000*60L*60L;
        Date exp = new Date();
        exp.setTime(exp.getTime() + expTime);

        // payload
        Map<String, Object> payload = new HashMap<>();
        payload.put("sub", "accessToken");
        payload.put("aud", id);
        payload.put("exp", exp);

        String token = Jwts.builder()
                .setHeader(header)
                .setClaims(payload)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return token;
    }

    public boolean checkToken(String userToken){
        String token = userToken.substring(7);
        //try-catch로 잡아야됨. 테스트
        Claims claims = Jwts.parser().setSigningKey(this.key).parseClaimsJws(token).getBody();
        Date exp = claims.get("exp",Date.class);
        Date now = new Date();

        if(exp.getTime() < now.getTime()) {
            return true;
        }
        else {
            return false;
        }
    }

    public Long getIdByToken(){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        String header = request.getHeader("Authorization");
        String authToken = header.substring(7);
        String[] strings = authToken.split("\\.");
        Map<String,Object> payloads = null;

        try{
            payloads = new ObjectMapper().readValue(new String(Base64.decodeBase64(strings[1])), Map.class);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }

        Long id = Long.valueOf(String.valueOf(payloads.get("aud")));
        return id;
    }
}
