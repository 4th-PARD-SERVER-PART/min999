![1730363148963-9hep2fvdr9a](https://github.com/user-attachments/assets/8eab367f-a9da-462a-b1ad-c80a8b444a69)

# Google 로그인 기능 추가 프로젝트

이 프로젝트는 기존 로그인 및 포스트 작성 시스템에 **Google OAuth**를 통한 구글 로그인 기능을 추가하여, 사용자가 구글 계정을 통해 손쉽게 로그인할 수 있게 합니다. 로그인에 성공하면 전용 환영 페이지가 표시되며, 이후 포스트 작성과 좋아요 기능을 통해 CRUD 및 소셜 기능을 제공합니다.

## 주요 기능

1. **구글 로그인 기능**
   - 기존 로그인 방식에 **Google OAuth 소셜 로그인**을 추가했습니다.
   - 구글 로그인에 성공하면 "Login Successful!" 메시지가 표시되고 환영 이미지가 나타납니다.

2. **포스트 작성 기능**
   - 로그인 후 사용자는 포스트를 작성할 수 있으며, Postman을 통해 REST API로 요청할 수 있습니다.

3. **좋아요 기능**
   - 게시물에 좋아요를 추가할 수 있으며, 해당 상태는 데이터베이스에 기록됩니다.

---

## 사용 예시

### 1. 기존 로그인 요청 (Postman 요청 예시)
기존 로그인 방식은 아래와 같이 사용자 정보를 POST 방식으로 전송하여 처리합니다.

    POST http://localhost:8080/user

    Body:
    {
        "name": "기존 로그인",
        "num": "기존 로그인"
    }

### 2. Google 로그인 성공 화면
Google 로그인에 성공하면 다음 화면이 나타납니다.

![로그인 성공 화면](https://github.com/user-attachments/assets/120c27b2-c291-4710-b670-dfe3fd333757)

### 3. 게시물 작성 기능
Google 계정으로 로그인 후, 아래와 같은 REST API 요청을 통해 게시물을 작성할 수 있습니다.

    POST http://localhost:8080/post/1
    
    Body:
    {
        "title": "구글로 가져와서 글 써봄",
        "text": "구글로 가져왔다!"
    }

![포스트 작성 화면](https://github.com/user-attachments/assets/c347a3e1-83b4-4130-9f56-f98991e99bd7)

### 4. Google로 작성한 게시물 확인
작성된 게시물을 조회하여 정상적으로 저장되었음을 확인할 수 있습니다.

![구글로 작성한 글 확인](https://github.com/user-attachments/assets/6d01f044-1066-4486-8640-975b54a85060)

### 5. 좋아요 기능
게시물에 좋아요 기능을 추가하여, 사용자가 좋아요를 누른 상태를 데이터베이스에서 확인할 수 있습니다.

![좋아요 기능 동작 확인](https://github.com/user-attachments/assets/30b47784-8a1f-47d0-9258-72037429e449)

---

## 기술 스택
- **Spring Boot**
- **Google OAuth 2.0**
- **MySQL**

이 프로젝트를 통해 구글 로그인을 통한 인증과 소셜 기능을 효율적으로 결합하였습니다.
