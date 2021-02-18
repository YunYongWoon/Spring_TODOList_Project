package controller;

import domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.UserService;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ApiOperation(value = "Register Test",tags = "User")
    @RequestMapping(value = "/registration",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> userRegister(User user){
        return userService.RegisterUser(user)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Fail", HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ApiOperation(value = "Login Test",tags = "User", consumes = "application/json")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity userLogin(User user){
        String token = userService.Login(user);
        return new ResponseEntity<>(token, HttpStatus.OK);
    }
}
