package interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import util.JwtUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Interceptor extends HandlerInterceptorAdapter {
    @Autowired
    private JwtUtil jwtUtil;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader("Authorization");

        if(token == null)  // 토큰이 없는경우
            throw new RuntimeException("No Token");

        if(token.length() < 10 ) // 토큰 길이가 짧을 경우
            throw new RuntimeException("To Short");

        if(!token.startsWith("Bearer ")) // 토큰이 Bearer 인증타입을 지키지않고 전송이 될때
            throw new RuntimeException("Not Bearer");

//        if(jwtUtil.getIdByToken() == null) // 토큰에 ID 정보가 없을 경우
//            throw new RuntimeException("No ID Data");

        if(jwtUtil.checkToken(token))  // 토큰 인증 기간이 만료되었을 경우
            throw new RuntimeException("is Expired");

        return true;
    }
}

