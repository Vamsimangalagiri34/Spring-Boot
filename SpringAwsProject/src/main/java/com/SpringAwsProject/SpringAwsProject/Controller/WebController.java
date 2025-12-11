package com.SpringAwsProject.SpringAwsProject.Controller;
//
////import com.SpringAwsProject.SpringAwsProject.Repository.RepositoryLayer;
//import com.SpringAwsProject.SpringAwsProject.Service.ServiceLayer;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/")
public class WebController {

//   @Autowired
//    ServiceLayer serviceLayer;
//
//   @Autowired
//    RepositoryLayer repositoryLayer;
//
//    @GetMapping("/register")
//    public String registerUser(){
//       return "register";
//    }
//
//    @GetMapping("/login")
//    public String showLoginPage(){
//        return "login";
//    }
//
//    @PostMapping("/login")
//    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
////        repositoryLayer.save(new User(1,"vamsi","vamsi","user"));
//        if (serviceLayer.validateUser(username, password)) {
//            model.addAttribute("message", " Login successful! ");
//            return "redirect:/api/welcome";
//        } else {
//            model.addAttribute("error", "Invalid username or password");
//            return "redirect:/api/login";
//        }
//
//    }
//
//    @GetMapping("/create")
//    public void createUsers(){
//
//    }

    @GetMapping("/welcome")
    public String welcomePage(Model model) {
        return "welcome";
    }




}
