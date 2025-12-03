package com.vamsi.examples.AllExamples.Controller;


import com.vamsi.examples.AllExamples.ExceptionHub.ExceptionHand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ErrorController {

    @Autowired
    ExceptionHand exceptionHand;
    @GetMapping("/error")
    public ResponseEntity<?> errorController(){
         return  exceptionHand.handleMismatch();
    }

    @GetMapping("/error2")
    public  ResponseEntity<?> errorCountroller2(){
        return exceptionHand.handleFileNotF();
    }

    @GetMapping("/error3")
    public  ResponseEntity<?> errorCountroller3(){
        return exceptionHand.handleInternalEr();
    }
}
