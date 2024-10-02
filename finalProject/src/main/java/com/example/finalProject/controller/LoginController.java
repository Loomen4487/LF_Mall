package com.example.finalProject.controller;

import com.example.finalProject.dto.LoginDTO;
import com.example.finalProject.email.EmailService;
import com.example.finalProject.service.LoginService;
import com.example.finalProject.service.NoticeService;
import com.example.finalProject.sms.SmsService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;

@Controller
@RequiredArgsConstructor
public class LoginController {

    private final LoginService loginService;
    private final NoticeService noticeService;

    private final SmsService smsService;
    private final EmailService emailService;
    private final SmsService smsUtil;
    @PostMapping("/findPasswordOk")
    public String resetPassword(@RequestParam String email) {
        // 이메일로 임시 비밀번호 전송
        emailService.sendTemporaryPassword(email);
        return "redirect:/login";
    }
    @GetMapping(value = "/login/FindID")
    public String findId(){
        return "findID";
    }

    // coolSMS
    @PostMapping(value = "/findID")
    public ResponseEntity<?> sendSmsToFindEmail(@RequestBody String phone, HttpServletResponse response) {
        String code = smsUtil.sendOne(phone);
        Cookie cookie = new Cookie("code",code);
        cookie.setMaxAge(60*5);
        response.addCookie(cookie);
        return ResponseEntity.status(HttpStatus.OK).body(code);
    }


    @GetMapping(value = "/idCheck/{id}")
    @ResponseBody
    public LoginDTO idCheck(@PathVariable String id){
        return loginService.findById(id);
    }
    @GetMapping(value = "/login")
    public String login(HttpServletRequest request){
        String uri= request.getHeader("Referer");
        if(uri!=null && !uri.contains("/login"))request.getSession().setAttribute("prevPage",uri);
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
