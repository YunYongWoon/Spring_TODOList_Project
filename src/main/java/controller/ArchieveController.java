package controller;

import domain.TODOList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ArchieveService;

import java.util.List;

@Controller
public class ArchieveController {
    @Autowired
    ArchieveService archieveService;
    //TodoList 조회
    @ResponseBody
    @ApiOperation(value = "Read Archieve List",tags = "Archieve")
    @RequestMapping(value = "/api/Archieve",method = RequestMethod.GET)
    public ResponseEntity<List<TODOList>> readList(int page){
        return new ResponseEntity(archieveService.ReadList(page), HttpStatus.OK);
    }
}
