package com.example.finalProject.email;

import com.example.finalProject.service.LoginService;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
@RequiredArgsConstructor
public class EmailService {
	private final JavaMailSender mailSender;
	private final LoginService loginService;

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TEMP_PASSWORD_LENGTH = 8;

    public void sendTemporaryPassword(String email) {
        // 임시 비밀번호 생성
        String tempPassword = generateTemporaryPassword();

        // 이메일 전송
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper;

        try {
            helper = new MimeMessageHelper(message, true);
            
            // 보낸 사람 주소 설정
            helper.setFrom("shiose17@naver.com");
            
            // 수신자 주소 설정
            helper.setTo(email); // 전달받은 이메일 주소 사용
            
            // 제목 및 내용 설정
            helper.setSubject("임시 비밀번호 발급");
            helper.setText("임시 비밀번호: " + tempPassword +"\n임시 비밀번호로 로그인해주세요");
            loginService.updatePassword(tempPassword,email);
            // 이메일 전송
            mailSender.send(message);
            
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        mailSender.send(message);

    }

    private String generateTemporaryPassword() {
        SecureRandom random = new SecureRandom();
        StringBuilder sb = new StringBuilder(TEMP_PASSWORD_LENGTH);
        for (int i = 0; i < TEMP_PASSWORD_LENGTH; i++) {
            int index = random.nextInt(CHARACTERS.length());
            sb.append(CHARACTERS.charAt(index));
        }
        return sb.toString();
    }
}