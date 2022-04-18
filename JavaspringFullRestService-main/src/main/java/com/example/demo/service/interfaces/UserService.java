package com.example.demo.service.interfaces;


import com.example.demo.model.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    boolean saveUser(Users user);

    boolean deleteUser(String userId);

    List<Users> allUsers();

    List<Users> usergtList(String idMin);

    Users findUser(String username);

}
