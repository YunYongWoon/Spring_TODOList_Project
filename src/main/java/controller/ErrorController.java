package controller;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.ErrorService;

@Controller
public class ErrorController {
    @Autowired
    ErrorService errorService;

    @RequestMapping(value = "/error", method = RequestMethod.GET)
    public ResponseEntity error(){
        errorService.makeError();
        return new ResponseEntity("error", HttpStatus.OK);
    }
}
