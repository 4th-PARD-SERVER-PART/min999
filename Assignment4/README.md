![Futurama](https://github.com/user-attachments/assets/c811a562-3c5a-4607-b98d-fc55d3c32362)
<br/><br/>
<br/><br/>
### 반갑습니다     
<br/><br/>
## 테이블,컬럼   
### user = 이름, 학번   
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




