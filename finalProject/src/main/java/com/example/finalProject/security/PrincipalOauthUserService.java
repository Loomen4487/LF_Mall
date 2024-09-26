package com.example.finalProject.security;

import com.example.finalProject.entity.LoginEntity;
import com.example.finalProject.repository.LoginRepository;
import com.example.finalProject.vo.LoginUser;
import com.example.finalProject.vo.NaverVO;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class PrincipalOauthUserService extends DefaultOAuth2UserService {
    private final LoginRepository loginRepository;
    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String provider = userRequest.getClientRegistration().getRegistrationId();
        System.out.println("user-info : "+oAuth2User.getAttribute("response"));
        LoginUser loginUser = null;
        switch(provider){
            case "naver":
                loginUser = new NaverVO(oAuth2User.getAttribute("response"));
                break;
        }
        LoginEntity le = loginRepository.findById(loginUser.getId());
        if(Objects.isNull(le)){
            le = LoginEntity.builder()
                    .id(loginUser.getId())
                    .password(loginUser.getPassword())
                    .email(loginUser.getEmail())
                    .role(loginUser.getRole())
                    .provider(provider)
                    .build();
            loginRepository.save(le);
        }
        return new PrincipalDetails(le.toDTO(),loginUser.getAthorities());
    }
}
