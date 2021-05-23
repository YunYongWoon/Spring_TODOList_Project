package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import util.SesEmailSender;

@Controller
public class TestMailController {
    @Autowired
    private SesEmailSender sesEmailSender;

    @RequestMapping(value = "/sendmail", method = RequestMethod.GET)
    public ResponseEntity<String> send(){
        sesEmailSender.sendEmail("no-reply@xn--h50bx6qpwi02aa.com",
                "yuyun0124@gmail.com",
                "Email Test",
                "<h1>Email Test</h1>)" +
                        "<p>Test Mail. please Click <a href='https://aws.amazon.com/ses/'>This</a></p>");
        return new ResponseEntity<String>("Mail Send", HttpStatus.OK);
    }
}
