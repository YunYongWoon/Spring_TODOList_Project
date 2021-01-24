package util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
// AfterReturning 사용
@Aspect
@Component
public class TimeChecker {
    @AfterReturning(value = "execution(* service.*TimeService.*(..))",returning = "ret")
    public void TimeChecker(JoinPoint joinPoint, Object ret){
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        System.out.println(formatter.format(ret));
    }
}
