package util;

import domain.slackNoti.Parameter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;

@Component
public class SlackNotificationUtil {
    @Value("${slack.notification_url}")
    private String slackUrl;
    private String slackChannel;
    private String slackMessage;

    private RestTemplate restTemplate;
    public SlackNotificationUtil(){
        restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
    }

    public void SendNotificationMsg(){
        Parameter parameter = new Parameter();
        parameter.setUsername("TestUser");
        parameter.setText("Test");

        try{
            restTemplate.postForObject(slackUrl,parameter,String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
