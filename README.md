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
회원 : 로그인 | 회원가입 | 이메일 인증 | 소셜 로그인(카카오/구글) | 아이디 찾기 | 비밀번호 찾기 | 임시 비밀번호 발송
마이페이지 : 주문/배송 조회 | 리뷰 등록,수정,삭제 | 찜하기 목록 조회,삭제 | 적립금 내역 조회 | 최초 주문 전 휴대폰 번호 인증 | 회원정보수정 | 회원탈퇴
상품 : 헤더 전체 검색 | 찜하기 등록,삭제 | 섹션/브랜드/가격범위/태그/필터별 조회, 장바구니, 바로주문
고객센터 : 1:1문의 등록,수정,삭제 | 글·댓글내용/작성자/첨부파일명/말머리별 게시판 검색 | 작성자/관리자 한정 게시글 조회 | 댓글 및 대댓글 등록,수정,삭제,실시간 알림
관리자페이지 : 기간별 회원수/매출액/누적 판매량 TOP 8 통계 조회,엑셀 다운로드 | 메인슬라이드/이벤트배너 등록,수정 | 회원 권한부여,계정정지,누적신고수관리 | 게시글 삭제,복구,휴지통관리 | 댓글 삭제,복구,휴지통관리 | 상품 등록,수정,판매상태변경,옵션별추가금액관리,재고관리 | 주문/배송 배송상태변경,실시간 알림
```

<details>
<summary>핵심기능 #1. </summary>

</details>
<details>
<summary>핵심기능 #2. </summary>

</details>
<details>
<summary>핵심기능 #3. </summary>

</details>


|<small>메인</small>|<small>카테고리<small>|<small>쇼핑벡</small>|
|:-:|:-:|:-:|
|![003](https://github.com/user-attachments/assets/d9d51e6c-6a5f-48d3-aa95-be30d83b54ea)|![004](https://github.com/user-attachments/assets/07418e6a-8ce3-4a0b-a93e-709b6ded83b0)|![005](https://github.com/user-attachments/assets/dab10923-4571-4c1e-a672-8c46ee10a18e)|
|<small><b>결제</b></small>|<small><b>상세페이지</b></small>|<small><b>로그인</b></small>|
|![006](https://github.com/user-attachments/assets/1c92c04d-a2b5-4ea6-8403-b2518d39e92a)|![007](https://github.com/user-attachments/assets/d79c3c10-6632-40b2-af55-b808af5913a5)|![008](https://github.com/user-attachments/assets/b9e43078-1772-4328-869a-26b4a3e9d9d2)|


### 🛠기술 스택
OS | Windows 10
--- | --- |
Language | ![Java](https://img.shields.io/badge/JAVA-000?style=for-the-badge&logo=java&logoColor=white) ![Spring](https://img.shields.io/badge/Spring-000?style=for-the-badge&logo=spring&logoColor=white) ![HTML5](https://img.shields.io/badge/html5-000?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-000?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-000?style=for-the-badge&logo=javascript&logoColor=white)
IDE | ![STS4](https://img.shields.io/badge/STS4-000?style=for-the-badge&logo=spring&logoColor=white) ![Eclipse](https://img.shields.io/badge/Eclipse-000?style=for-the-badge&logo=eclipseide&logoColor=white) ![Visual Studio Code](https://img.shields.io/badge/Visual%20Studio%20Code-000?style=for-the-badge&logo=visualstudiocode&logoColor=white) ![SQL Developer](https://img.shields.io/badge/SQL%20Developer-000?style=for-the-badge&logo=oracle&logoColor=white)
Framework | ![Spring Boot](https://img.shields.io/badge/Spring%20Boot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white) ![MyBatis](https://img.shields.io/badge/Mybatis-d40000?style=for-the-badge)
Build Tool | ![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
Database | ![Oracle Database 11g](https://img.shields.io/badge/Oracle-F80000?style=for-the-badge&logo=oracle&logoColor=white)
Frontend | ![HTML5](https://img.shields.io/badge/html5-E34F26?style=for-the-badge&logo=html5&logoColor=white) ![CSS3](https://img.shields.io/badge/css3-1572B6?style=for-the-badge&logo=css3&logoColor=white) ![JavaScript](https://img.shields.io/badge/javascript-F7DF1E?style=for-the-badge&logo=javascript&logoColor=black) ![jQuery](https://img.shields.io/badge/jQuery-0769AD?style=for-the-badge&logo=jquery&logoColor=white)
Library | ![Spring Security](https://img.shields.io/badge/spring%20security-6DB33F?style=for-the-badge&logo=springsecurity&logoColor=white) ![Thymeleaf](https://img.shields.io/badge/thymeleaf-005F0F?style=for-the-badge&logo=thymeleaf&logoColor=white) ![Redis](https://img.shields.io/badge/redis-DC382D?style=for-the-badge&logo=redis&logoColor=white) ![OAuth 2.0 Client](https://img.shields.io/badge/OAuth%202.0%20Client-4b4b4b?style=for-the-badge) ![Jasypt](https://img.shields.io/badge/Jasypt-364162?style=for-the-badge) ![JUnit5](https://img.shields.io/badge/JUnit5-25A162?style=for-the-badge&logo=junit5&logoColor=white)
API | ![Java Mail](https://img.shields.io/badge/Java%20Mail-3a75b0?style=for-the-badge) ![Daum Postcode](https://img.shields.io/badge/Daum%20Postcode-f94756?style=for-the-badge) ![Iamport Payment](https://img.shields.io/badge/Iamport%20Payment-c1272d?style=for-the-badge) ![coolSMS](https://img.shields.io/badge/cool%20SMS-f7943a?style=for-the-badge) ![CKEditor 4](https://img.shields.io/badge/CKEditor%204-0287D0?style=for-the-badge&logo=ckeditor4&logoColor=white) ![](https://img.shields.io/badge/Chart.js-FF6384?style=for-the-badge&logo=chartdotjs&logoColor=white) ![ExcelJS](https://img.shields.io/badge/Excel%20JS-209e63?style=for-the-badge) ![Swiper](https://img.shields.io/badge/Swiper-6332F6?style=for-the-badge&logo=swiper&logoColor=white) ![ElevateZoom Plus](https://img.shields.io/badge/Elevate%20Zoom%20Plus-ff6347?style=for-the-badge) ![Font Awesome](https://img.shields.io/badge/Font%20Awesome-528DD7?style=for-the-badge&logo=fontawesome&logoColor=white) ![Bootstrap](https://img.shields.io/badge/Bootstrap-7952B3?style=for-the-badge&logo=bootstrap&logoColor=white)
Server |![Apache Tomcat 9.0](https://img.shields.io/badge/Apache%20Tomcat%20-F8DC75?style=for-the-badge&logo=apachetomcat&logoColor=black)
Version Control | ![GitHub](https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub&logoColor=white)

### ✨기술적 의사결정
선택기술 | 선택이유 및 근거
--- | --- |
`SSE` | 로그인 통해 Server와 Client간 연결이 이뤄지거든 Client에게 추가적인 요청을 요구하지 않으면서도 불시에 발생되는 이벤트들을 즉각 송신할 수 있어야 하기에 **Server to Client로의 단방향 통신**이 가능한 `Server-Sent Events(SSE)`가 실시간 알림을 구현하는 데 적합하다고 판단하였음.
`Redis` | 휘발성 데이터인 _이메일 인증 토큰_ 을 데이터베이스에 직접 저장 및 호출하는 것은 불필요한 부하를 초래할 수 있으므로 인메모리(In-Memory) 형태에 TTL(Time to Live) 특성을 지녀 유효기간이 설정된 `Redis` 기반의 **Refresh Token**으로서 관리.
`Jasypt` | 보안 측면을 고려하여 `Jasypt` 통해 _비밀번호_ 와 같은 **property의 암호화**를 진행하고, 어플리케이션 실행 시 값을 요청할 수 있도록 VM arguments로 등록함.
`JUnit5` | 주어진 환경에서(given) 특정 코드가 실행됐을 때(when) 어떤 결과로 이어지는지(then) 모듈 단위의 테스트케이스로 구분. **전제적 요구사항을 점검하고, 의도대로 작동하는지 검증**하면서 코드의 생산성 및 유지보수성을 높이고자 함.
`Enum` | 문구 쇼핑몰 특성에 맞춰 _잉크컬러, 바디컬러, 심두께, 태그, 할인율, 상품카테고리, 기본배송메시지, 카드사별 할부혜택내용, 문의게시판 말머리, 실시간 알림 종류_ 등을 **연관된 상수들의 집합인 열거형** `Enum`으로 정의. 각 필드마다 데이터를 배정하고 이를 접근자(getter method) 통해 호출하면서 리팩토링 시 변경 범위를 최소화하였음.
`Commons Lang3` | 상품 전체 검색 시 _StringUtils, NumberUtils_ 등 `Apache Commons Lang3` 클래스에 정의된 메소드 통해 **parameter type을 동적으로 구분 및 처리**하도록 조건별 쿼리문을 최적화하였음.
`Thymeleaf Layout` | _Alert, Modal, ***Pagination***, ***Comment***, Header/Footer,  Dashboard_ 등을 각각 `Fragment`로 구분하여 사이트 전역적으로 사용되는 데 있어 코드 중복을 피하고 추가/수정에 용이하도록 의도하였음.
`MessageSource` | 쇼핑몰 확장성 및 코드 유지보수성을 고려하여 **필요에 따라 다국어 지원**할 수 있도록 앞서 `Thymeleaf Layout Fragment`로 구분해둔 알러트(alert) 메시지들은 `MessageSource` 인터페이스의 `properties`로 관리되고 있음.
`@SessionAttributes` | 어노테이션 통해 **세션상에 정보를 저장하고, 여러 화면 또는 연계된 요청 중에 해당 객체를 공유**하도록 정의해 다음과 같이 활용하였음.<br>`로그인 확인용 정보(loginMember)`<br>:  현재 로그인한 회원의 아이디를 가리키며 나아가 관리자인지 혹은 작성자 본인인지를 구분.<br>`최근 본 상품(recentlyViewed)`<br>: 회원은 접속 이래 현재까지 조회한 상품 목록을 '마이페이지'에서 확인 가능.<br>`장바구니(geulBeotCart)`<br>: 비로그인 상태에서 담은 장바구니 상품이 회원의 장바구니 목록으로 저장.<br>`바로주문 요청 정보(orderItem)`<br>: 로그인 전 선택한 상품 및 세부 옵션 정보 그대로 '주문페이지'로 이어지며, 이는 일회성이기에 사용자의 기존 장바구니와는 무관.<br>`소셜 로그인 여부(signInWithSocialAccount)`<br>: 소셜 로그인(카카오/구글) 시 이동 경로 구분.

### 📖ERD
![image](https://github.com/user-attachments/assets/83dc9948-8618-408f-b958-a6e36a3d52f6)
