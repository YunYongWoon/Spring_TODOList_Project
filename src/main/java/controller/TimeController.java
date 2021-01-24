package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.TimeService;

@Controller
public class TimeController {
    @Autowired
    TimeService timeService;

    @RequestMapping(value = "/time",method = RequestMethod.GET)
    public ResponseEntity Time(){
        timeService.CheckTime();
        return new ResponseEntity("time", HttpStatus.OK);
    }

}
