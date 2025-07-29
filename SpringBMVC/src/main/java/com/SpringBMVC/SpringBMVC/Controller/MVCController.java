package com.SpringBMVC.SpringBMVC.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class MVCController {

    @RequestMapping("/home")
    public String home(){
        System.out.println("from home");
        return "index";
    }

    @RequestMapping("/add")
    public String add(
            @RequestParam(required = false, defaultValue = "0") int num1,
            @RequestParam(required = false, defaultValue = "0") int num2,
            Model model) {

        int result = num1 + num2;
        System.out.println(result);
        model.addAttribute("result", result);
        if(num1==0 || num2==0){
            return "failed";
        }
        return "result";
    }

}
