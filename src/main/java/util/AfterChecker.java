package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AfterChecker {
    @After(value = "execution(* service.CallService.*(..))")
    public void AfterCheck(JoinPoint joinPoint){
        System.out.println(joinPoint.getSignature().getName() + " 실행 종료");
    }
}
