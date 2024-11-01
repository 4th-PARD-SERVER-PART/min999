# Google 로그인 기능 추가 프로젝트

이 프로젝트는 기존의 로그인 및 포스트 작성 시스템에 **Google OAuth** 기반의 구글 로그인 기능을 추가한 프로젝트입니다. 사용자들은 구글 계정을 통해 간편하게 로그인할 수 있으며, 로그인 성공 시 전용 환영 페이지가 표시됩니다. 또한, 포스트 작성과 좋아요 기능을 통해 기본적인 CRUD와 소셜 기능을 제공합니다.

## 주요 기능

1. **구글 로그인 기능**  
   - 기존의 로그인 방식과 함께 Google OAuth를 통한 소셜 로그인을 지원합니다.
   - 구글 로그인 성공 시 "Login Successful!" 메시지가 표시되고, 환영 이미지가 출력됩니다.

2. **포스트 작성**  
   - 로그인 후, 사용자는 포스트를 작성할 수 있습니다.
   - 포스트 작성은 Postman을 통해 REST API로 요청할 수 있습니다.

3. **좋아요 기능**  
   - 사용자는 게시물에 좋아요를 누를 수 있으며, 좋아요 상태가 데이터베이스에 기록됩니다.

---

## 사용 예시

### 1. 기존 로그인 화면 (Postman 요청)
기존에는 사용자 정보를 아래와 같이 POST 방식으로 전송하여 로그인했습니다.

```json
POST http://localhost:8080/user

{
    "name": "기존 로그인",
    "num": "기존 로그인"
}

2. Google 로그인 성공 화면
Google 로그인에 성공하면 다음과 같은 화면이 나타납니다.
![로그인성공화면](https://github.com/user-attachments/assets/120c27b2-c291-4710-b670-dfe3fd333757)


3. 게시물 작성 기능
로그인 후 게시물 작성 기능을 통해 Google 계정으로 게시물을 작성할 수 있습니다.



json
코드 복사
POST http://localhost:8080/post/1
Body:
{
    "title": "구글로 가져와서 글 써봄",
    "text": "구글로 가져왔다!"
}
![포스트맨_post](https://github.com/user-attachments/assets/c347a3e1-83b4-4130-9f56-f98991e99bd7)

4. Google로 작성한 게시물 확인
작성한 게시물이 정상적으로 저장되어 조회할 수 있습니다.
![구글로 글쓴거 확인](https://github.com/user-attachments/assets/6d01f044-1066-4486-8640-975b54a85060)


5. 좋아요 기능
게시물에 대해 좋아요 기능을 추가하였으며, 사용자가 좋아요를 누른 상태를 데이터베이스에서 확인할 수 있습니다.
![좋아요기능잘됨](https://github.com/user-attachments/assets/30b47784-8a1f-47d0-9258-72037429e449)


기술 스택
Spring Boot
Google OAuth 2.0
MySQL

