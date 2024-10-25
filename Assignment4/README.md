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
### 좋아요 기능, 한번 Post하면 좋아요, 한번 더 Post하면 좋아요 취소
<br/><br/>
---
### GetMapping
### http://localhost:8080/user/{user_id}
### user_id로 user 정보 불러오기
<br/><br/>
### http://localhost:8080/post/{uesr_id}
### user_id로 작성한 포스트 불러오기
<br/><br/>
### http://localhost:8080/user/like/{user_id}
### user_id로 해당 user가 좋아요 누른 post들 불러오기
![스크린샷 2024-10-25 150813](https://github.com/user-attachments/assets/972c1e21-6e76-4c56-880a-48ea79ec9a37)
<br/><br/>
### http://localhost:8080/post/{post_id}
### post_id로 post 정보 불러오기
<br/><br/>
### http://localhost:8080/user/like/{user_id}
### post_id로 좋아요 해당 post에 좋아요 누른 user_name 목록 불러오기
![image](https://github.com/user-attachments/assets/211f1b99-9c57-4810-9211-f8e54654b2b9)
<br/><br/>
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
### 이번에 하면서서 빌더 많이 써서..난 이제 빌더가 조아..
<br/><br/>
### 이번에 Dto를 왜 쓰는지 온몸으로 배움
<br/><br/>
![image](https://github.com/user-attachments/assets/8562e05f-27f8-48cf-afa1-981d82060ba4)


