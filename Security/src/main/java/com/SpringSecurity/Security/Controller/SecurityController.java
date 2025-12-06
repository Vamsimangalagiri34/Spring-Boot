package com.SpringSecurity.Security.Controller;

import com.SpringSecurity.Security.JWTWorld.JWTService;
import com.SpringSecurity.Security.Model.Student;
import com.SpringSecurity.Security.Model.User;
import com.SpringSecurity.Security.Service.StudentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/securityex")
public class SecurityController {

    @Autowired
    StudentService sService;

    @Autowired
    JWTService jwtService;

    @Autowired
    AuthenticationManager authenticationManager;
    @GetMapping
    public String greeting(){
        return "Good Evening !";
    }
    @GetMapping("/home")
    public String home(HttpServletRequest request){
        return "greetings !"+request.getSession().getId();
    }

    @GetMapping("/about")
    public String about(){
        return "about page";
    }

    @PostMapping("/register")
    public  User addStudent(@RequestBody User user){
        BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder(12);
          user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
          System.out.println(user.getPassword());
        return sService.addUser(user);

    }

    @GetMapping("/students")
    public List<Student> findAll(){
        return  sService.getStudents();
    }

    @GetMapping("/csrf")
    public CsrfToken getCsrf( HttpServletRequest req){
        System.out.println((CsrfToken)  req.getAttribute("_csrf"));
        return (CsrfToken)  req.getAttribute("_csrf");
    }

    @PostMapping("/login")
    public String login(@RequestBody User user){
        Authentication authentication=authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(user.getName(),user.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(user.getName());
        }

        return "failed";
    }

}
