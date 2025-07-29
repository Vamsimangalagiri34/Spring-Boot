package com.SpringSecurity.Security.Controller;

import com.SpringSecurity.Security.Model.Student;
import com.SpringSecurity.Security.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SecurityController {

    @Autowired
    StudentService sService;
    @GetMapping("/home")
    public String home(HttpServletRequest request){
        return "greetings !"+request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(){
        return "about page";
    }

    @PostMapping("/create")
    public  String addStudent(@RequestBody Student std){
        return sService.addStudent((std));

    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return  sService.getStudents();
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf( HttpServletRequest req){
        return (CsrfToken)  req.getAttribute("_csrf");
    }
}
