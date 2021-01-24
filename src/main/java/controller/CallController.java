package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.CallService;

@Controller
public class CallController {
    @Autowired
    CallService callService;

    @RequestMapping(value = "/call",method = RequestMethod.GET)
    public ResponseEntity CallMethod(){
        callService.CheckCall();
        return new ResponseEntity("CallMethod", HttpStatus.OK);
    }
}
