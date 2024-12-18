![Futurama](https://github.com/user-attachments/assets/c811a562-3c5a-4607-b98d-fc55d3c32362)
<br/><br/>
<br/><br/>
### 반갑습니다     
<br/><br/>
## 테이블,컬럼   
### user = name, num  
### post = title, text    
### like = isLike   
<br/><br/>
## 연관관계
### 1. user -> post = OneToMany   
### post -> user = ManyToOne   
<br/><br/>
### 2. post -> like = OneToMany
### like -> post = ManyToOne    
<br/><br/>
### 3.   post -> like = OneToMany
###      like -> post = ManyToOne
<br/><br/>
## 기능
### PostMapping
<br/><br/>
### 1. user값 넣기
### http://localhost:8080/user 
![image](https://github.com/user-attachments/assets/50ca6661-0b9d-4ede-9bb5-a98ed1002c8e)
<br/><br/>
### 2. post 값 넣기
### http://localhost:8080/post/{user_id}
![image](https://github.com/user-attachments/assets/9206dbac-5d5a-4ac0-a669-1381322b62a0)
<br/><br/>
### 3. 좋아요 누르기
### http://localhost:8080/like/{user_id}/{post_id}
![image](https://github.com/user-attachments/assets/12efe3c5-1b5c-42a6-b545-2324a14c4229)
<br/><br/>
### 좋아요 기능, 한번 Post하면 좋아요, 한번 더 Post하면 좋아요 취소
<br/><br/>
---
### GetMapping
### http://localhost:8080/user/{user_id}
![image](https://github.com/user-attachments/assets/d2932565-2ee8-46f9-b566-f65771de5e2b)
<br/><br/>
### user_id로 user 정보 불러오기
<br/><br/>
### http://localhost:8080/post/{uesr_id}
![image](https://github.com/user-attachments/assets/5055f1f7-2193-4c5a-9942-84b47cd66dea)
<br/><br/>
### user_id로 작성한 포스트 불러오기
<br/><br/>
### http://localhost:8080/user/like/{user_id}
### user_id로 해당 user가 좋아요 누른 post들 불러오기
![스크린샷 2024-10-25 150813](https://github.com/user-attachments/assets/972c1e21-6e76-4c56-880a-48ea79ec9a37)
<br/><br/>
### http://localhost:8080/post/{post_id}
### post_id로 post 정보 불러오기
![image](https://github.com/user-attachments/assets/45084565-ac8b-464e-8a70-f677c7acf830)
<br/><br/>
### http://localhost:8080/user/like/{user_id}
### post_id로 좋아요 해당 post에 좋아요 누른 user_name 목록 불러오기
![image](https://github.com/user-attachments/assets/211f1b99-9c57-4810-9211-f8e54654b2b9)
<br/><br/>
---
### PatchMapping
<br/><br/>
### http://localhost:8080/user/{user_id}
![image](https://github.com/user-attachments/assets/163271a1-0e3b-401d-b6ee-238dbd7c818f)
<br/><br/>
### 유저 정보 수정하기

<br/><br/>
### http://localhost:8080/post/{post_id}
![image](https://github.com/user-attachments/assets/f296d242-9207-4671-9885-80d25d66cd9b)
### 포스트 정보 수정하기

<br/><br/>
---
### DeleteMapping
<br/><br/>
### http://localhost:8080/user/{user_id}
![image](https://github.com/user-attachments/assets/16e35a99-4677-46b7-ac44-4d4978b64ece)
<br/><br/>
### 유저 지우기
<br/><br/>
### http://localhost:8080/post/{post_id}
![image](https://github.com/user-attachments/assets/ef78c519-2591-4629-a367-2df4395e0867)
<br/><br/>
### 포스트 지우기
<br/><br/>
---
## Code
![image](https://github.com/user-attachments/assets/fa44e06e-3756-45b5-a7f4-08880ce69001)
<br/><br/>
### 여기서 객체 -> dto 변환을 어디서 할지 고민이였음 
### 좋아요 dto변환은 현재 user service 코드이니 likeDto안에 변환 메서드 만들어두고 가져다 씀(보기좋은듯)
### 유저 객체 변환은 어차피 user쪽 코드이니 여기서 바로 .builder() 씀
<br/><br/>
### 그리고 왜 like가 sql 예약어야...?ㅠ 오류나서 Good으로 바꿈 
<br/><br/>
![image](https://github.com/user-attachments/assets/f0be5921-3513-41f2-8b65-8034e6126f5c)
### 이게 내 좋아요 만드는 코드인데
### 덕분에  @Transactional이걸 배움
### 처음엔 객체 그대로 가져다 쓰다가 필요없을것 같아서 user_id랑 post_id 조합만 보는 걸로 바꿈
<br/><br/>
## Swagger
![image](https://github.com/user-attachments/assets/b32fb1bc-e213-45fa-9670-21020924258c)
<br/><br/>
### 아름답다.
<br/><br/>
![image](https://github.com/user-attachments/assets/35efb801-9216-4609-9890-59136bd5399b)
<br/><br/>
### like는 post 두번하면 지워지는 걸로 함
<br/><br/>

-------
## 느낀점
### 이번에 하면서서 빌더 많이 써서 이젠 빌더가 좋다..
<br/><br/>
### 이번에 Dto를 왜 쓰는지 온몸으로 배움
<br/><br/>
### 주석의 중요성도 온몸으로 배움 dto많아지고 복잡해지니까 헷갈림
<br/><br/>
### 유저랑 포스트 좋아요 왔다갔다 하면서 변수명 길어지고 이리저리 하니까 갑자기 코드짜다가  이게 어디였더라..하면서 횡설수설 한번씩 함
<br/><br/>
### 변수명 짜는 규칙을 배우던가 만들어야겠음
<br/><br/>
### 그리고 id로 객체 가져올떄 옵셔널로 받으면 빌더못씀
<br/><br/>

![image](https://github.com/user-attachments/assets/8562e05f-27f8-48cf-afa1-981d82060ba4)


