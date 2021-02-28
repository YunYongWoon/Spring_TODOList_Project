package controller;

import domain.TODOList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.TODOService;
import sun.security.krb5.internal.crypto.RsaMd5CksumType;

import java.util.List;

@Controller
public class TODOController {
    @Autowired
    TODOService todoService;

    //TodoList 생성
    @ApiOperation(value = "Create TODO List",tags = "TODO")
    @RequestMapping(value = "/api/list",method = RequestMethod.POST, consumes = "application/json")
    public ResponseEntity createList(TODOList todoList, String schedule){
        return todoService.CreateList(todoList, schedule)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }

    //TodoList 조회
    @ApiOperation(value = "Read TODO List",tags = "TODO")
    @RequestMapping(value = "/api/list",method = RequestMethod.GET)
    public ResponseEntity<List<TODOList>> readList(){
        return new ResponseEntity<>(todoService.ReadList(), HttpStatus.OK);
    }

    //TodoList 수정
    @ApiOperation(value = "Update TODO List",tags = "TODO")
    @RequestMapping(value = "/list",method = RequestMethod.PATCH, consumes = "application/json")
    public ResponseEntity updateList(TODOList todoList, String schedule){
        return todoService.UpdateList(todoList, schedule)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Fail", HttpStatus.BAD_REQUEST);
    }

    //TodoList 삭제
    @ApiOperation(value = "Delete TODO List",tags = "TODO")
    @RequestMapping(value = "/list",method = RequestMethod.DELETE)
    public ResponseEntity deleteList(Long id){
        return todoService.DeleteList(id)
                ? new ResponseEntity<>("삭제 성공", HttpStatus.OK)
                : new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    //TodoList -> Archieve
    @ApiOperation(value = "Achieve TODO List",tags = "TODO")
    @RequestMapping(value = "/archieve",method = RequestMethod.PATCH)
    public ResponseEntity achieveList(Long id){
        return todoService.AchieveList(id)
                ? new ResponseEntity<>("OK", HttpStatus.OK)
                : new ResponseEntity<>("Failed",HttpStatus.BAD_REQUEST);
    }

    //Archieve 조회
    @ApiOperation(value = "Read Archieve",tags = "TODO")
    @RequestMapping(value = "/api/archieve",method = RequestMethod.GET)
    public ResponseEntity readArchieve(){
        return new ResponseEntity(todoService.ReadArchieve(),HttpStatus.OK);
    }
}
