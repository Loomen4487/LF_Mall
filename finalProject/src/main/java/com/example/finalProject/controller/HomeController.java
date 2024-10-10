package com.example.finalProject.controller;

import com.example.finalProject.dto.NoticeDTO;
import com.example.finalProject.dto.OrderedDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.dto.QnaDTO;
import com.example.finalProject.security.PrincipalDetails;
import com.example.finalProject.service.*;
import com.siot.IamportRestClient.IamportClient;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
public class HomeController {
    private final NoticeService noticeService;
    private final ProductService productService;
    private final QnaService qnaService;
    private final OrderedService orderedService;
    private final ReviewService reviewService;

    @GetMapping(value = "/user")
    @ResponseBody
    public String user(@AuthenticationPrincipal PrincipalDetails principalDetails){
        System.out.println("user-info : "+principalDetails.getDto());
        return "user";
    }


    @GetMapping(value = "/detailItem/{idx}")
    public String detailItem(@PathVariable int idx, Model model){
        System.out.println("결과 : "+qnaService.findByProduct_idx(idx));
        ProductDTO dto = productService.findByIdx(idx);
        model.addAttribute("product",dto);
        model.addAttribute("recommand",productService.selectRecommand(dto.getRef()));
        model.addAttribute("qna",qnaService.findByProduct_idx(idx));
        model.addAttribute("review",reviewService.findByProduct_idx(idx));
        return "detailItem";
    }

    @PostMapping(value = "/detailItem/pay")
    public String pay(@RequestParam HashMap<String,String> map, Model model){
        String idx = map.get("idx");
        model.addAttribute("product",productService.findByIdx(Integer.parseInt(idx)));
        model.addAttribute("count",Integer.parseInt(map.get("count")));
        return "pay";
    }

    @PostMapping(value = "/payOk")
    public ResponseEntity<?> payOk(@RequestParam HashMap<String,String> map, HttpSession session){
        String uuid = UUID.randomUUID().toString();
        session.setAttribute("uuid",uuid);
        OrderedDTO dto = new OrderedDTO(0,Integer.parseInt(map.get("product_idx")),null,Integer.parseInt(map.get("count")),map.get("address"),map.get("detailAddress"),map.get("phone"),map.get("login_id"),false, uuid,false);
        orderedService.insert(dto);
        return ResponseEntity.status(HttpStatus.OK).body(dto);
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

    // 마이페이지 주문 배송내역 날짜 조회
    @GetMapping(value = "/mypage/orderDateList/{idx}")
    @ResponseBody
    public List<OrderedDTO> selectOrderedDateList(@PathVariable int idx){
        return orderedService.selectOrderedDateList(idx);
    }

    // 주문번호 확인
    @GetMapping(value = "/payCheck")
    public String payCheck(RedirectAttributes redirectAttributes){
        return "includes/payCheck";
    }

    // 비회원 주문조회
    @PostMapping(value = "/nonLoginOrderCheck")
    @ResponseBody
    public OrderedDTO nonLoginOrderCheck(@RequestParam(required = false) String memberName){
        return orderedService.nonLoginOrderCheck(memberName);
    }
}
