package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;
import exception.TokenException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        // 토큰이 없으면
        if ( token == null || ("".equals(token) && token.isEmpty()) ) {
            throw new TokenException("No Token");
        }
        if  (!token.startsWith("Bearer ")){ // 토큰이 Bearer 인증타입을 지키지않고 전송이 될때
            throw new TokenException("Not Bearer");
        }
        else if(token.length() < 8){
            throw new TokenException("Too short!");
        }
        else {
            if ( jwtUtil.checkToken(token) ) { //토큰의 인증 기간이 종료되었으면
                throw new TokenException("is Expired");
            }
            return true;
        }
    }
}
