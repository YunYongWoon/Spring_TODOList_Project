package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Checker {
    @AfterThrowing(value = "execution(* service.*Service.*(..))",throwing = "ex")
    public void ErrorChecker(JoinPoint joinPoint, Throwable ex) throws Throwable{
        String methodName = joinPoint.getSignature().getName();

        System.out.println(methodName+" 에서 "+ex+" 에러 발생 ");
    }
}
