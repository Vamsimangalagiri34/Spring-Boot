package com.vamsi.examples.AllExamples.ExceptionHub;

import com.vamsi.examples.AllExamples.Model.ErrorM;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;

@RestController
public class ExceptionHand {


    @ExceptionHandler(FileNotFoundException.class)
    public ResponseEntity<?> handleMismatch(){
        ErrorM errorM=new ErrorM();
        errorM.setErrorStatus(405);
        errorM.setErrorMsg("MethodNotAllowed Exception");
        return ResponseEntity.status(405).body(errorM);
    }

    @ExceptionHandler(InputMismatchException.class)
    public ResponseEntity<?> handleFileNotF() {
        ErrorM errorM=new ErrorM();
        errorM.setErrorStatus(404);
        errorM.setErrorMsg("FileNotFound Exception");
        return ResponseEntity.status(404).body(errorM);
    }
    @ExceptionHandler(HttpServerErrorException.BadGateway.class)
    public ResponseEntity<?> handleInternalEr() {
        ErrorM errorM=new ErrorM();
        errorM.setErrorStatus(500);
        errorM.setErrorMsg("Internal Exception");
        return ResponseEntity.status(500).body(errorM);
    }
}
