package controller;

import domain.TODOList;
import domain.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TODOService;

import java.util.List;

@Controller
public class TODOController {
    @Autowired
    TODOService todoService;

    @ApiOperation(value = "Create TODO List",tags = "Create")
    @RequestMapping(value = "/create",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createList(TODOList todoList){
        return todoService.CreateList(todoList)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Read TODO List",tags = "Read")
    @RequestMapping(value = "/read",method = RequestMethod.GET)
    public ResponseEntity<List<TODOList>> readList(Long id){
        return new ResponseEntity<>(todoService.ReadList(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Delete TODO List",tags = "Delete")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity deleteList(Long id){
        return new ResponseEntity<>(todoService.DeleteList(id), HttpStatus.OK);
    }
}
