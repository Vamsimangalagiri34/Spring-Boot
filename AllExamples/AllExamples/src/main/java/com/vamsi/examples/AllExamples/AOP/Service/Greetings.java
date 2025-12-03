package com.vamsi.examples.AllExamples.AOP.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j  // ✅ Lombok annotation to enable logger
@Service
public class Greetings {

    public void greet() {
        log.info("👋 Hello from Greetings service!");

    }
    public void greetAfter() {
        log.info("👋 Bye from Greetings service !");
    }

    public String orderSuccess(){
        return "";
    }

    public void orderFailed(){
        log.warn("failed");
    }

}
