package controller;

import domain.ArchieveList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ArchieveService;

import java.util.List;

@Controller
public class ArchieveController {
    @Autowired
    ArchieveService archieveService;
    //TodoList 조회
    @ResponseBody
    @ApiOperation(value = "Read Archieve List",tags = "Archieve")
    @RequestMapping(value = "/api/Archieve/{page}",method = RequestMethod.GET)
    public ResponseEntity<List<ArchieveList>> readList(
            @PathVariable("page") Long page){
        return new ResponseEntity(archieveService.ReadList(page), HttpStatus.OK);
    }
}
