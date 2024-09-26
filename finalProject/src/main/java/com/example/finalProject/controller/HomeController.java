package com.example.finalProject.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {


//    @Secured("ROLE_USER")
    @GetMapping(value = "/mypage")
    public String mypage(){
        return "mypage";
    }

    @GetMapping(value = "/mypage/userInfo_change1")
    public String userInfo_change1(){
        return "userInfo_change1";
    }

    @GetMapping(value = "/mypage/userInfo_change2")
    public String userInfo_change2(){
        return "userInfo_change2";
    }

    @GetMapping(value = "/a")
    public String a(){
        return "a";
    }
}