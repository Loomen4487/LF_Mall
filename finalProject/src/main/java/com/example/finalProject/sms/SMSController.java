package com.example.finalProject.sms;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class SMSController {

    private final SmsService smsUtil;
    @PostMapping(value = "/sms")
    public ResponseEntity<?> sendSmsToFindEmail(@RequestBody String phone) {
        smsUtil.sendOne(phone);
        return ResponseEntity.status(HttpStatus.OK).body("전송완료");
    }
}
