package com.vamsi.examples.AllExamples.AOP.Controller;

import com.vamsi.examples.AllExamples.AOP.Service.Greetings;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class Controller {

    @Autowired
    private Greetings greetings;
    @GetMapping("/hello")
    public String sayHello(@RequestParam int id ,@RequestParam String name ) {
          log.info("printing data"+id+" "+ name);
          String string=greetings.orderSuccess();
          if(!string.isEmpty()){
              greetings.orderFailed();
          }
          else{
              System.out.println(string);
          }
        return "✅ Greeting executed — check logs!";
    }




}

//before - Logging, validation, authentication, pre-checks
//        Validate user data before saving, check role before update
//
//after- cleaning cache audting or logging notification Notification	Send confirmation email or event after transaction