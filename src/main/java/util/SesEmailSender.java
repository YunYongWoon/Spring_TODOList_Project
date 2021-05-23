package util;

import com.amazonaws.services.simpleemail.AmazonSimpleEmailServiceAsync;
import com.amazonaws.services.simpleemail.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SesEmailSender {
    @Autowired
    private AmazonSimpleEmailServiceAsync amazonSimpleEmailServiceAsync;

    public void sendEmail(String From, String To, String SUBJECT, String HTMLBODY){
        SendEmailRequest sendEmailRequest = new SendEmailRequest()
                .withDestination(
                        new Destination().withToAddresses(To)
                )
                .withMessage(new Message()
                        .withBody(new Body()
                                .withHtml(new Content()
                                        .withCharset("UTF-8").withData(HTMLBODY)))
                        .withSubject(new Content()
                                .withCharset("UTF-8").withData(SUBJECT))
                )
                .withSource(From);

        if(amazonSimpleEmailServiceAsync == null)
            System.out.println("is null");
        amazonSimpleEmailServiceAsync.sendEmailAsync(sendEmailRequest);
        System.out.println("Email Sent");
    }
}
