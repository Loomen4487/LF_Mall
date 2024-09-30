package com.example.finalProject.sms;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import net.nurigo.sdk.NurigoApp;
import net.nurigo.sdk.message.model.Message;
import net.nurigo.sdk.message.request.SingleMessageSendingRequest;
import net.nurigo.sdk.message.response.SingleMessageSentResponse;
import net.nurigo.sdk.message.service.DefaultMessageService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SmsService {

    @Value("${coolsms.api.key}")
    private String key;

    @Value("${coolsms.api.secret}")
    private String secretKey;

    private DefaultMessageService defaultMessageService;

    @PostConstruct
    private void init(){
        this.defaultMessageService = NurigoApp.INSTANCE.initialize(key,secretKey,"https://api.coolsms.co.kr");
    }
    public String sendOne(String to) {
        String numStr = generateRandomNumber();

        Message message = new Message();
        // 발신번호 및 수신번호는 반드시 01012345678 형태로 입력되어야 합니다.
        message.setFrom("01091139380");
        System.out.println("결과 : "+to);
        message.setTo(to);
        message.setText("[Moyiza] 아래의 인증번호를 입력해주세요\n" + numStr);
        SingleMessageSentResponse response = this.defaultMessageService.sendOne(new SingleMessageSendingRequest(message));
        return numStr;
    }
    private String generateRandomNumber() {
        Random rand = new Random();
        StringBuilder numStr = new StringBuilder();
        for (int i = 0; i < 6; i++) {
            numStr.append(rand.nextInt(10));
        }
        return numStr.toString();
    }

}
