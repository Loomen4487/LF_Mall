package com.example.finalProject.controller;

import com.example.finalProject.dto.LoginDTO;
import com.example.finalProject.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;

    @GetMapping(value = "/login")
    public String login(){
        return "login";
    }

    @GetMapping(value = "/signup")
    public String signup(){
        return "signup";
    }

    @GetMapping(value = "/signup/register")
    public String signupRegister(){
        return "signupRegister";
    }

    @PostMapping(value = "/signupOk")
    public String signupOk(LoginDTO dto){
        loginService.insert(dto);
        return "redirect:/login";
    }

    @GetMapping(value = "/login/findPassword")
    public String findPassword(){
        return "findPassword";
    }

}
