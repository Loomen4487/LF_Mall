package com.example.finalProject.controller;

import com.example.finalProject.dto.NoticeDTO;
import com.example.finalProject.dto.QnaDTO;
import com.example.finalProject.security.PrincipalDetails;
import com.example.finalProject.service.NoticeService;
import com.example.finalProject.service.ProductService;
import com.example.finalProject.service.QnaService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final NoticeService noticeService;
    private final ProductService productService;
    private final QnaService qnaService;
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

    @GetMapping(value = "/detailItem/{idx}")
    public String detailItem(@PathVariable int idx, Model model){
        System.out.println("결과 : "+qnaService.findByProduct_idx(idx));
        model.addAttribute("product",productService.findByIdx(idx));
        model.addAttribute("qna",qnaService.findByProduct_idx(idx));
        return "detailItem";
    }

    @PostMapping(value = "/detailItem/pay")
    public String pay(@RequestParam HashMap<String,String> map, Model model){
        String idx = map.get("idx");
        model.addAttribute("product",productService.findByRef(Integer.parseInt(idx)));
        model.addAttribute("count",Integer.parseInt(map.get("count")));
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

    @Secured("ROLE_USER")
    @GetMapping(value = "/app")
    public String app(){
        return "app";
    }

    @GetMapping(value = "/mybag")
    public String mybag(){
        return "mybag";
    }



    @GetMapping(value = "/woman/{name}")
    public String woman(@PathVariable String name){
        return "mybag";
    }


    // qna
    @GetMapping(value = "/qnaForm/{idx}")
    public String qna(@PathVariable int idx,Model model){
        model.addAttribute("idx",idx);
        return "qnaForm";
    }

    // qna 처리
    @PostMapping(value = "/qnaOk")
    public String qnaOk(QnaDTO dto){
        qnaService.insert(dto);
        return "redirect:/detailItem/"+dto.getProduct_idx();
    }
}
