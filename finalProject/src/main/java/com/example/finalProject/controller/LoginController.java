package com.example.finalProject.controller;

import com.example.finalProject.dto.LoginDTO;
import com.example.finalProject.email.EmailService;
import com.example.finalProject.service.LoginService;
import com.example.finalProject.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final NoticeService noticeService;

    private final EmailService emailService;
    @PostMapping("/findPasswordOk")
    public String resetPassword(@RequestParam String email) {
        // 이메일로 임시 비밀번호 전송
        emailService.sendTemporaryPassword(email);
        return "redirect:/login";
    }
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
