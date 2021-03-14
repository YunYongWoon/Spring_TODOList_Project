package controller;

import domain.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.UserService;

import javax.validation.Valid;

@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @ApiOperation(value = "Register Test",tags = "User")
    @RequestMapping(value = "/registration",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity<String> userRegister(@ApiParam(value = "required : accountID, password", required = true) @RequestBody @Valid User user){
        userService.RegisterUser(user);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    @ResponseBody
    @ApiOperation(value = "Login Test",tags = "User")
    @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity userLogin(@ApiParam(value = "required : accountID, password", required = true) @RequestBody @Valid User user){
        String token = userService.Login(user);
        if(token != null)
            return new ResponseEntity<>(token, HttpStatus.OK);
        else
            return new ResponseEntity<>("login Failed",HttpStatus.BAD_REQUEST);
    }
}
