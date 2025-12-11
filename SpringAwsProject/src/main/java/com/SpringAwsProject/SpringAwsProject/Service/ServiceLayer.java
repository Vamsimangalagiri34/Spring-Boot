//package com.SpringAwsProject.SpringAwsProject.Service;
//
//import com.SpringAwsProject.SpringAwsProject.Repository.RepositoryLayer;
//import com.SpringAwsProject.SpringAwsProject.Model.User;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public class ServiceLayer {
//
//    @Autowired
//    RepositoryLayer repositoryLayer;
//
//    public boolean validateUser(String username,String password){
//        Optional<User> user1=repositoryLayer.findByUsername(username);
//
//        if(user1.isPresent()){
//            return true;
//        }
//        return false;
//    }
//
//
//}
