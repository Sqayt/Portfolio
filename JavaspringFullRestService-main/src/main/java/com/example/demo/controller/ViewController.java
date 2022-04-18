package com.example.demo.controller;

import com.example.demo.service.NewsServiceImp;
import com.example.demo.service.UserServiceImp;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class ViewController {

    private final UserServiceImp userServiceImp;
    private final NewsServiceImp newsServiceImp;

    @GetMapping("/v1336/news")
    public String newsListTable(Model model){
        model.addAttribute("allNews", newsServiceImp.readAll());
        return "news";
    }

    @GetMapping("/v1336/users")
    public String usersListTable(Model model){
        model.addAttribute("allUsers", userServiceImp.allUsers());
        return "users";
    }

    //Регистрация пользователей , пока функция АФК

//    @GetMapping("/v1336/registration")
//    public String viewRegistration(){
//        return "registration";
//    }

    @GetMapping("/v1336/authentication")
    public String viewAuthentication(){
        return "authentication";
    }
}
