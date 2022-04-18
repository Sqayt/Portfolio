package com.example.demo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class UserController {

    //Регистрация пользователей , пока функция АФК

//    private final UserServiceImp userService;
//    private final PasswordEncoder bCryptPasswordEncoder;
//
//    @PostMapping("/v1336/registration")
//    public String addPostUsers(@RequestParam String username,
//                               @RequestParam String password,
//                               @RequestParam String name,
//                               @RequestParam String surname){
//        Users newUser = new Users();
//
//        newUser.setUsername(username);
//        newUser.setName(name);
//        newUser.setSurname(surname);
//        newUser.setPassword(bCryptPasswordEncoder.encode(password));
//
//        if(newUser.getUsername().equals("") ||
//                newUser.getPassword().equals("") ||
//                    newUser.getName().equals("") ||
//                        newUser.getSurname().equals("")){
//            System.out.println("check");
//            return "registration";
//        }
//
//        if(userService.saveUser(newUser)) {
//            return "redirect:/v1336/users";
//        }
//
//        return "registration";
//    }
}
