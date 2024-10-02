package com.example.finalProject.controller;

import com.example.finalProject.dto.DeliveryInfoDTO;
import com.example.finalProject.dto.LoginDTO;
import com.example.finalProject.security.PrincipalDetails;
import com.example.finalProject.service.DeliveryInfoService;
import com.example.finalProject.service.LoginService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MyPageController {
    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final DeliveryInfoService deliveryInfoService;

    @Secured("ROLE_USER")
    @GetMapping(value = "/mypage")
    public String mypage(){
        return "mypage";
    }

    @GetMapping("/mypage/userInfo_change1")
    public String getUserInfo(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        model.addAttribute("username", username);

        return "userInfo_change1";
    }

    @PostMapping("/mypage/userInfo_change1")
    public String verifyPassword(@RequestParam("password") String password, Model model) {
        // 현재 로그인한 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        // 데이터베이스에서 사용자 정보 가져오기
        LoginDTO loginDTO = loginService.findById(username);

        // 입력된 비밀번호와 데이터베이스에 저장된 비밀번호 비교
        if (bCryptPasswordEncoder.matches(password, loginDTO.getPassword())) {
            // 비밀번호 일치하면 회원정보 수정 페이지로 이동
            model.addAttribute("username", loginDTO.getId());
            model.addAttribute("email", loginDTO.getEmail());
            return "/userInfo_Change2";
        } else {
            // 비밀번호가 일치하지 않으면 오류 메시지 출력
            model.addAttribute("error", "비밀번호가 일치하지 않습니다.");
            model.addAttribute("username", username);
            return "redirect:/mypage/userInfo_change1";
        }
    }

    @PostMapping("/mypage/userInfo_change2")
    public String changePassword(@RequestParam String username,
                                 @RequestParam String password,
                                 @RequestParam String newPassword,
                                 @RequestParam String confirmPassword,
                                 @RequestParam String email,
                                 Model model) {
        LoginDTO loginDTO = loginService.findById(username);

        // 현재 비밀번호가 일치하는지 확인
        if (!bCryptPasswordEncoder.matches(password, loginDTO.getPassword())) {
            model.addAttribute("error", "현재 비밀번호가 일치하지 않습니다.");
            return "/userInfo_change2"; // 비밀번호가 틀렸을 경우 다시 입력 요청
        }

        // 새 비밀번호와 새 비밀번호 확인이 일치하는지 확인
        if (!newPassword.equals(confirmPassword)) {
            model.addAttribute("error", "새 비밀번호와 새 비밀번호 확인이 일치하지 않습니다.");
            return "mypage/userInfo_change2"; // 새 비밀번호가 일치하지 않으면 다시 입력
        }

        // 새 비밀번호 암호화하여 저장
        loginDTO.setPassword(bCryptPasswordEncoder.encode(newPassword));
        loginDTO.setEmail(email);
        loginDTO.setId(username);
        loginService.save(loginDTO);

        return "redirect:/mypage/userInfo_change1"; // 성공 페이지로 리다이렉트
    }

    @GetMapping(value = "/mypage/address")
    public String address(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        List<DeliveryInfoDTO> deliveryInfos = deliveryInfoService.findDeliveryInfosByLoginIdx(principalDetails.getDto().getIdx());

        model.addAttribute("deliveryInfos", deliveryInfos);  // 배송지 목록 전달
        System.out.println(deliveryInfos);
        return "/address";
    }

    // 배송지 입력 폼 페이지로 이동
    @GetMapping("/addAddressForm")
    public String showAddAddressForm(Model model) {
        // 현재 로그인한 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return "addAddressForm";  // addAddressForm.html 파일을 반환
    }

    @PostMapping(value = "/insertAddress")
    @ResponseBody
    public String insertAddress(DeliveryInfoDTO deliveryInfoDTO) {
        deliveryInfoService.insetDeliveryInfo(deliveryInfoDTO);
        return "success";
    }

}
