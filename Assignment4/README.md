![image](https://github.com/user-attachments/assets/5fd3e1a8-b14f-47e2-b5e3-353346fbd7a5)   
### 반갑습니다    
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
### post 
### - http://localhost:8080/user 
![image](https://github.com/user-attachments/assets/50ca6661-0b9d-4ede-9bb5-a98ed1002c8e)
<br/><br/>
### http://localhost:8080/post/{user_id}
![image](https://github.com/user-attachments/assets/9206dbac-5d5a-4ac0-a669-1381322b62a0)
<br/><br/>
### http://localhost:8080/like/{user_id}/{post_id}

### user_id로 user 정보 불러오기
### user_id로 작성한 포스트 불러오기
### user_id로 해당 user가 좋아요 누른 post들 불러오기
<br/><br/>
### post_id로 post 정보 불러오기
### post_id로 좋아요 해당 post에 좋아요 누른 user_name 목록 불러오기



