package controller;

import domain.TODOList;
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

    @ApiOperation(value = "Create TODO List",tags = "TODO")
    @RequestMapping(value = "/api/create",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createList(TODOList todoList,String schedule){
        return todoService.CreateList(todoList, schedule)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Read TODO List",tags = "TODO")
    @RequestMapping(value = "/api/read",method = RequestMethod.GET)
    public ResponseEntity<List<TODOList>> readList(Long id){
        return new ResponseEntity<>(todoService.ReadList(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Update TODO List",tags = "TODO")
    @RequestMapping(value = "/update",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity updateList(TODOList todoList){
        return todoService.UpdateList(todoList)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }

    @ApiOperation(value = "Delete TODO List",tags = "TODO")
    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ResponseEntity deleteList(Long id){
        return new ResponseEntity<>(todoService.DeleteList(id), HttpStatus.OK);
    }
}
