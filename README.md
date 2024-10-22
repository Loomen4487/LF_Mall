# LF_Mall (팀 프로젝트 / 개발기간 2024-09-23 ~ 2024-10-11)

### 프로젝트 개요
프로젝트 

- [x] [서비스 시연 사진](#서비스-시연-사진)
- [x] [서비스 핵심기능](#서비스-핵심기능)
- [x] [기술 스택](#기술-스택)
- [x] [기술적 의사결정](#기술적-의사결정)
- [x] [ERD](#erd)

<hr/>

###  (원래는 영상인데 메인사진)

![image](https://github.com/user-attachments/assets/08ed8c45-e3f1-49d5-8af0-6d7f41d9916e)



### 서비스 핵심기능
```
핵심기능 #1. : SpringSecurity를 활용한 인증처리
핵심기능 #2. : Vue를 활용한 실시간 랜더링
핵심기능 #3. : 아임포트를 활용한 결제
```



|<small>메인</small>|<small>카테고리<small>|<small>쇼핑벡</small>|
|:-:|:-:|:-:|
|![003](https://github.com/user-attachments/assets/d9d51e6c-6a5f-48d3-aa95-be30d83b54ea)|![004](https://github.com/user-attachments/assets/07418e6a-8ce3-4a0b-a93e-709b6ded83b0)|![005](https://github.com/user-attachments/assets/dab10923-4571-4c1e-a672-8c46ee10a18e)|
|<small><b>결제</b></small>|<small><b>상세페이지</b></small>|<small><b>로그인</b></small>|
|![006](https://github.com/user-attachments/assets/1c92c04d-a2b5-4ea6-8403-b2518d39e92a)|![007](https://github.com/user-attachments/assets/d79c3c10-6632-40b2-af55-b808af5913a5)|![008](https://github.com/user-attachments/assets/b9e43078-1772-4328-869a-26b4a3e9d9d2)|


### 🛠기술 스택
OS | Windows 10
--- | --- |
Language | ![Java](https://img.shields.io/badge/JAVA-000?style=for-the-badge&logo=java&logoColor=white) ![Spring](https://img.shields.io/badge/Spring-000?style=for-the-badge&logo=spring&logoColor=white) ![HTML5](https://img.shields.io/badge/html5-000?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-000?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-000?style=for-the-badge&logo=javascript&logoColor=white)
IDE | ![IntelliJ](https://img.shields.io/badge/IntelliJ-000?style=for-the-badge&logo=eclipseide&logoColor=white) ![SQL](https://img.shields.io/badge/SQL%20Developer-000?style=for-the-badge&logo=oracle&logoColor=white)
Framework | ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) ![Intellij](https://img.shields.io/badge/Intellij-d40000?style=for-the-badge)
Build Tool | ![Gradle](https://img.shields.io/badge/Gradle%20-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
Database | ![My SQL Database 11g](https://img.shields.io/badge/MySQL-F80000?style=for-the-badge&logo=oracle&logoColor=white)
Frontend | ![HTML5](https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white)
Library | ![Spring Security](https://img.shields.io/badge/spring%20security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white) ![Thymeleaf](https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white) ![Redis](https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white) ![OAuth 2.0 Client](https://img.shields.io/badge/OAuth%202.0%20Client-4b4b4b?style=for-the-badge) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
API | ![Java Mail](https://img.shields.io/badge/Java%20Mail-3a75b0?style=for-the-badge) ![Daum Postcode](https://img.shields.io/badge/Daum%20Postcode-f94756?style=for-the-badge) ![Iamport Payment](https://img.shields.io/badge/Iamport%20Payment-c1272d?style=for-the-badge) ![coolSMS](https://img.shields.io/badge/cool%20SMS-f7943a?style=for-the-badge) ![Swiper](https://img.shields.io/badge/Swiper-6332F6?style=for-the-badge&logo=swiper&logoColor=white) ![Font Awesome](https://img.shields.io/badge/Font%20Awesome-528DD7?style=for-the-badge&logo=fontawesome&logoColor=white) ![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
Version Control | ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)

### ✨기술적 의사결정
선택기술 | 선택이유 및 근거
--- | --- |
`SpringSecurity` | DB에 암호화된 패스워드를 사용하고, 로그인한 유저의 권한에 따라 보여지는 페이지 구분, 인증되지 않은 사용자의 경우 자동으로 로그인 페이지로 이동.
`Oauth2-Client` | Kakao ,Naver 간편 로그인 서비스를 위해 도입. 
`CoolSms` | 아이디 찾기 기능에서 회원가입시 입력한 휴대폰 번호로 인증번호를 발급받아 일치할시 회원가입한 아이디 출력하는 용도로 사용.
`JavaMailSender` | 비밀번호 찾기에서 임시비밀번호를 발급받을때 사용, 임시비밀번호를 발급받아 보안적인 측면을 강조.
`아임포트` | KG이니시스를 활용한 실제 결제 서비스
`VUE` | 상품 정렬순서대로 보기, 의류 카테고리에서 볼때 동적으로 선택될때마다 상품들을 보여주기 위해 사용.
`Thymeleaf Layout` |  Header/Footer를 각각 `Fragment`로 구분하여 사이트 전역적으로 사용되는 데 있어 코드 중복을 피하고 추가/수정에 용이하도록 의도하였음.
`@HttpSession` | 어노테이션 통해 **세션상에 정보를 저장하고, 여러 화면 또는 연계된 요청 중에 해당 객체를 공유**하도록 정의해 다음과 같이 활용하였음.<br>`로그인 확인용 정보(loginMember)`<br>:  현재 로그인한 회원의 아이디를 가리키며 나아가 관리자인지 혹은 작성자 본인인지를 구분.<br>`최근 본 상품(recentlyViewed)`<br>: 회원은 접속 이래 현재까지 조회한 상품 목록을 '마이페이지'에서 확인 가능.<br>`장바구니(geulBeotCart)`<br>: 비로그인 상태에서 담은 장바구니 상품이 회원의 장바구니 목록으로 저장.<br>`바로주문 요청 정보(orderItem)`<br>: 로그인 전 선택한 상품 및 세부 옵션 정보 그대로 '주문페이지'로 이어지며, 이는 일회성이기에 사용자의 기존 장바구니와는 무관.<br>

### 📖ERD
![image](https://github.com/user-attachments/assets/83dc9948-8618-408f-b958-a6e36a3d52f6)
