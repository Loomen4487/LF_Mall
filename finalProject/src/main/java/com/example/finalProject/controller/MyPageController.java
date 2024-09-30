package com.example.finalProject.controller;

import com.example.finalProject.dto.LoginDTO;
import com.example.finalProject.dto.ProductDTO;
import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.service.LoginService;
import com.example.finalProject.service.ProductService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageController {
    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ProductService productService;

    @Secured("ROLE_USER")
    @GetMapping(value = "/mypage")
    public String mypage(){
        return "mypage";
    }

    @Secured("ROLE_MANAGER")
    @GetMapping(value = "/superMyPage")
    public String superMypage(Model model){

        model.addAttribute("total",(productService.selectCount()-1)/16+1);
        return "superMypage";
    }

    @GetMapping(value = "/superMyPage/selectOrderListAll/{startNo}")
    @ResponseBody
    public ResponseEntity<List<ProductDTO>> selectOrderListAll(@PathVariable int startNo){
        return ResponseEntity.status(HttpStatus.OK).body(productService.selectOrderListAll(startNo,16));
    }
    @GetMapping("/mypage/userInfo_change1")
    public String getUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("username", username);

        return "userInfo_change1";
    }

    @PostMapping("/mypage/userInfo_change2")
    public String verifyPassword(@RequestParam("password") String password, Model model) {
        // 현재 로그인한 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // 데이터베이스에서 사용자 정보 가져오기
        LoginDTO loginEntity = loginService.findById(username);

        // 입력된 비밀번호와 데이터베이스에 저장된 비밀번호 비교
        if (bCryptPasswordEncoder.matches(password, loginEntity.getPassword())) {
            // 비밀번호 일치하면 회원정보 수정 페이지로 이동
            model.addAttribute("username", loginEntity.getId());
            model.addAttribute("email", loginEntity.getEmail());
            return "/userInfo_Change2";
        } else {
            // 비밀번호가 일치하지 않으면 오류 메시지 출력
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("username", username);
            return "redirect:/mypage/userInfo_change1";
        }
    }

    @PostMapping("/mypage/userInfo_change1")
    public String changePassword(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 @RequestParam String email,
                                 Model model) {
        LoginDTO loginEntity = loginService.findById(username);

        // 현재 비밀번호가 일치하는지 확인
        if (!bCryptPasswordEncoder.matches(password, loginEntity.getPassword())) {
            model.addAttribute("error", "현재 비밀번호가 일치하지 않습니다.");
            return "/userInfo_change2"; // 비밀번호가 틀렸을 경우 다시 입력 요청
        }

        // 새 비밀번호와 새 비밀번호 확인이 일치하는지 확인
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
            return "mypage/userInfo_change2"; // 새 비밀번호가 일치하지 않으면 다시 입력
        }

        // 새 비밀번호 암호화하여 저장
        loginEntity.setPassword(bCryptPasswordEncoder.encode(newPassword));
        loginEntity.setEmail(email);
        loginEntity.setId(username);
        loginService.save(loginEntity);

        return "redirect:/mypage/userInfo_change1"; // 성공 페이지로 리다이렉트
    }

    @GetMapping(value = "/mypage/address")
    public String address(){
        return "address";
    }

    // 배송지 입력 폼 페이지로 이동
    @GetMapping("/addAddressForm")
    public String showAddAddressForm() {
        return "addAddressForm";  // addAddressForm.html 파일을 반환
    }

}
