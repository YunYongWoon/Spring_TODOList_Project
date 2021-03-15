package controller;

import domain.TODOList;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TODOService;
import sun.security.krb5.internal.crypto.RsaMd5CksumType;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TODOController {
    @Autowired
    TODOService todoService;

    //TodoList 생성
    @ResponseBody
    @ApiOperation(value = "Create TODO List",tags = "TODO")
    @RequestMapping(value = "/api/list",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createList(
            @RequestBody @ApiParam(value = "(required: TodoType,Todo(200))", required = true) @Valid TODOList todoList){
        todoService.CreateList(todoList);
        return new ResponseEntity<>("List is Created", HttpStatus.OK);
    }

    //TodoList 조회
    @ResponseBody
    @ApiOperation(value = "Read TODO List",tags = "TODO")
    @RequestMapping(value = "/api/list",method = RequestMethod.GET)
    public ResponseEntity<List<TODOList>> readList(){
        return new ResponseEntity<>(todoService.ReadList(), HttpStatus.OK);
    }

    //TodoList 수정
    @ResponseBody
    @ApiOperation(value = "Update TODO List",tags = "TODO")
    @RequestMapping(value = "/list/{id}",method = RequestMethod.PATCH, consumes = "application/json")
    public ResponseEntity updateList(
            @PathVariable("id") Long id,
            @RequestBody @ApiParam(value = "(required: TodoType,Todo)", required = true) @Valid TODOList todoList){
        todoService.UpdateList(id,todoList);
        return new ResponseEntity<>("List is Updated", HttpStatus.OK);
    }

    //TodoList 삭제
    @ResponseBody
    @ApiOperation(value = "Delete TODO List",tags = "TODO")
    @RequestMapping(value = "/list/{id}",method = RequestMethod.DELETE)
    public ResponseEntity deleteList(@PathVariable("id") Long id){
        todoService.DeleteList(id);
        return new ResponseEntity<>("List is Deleted", HttpStatus.OK);
    }

    //TodoList -> Archieve
    @ResponseBody
    @ApiOperation(value = "Achieve TODO List",tags = "TODO")
    @RequestMapping(value = "/archieve/{id}",method = RequestMethod.PATCH)
    public ResponseEntity achieveList(@PathVariable("id") Long id){
        todoService.AchieveList(id);
        return new ResponseEntity<>("List is Achieved", HttpStatus.OK);
    }

    //Archieve 조회
    @ResponseBody
    @ApiOperation(value = "Read Archieve",tags = "TODO")
    @RequestMapping(value = "/api/archieve",method = RequestMethod.GET)
    public ResponseEntity readArchieve(){
        return new ResponseEntity(todoService.ReadArchieve(),HttpStatus.OK);
    }
}
