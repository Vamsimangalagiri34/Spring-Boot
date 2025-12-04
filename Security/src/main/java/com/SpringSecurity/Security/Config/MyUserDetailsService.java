package com.SpringSecurity.Security.Config;

//import com.SpringSecurity.Security.Model.User;
import com.SpringSecurity.Security.Model.User;
//import com.SpringSecurity.Security.Model.UserSec;
import com.SpringSecurity.Security.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipal;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
   private UserRepo userRepo;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepo.findByName(username);
        if(user==null){
            throw  new UsernameNotFoundException("User 404");
        }

        return new UserPrinciple(user);
    }
}
