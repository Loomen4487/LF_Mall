package com.example.finalProject.controller;

import com.example.finalProject.dto.NoticeDTO;
import com.example.finalProject.security.PrincipalDetails;
import com.example.finalProject.service.NoticeService;
import lombok.RequiredArgsConstructor;
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
    private final NoticeService noticeService;
    @GetMapping(value = "/")
    @ResponseBody
    public String index(){
        return "index";
    }

    @GetMapping(value = "/user")
    @ResponseBody
    public String user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("user-info : "+principalDetails.getDto());
        return "user";
    }

    @GetMapping(value = "/detailItem")
    public String detailItem(){
        return "detailItem";
    }

    @GetMapping(value = "/detailItem/pay")
    public String pay(){
        return "pay";
    }

    @GetMapping(value = "/notice")
    public String notice(Model model){
        int total = noticeService.selectCount();
        model.addAttribute("notice",noticeService.selectAll(0,5));
        model.addAttribute("total",(total-1)/5+1);
        return "notice";
    }

    @GetMapping(value = "/notice/select/{idx}")
    @ResponseBody
    public List<NoticeDTO> selectIdx(@PathVariable int idx){
        return noticeService.selectAll(idx,5);
    }
    @GetMapping(value = "/notice/detail/{idx}")
    public String noticeDetail(@PathVariable int idx,Model model){
        model.addAttribute("notice",noticeService.selectByIdx(idx));
        return "noticeDetail";
    }
}
