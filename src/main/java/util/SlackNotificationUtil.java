package util;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SlackNotificationUtil {
    @Value("${slack.notification_url}")
    private String slackUrl;
    private RestTemplate restTemplate = new RestTemplate();

    public void SendNotificationMsg(Object object){
        List<Object> attachment = new ArrayList<Object>();
        attachment.add(object);
        Map<String, Object> parameter = new HashMap<String, Object>(){
            {
                put("username","Test");
                put("text", "Error");
                put("attachments", attachment);
            }
        };

        try{
            restTemplate.postForObject(slackUrl,parameter,String.class);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
