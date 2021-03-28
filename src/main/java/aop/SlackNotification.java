package aop;

import domain.slackNoti.Attachments;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import util.SlackNotificationUtil;

@Component
@Aspect
public class SlackNotification {
    @Autowired
    SlackNotificationUtil slackNotificationUtil;

    @AfterThrowing(value = "execution(* controller.*Controller.*(..))",throwing = "exception")
    public void SendSlackExceptionNotification(JoinPoint joinPoint, Throwable exception){
        String errorMessage = exception.getMessage();
        String errorMethod = joinPoint.getSignature().getName();

        String msg = String.format("%s 에서 %s 예외 발생",errorMethod,errorMessage);

        Attachments attachments = new Attachments();
        attachments.setColor("danger");
        attachments.setAuthor_name("Test");
        attachments.setTitle("Test1");
        attachments.setText(msg);

        slackNotificationUtil.SendNotificationMsg(attachments);
    }
}
