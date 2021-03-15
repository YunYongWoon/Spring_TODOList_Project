package controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@ControllerAdvice
public class ProjectExceptionHandler {
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    @ResponseBody
    public ResponseEntity ValidException(MethodArgumentNotValidException e){
        BindingResult result = e.getBindingResult();
        ArrayList<String> res = new ArrayList<>();
        for(FieldError fe : result.getFieldErrors()){
            res.add(fe.getDefaultMessage());
        }
        return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ResponseEntity<String> GlobalException(RuntimeException e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
