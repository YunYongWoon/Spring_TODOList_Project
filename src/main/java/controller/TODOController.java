package controller;

import domain.TODOList;
import domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.TODOService;

@Controller
public class TODOController {
    @Autowired
    TODOService todoService;

    @ApiOperation(value = "Create TODO List",tags = "Create")
    @RequestMapping(value = "/addList",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createList(TODOList todoList){
        return todoService.CreateList(todoList)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }
}
