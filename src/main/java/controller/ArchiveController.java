package controller;

import domain.ArchiveList;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import service.ArchiveService;

import java.util.List;

@Controller
public class ArchiveController {
    @Autowired
    ArchiveService archiveService;
    //TodoList 조회
    @ResponseBody
    @ApiOperation(value = "Read Archive List",tags = "Archive")
    @RequestMapping(value = "/api/Archive/{page}",method = RequestMethod.GET)
    public ResponseEntity<List<ArchiveList>> readList(
            @PathVariable("page") Long page){
        return new ResponseEntity(archiveService.ReadList(page), HttpStatus.OK);
    }
}
