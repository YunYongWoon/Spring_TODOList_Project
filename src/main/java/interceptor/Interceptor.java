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
        if ( token == null || ("".equals(token) && token.isEmpty()) ) { // 토큰이 없는경우
            System.out.println("No Token");
            throw new Exception();
        }
        if ( token.length() < 10 ){
            System.out.println("To Short");
            throw new Exception();
        }
        else if  (!token.startsWith("Bearer ")){ // 토큰이 Bearer 인증타입을 지키지않고 전송이 될때
            System.out.println("Not Bearer");
            throw new Exception();
        }
        else {
            if ( jwtUtil.checkToken(token) ) {
                System.out.println("is Expired");
                throw new Exception();
            }
            return true;
        }
    }
}
