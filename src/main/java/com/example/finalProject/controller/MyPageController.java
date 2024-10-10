package com.example.finalProject.controller;

import com.example.finalProject.dto.*;
import com.example.finalProject.security.PrincipalDetails;
import com.example.finalProject.service.*;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MyPageController {
    private final LoginService loginService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;
    private final ProductService productService;
    private final MajorService majorService;
    private final MiddleService middleService;
    private final QnaService qnaService;
    private final DeliveryInfoService deliveryInfoService;
    private final OrderedService orderedService;
    private final ReviewService reviewService;
    private final ResourceLoader resourceLoader;
    @Secured("ROLE_USER")
    @GetMapping(value = "/mypage")
    public String mypage(Model model,HttpSession session){
        String id = session.getAttribute("id").toString();
        model.addAttribute("order",orderedService.findByLogin_id(id));
        model.addAttribute("totalCount",orderedService.selectCount(id));
        return "mypage";
    }

    @Secured("ROLE_MANAGER")
    @GetMapping(value = "/superMyPage")
    public String superMypage(Model model){

        model.addAttribute("total",(productService.selectCount()-1)/16+1);
        model.addAttribute("major",majorService.findAll());
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
    public String address(Model model, @AuthenticationPrincipal PrincipalDetails principalDetails) {
        int login_idx = principalDetails.getDto().getIdx();
        List<DeliveryInfoDTO> deliveryInfos = deliveryInfoService.findDeliveryInfosByLoginIdx(login_idx);

        // 만약 배송지 정보가 없다면
        if (deliveryInfos == null || deliveryInfos.isEmpty()) {
            model.addAttribute("hasDeliveryInfo", false);
        } else {
            model.addAttribute("hasDeliveryInfo", true);
            model.addAttribute("deliveryInfos", deliveryInfos);
        }
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

    // 배송지 입력 폼 페이지로 이동
    @GetMapping("/updateAddressForm/{deliveryIdx}")
    public String updareAddAddressForm(Model model, @PathVariable("deliveryIdx") String deliveryIdx) {

        model.addAttribute("delivery", deliveryInfoService.findByIdx(Integer.parseInt(deliveryIdx)));

        // 현재 로그인한 사용자 정보 가져오기
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();

        return "updateAddressForm";  // addAddressForm.html 파일을 반환
    }
    @PostMapping(value = "/updateAddress")
    @ResponseBody
    public ResponseEntity<?> updateAddress(@RequestBody DeliveryInfoDTO deliveryInfoDTO) {
        deliveryInfoService.updateDeliveryInfo(deliveryInfoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(deliveryInfoDTO);
    }

    @PostMapping(value = "/insertAddress")
    @ResponseBody
    public String insertAddress(DeliveryInfoDTO deliveryInfoDTO) {
        deliveryInfoService.insetDeliveryInfo(deliveryInfoDTO);
        return "success";
    }

    // 배송지 삭제 처리
    @PostMapping("/mypage/address/delete/{deliveryIdx}")
    public String deleteDeliveryInfo(@PathVariable("deliveryIdx") int deliveryIdx) {
        deliveryInfoService.deleteDeliveryInfo(deliveryIdx);
        return "redirect:/mypage/address";
    }

    // 관리자 계정 상품등록 페이지 이동
    @GetMapping(value = "/superMyPage/product/{idx}")
    public String productDetailItem(@PathVariable int idx,Model model){
        model.addAttribute("product",productService.findByIdx(idx));
        return "superDetail";
    }



    //관리자 계정 상품 등록 수정
    @PostMapping(value = "/superMyPage/product/updateOk")
    public String productUpdateOk(ProductDTO dto){
        productService.update(dto);
        return "redirect:/superMyPage";
    }

    // 관리자 계정 상품 검색
    @GetMapping(value = "/superMyPage/selectByName/{name}")
    @ResponseBody
    public List<ProductDTO> selectByName(@PathVariable String name){
        return productService.findByName(name);
    }

    // 관리자 계정 상품등록 카테고리 출력
    @GetMapping(value = "/selectMiddle/{idx}")
    @ResponseBody
    public List<MiddleDTO> selectMiddle(@PathVariable int idx){
        return middleService.findByRef(idx);
    }

    // 관리자 계정 상품등록 상품 필터
    @GetMapping(value = "/selectSub/{idx}/{startNo}")
    @ResponseBody
    public List<ProductDTO> selectSub(@PathVariable int idx,@PathVariable int startNo){
        return productService.superMyPageCategoryPaging(idx,startNo,16);
    }

    @GetMapping(value = "/superMyPage/qna")
    public String qna(){
        return "qna";
    }

    @GetMapping(value = "/superMyPage/qnaAll")
    @ResponseBody
    public List<QnaDTO> qnaSelectAll(){
        return qnaService.findAll();
    }

    @GetMapping(value = "/superMyPage/qna/{idx}")
    public String qnaDetail(@PathVariable int idx,Model model){
        model.addAttribute("qna",qnaService.findByIdx(idx));
        return "qnaDetail";
    }

    @PostMapping(value = "/superMyPage/qnaOk")
    public String qnaOk(QnaDTO dto){
        System.out.println("결과 : "+dto);
        dto.setAnswer(true);
        qnaService.update(dto);
        return "redirect:/superMyPage/qna";
    }

    @GetMapping(value = "/mypage/review")
    public String review(Model model,HttpSession session){
        String id = session.getAttribute("id").toString();
        model.addAttribute("ordered",reviewService.reviewAndOrderedSelectAll(id));
        model.addAttribute("review",reviewService.selectByReviewLogin_id(id));
        System.out.println("reviewService.selectByReviewLogin_id "+ reviewService.selectByReviewLogin_id(id));
        return "userReview";
    }

    @GetMapping(value = "/mypage/qna")
    public String userQna(Model model, HttpSession session){
        model.addAttribute("qna",qnaService.findById(session.getAttribute("id").toString()));
        return "userQna";
    }

    // qna 삭제
    @DeleteMapping(value = "/mypage/qna/delete/{idx}")
    public ResponseEntity<String> deleteOk(@PathVariable int idx){
        qnaService.delete(idx);
        return ResponseEntity.status(HttpStatus.OK).body("삭제가 완료되었습니다.");
    }

    // 마이페이지 리뷰 작성
    @GetMapping(value = "/mypage/review/{idx}")
    public String review(@PathVariable int idx,Model model){
        model.addAttribute("product",orderedService.findByIdx(idx));
        return "userReviewForm";
    }

    // 리뷰 저장
    @PostMapping(value = "/reviewOk")
    public String reviewOk(@RequestParam(required = false) MultipartFile review_image, ReviewDTO dto, HttpSession session){
        if(!review_image.getOriginalFilename().isEmpty()){
            try {
                System.out.println("아니 이걸 탄다고? : "+review_image.getOriginalFilename());
                String path = resourceLoader.getResource("file:/D:/review").getURI().toString()+"/images/";
                path = path.substring(6);
                File file = new File(path);
                if(!file.exists())file.mkdirs();
                dto.setImage(review_image.getOriginalFilename());
                FileCopyUtils.copy(review_image.getBytes(),new File(path+review_image.getOriginalFilename()));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
                dto.setLogin_id(session.getAttribute("id").toString());
                reviewService.insert(dto);
        return "redirect:/mypage/review";
    }

    // 마이페이지 주문내역 삭제
    @DeleteMapping(value = "/orderDeleteOk")
    public ResponseEntity<?> mypageDeleteOk(@RequestParam String idx){
        orderedService.delete(Integer.parseInt(idx));
        return ResponseEntity.status(HttpStatus.OK).body("삭제 완료");
    }

    // 마이페이지 취소/반품/교환 신청
    @GetMapping(value = "/mypage/callback")
    public String callback(Model model,HttpSession session){
        List<OrderedDTO> odto = orderedService.selectCallbackList(session.getAttribute("id").toString());
        model.addAttribute("ordered",odto);
        return "userCallback";
    }

    // 마이페이지 리뷰 삭제
    @DeleteMapping(value = "/mypage/review/delete/{idx}")
    public void reviewDelete(@PathVariable int idx){
        reviewService.delete(idx);
    }
}
