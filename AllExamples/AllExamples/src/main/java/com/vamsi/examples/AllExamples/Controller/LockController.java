package com.vamsi.examples.AllExamples.Controller;

import com.vamsi.examples.AllExamples.Service.LockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/lock/")
public class LockController {

    @Autowired
    LockService lockService;

    @GetMapping
    public ResponseEntity<?> display(){
      return  ResponseEntity.ok(lockService.display());
    }

    @PostMapping
    public void  createUsers(){
         lockService.createObjects();
    }
}
