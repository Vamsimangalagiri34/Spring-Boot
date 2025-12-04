package com.SpringSecurity.Security.Repository;

import com.SpringSecurity.Security.Model.User;
import org.springframework.boot.autoconfigure.data.jpa.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo  extends JpaRepository<User,Integer> {
    User findByName(String username);
}
