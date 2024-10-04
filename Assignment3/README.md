# 버거킹 CRUD
<br/>
<br/>

## 소개하자면..


![image](https://github.com/user-attachments/assets/cd8a9f33-a52b-4388-bb8e-0aa8cb76a766) <br/>
## 이렇게 POST부터 /all로 모든 내용 조회할 수 있다! <br/>
![image](https://github.com/user-attachments/assets/8c28323d-600f-4863-9a60-1617fbe82403) <br/>
## 이렇게 삭제랑 <br/>
![image](https://github.com/user-attachments/assets/56b69209-fc2e-4582-971d-98c1a99ba74c) <br/>
## findById도 있다..
<br/>

# CRUD내용이 전과 비슷한 부분이 많아
# 내가 인상깊게 생각했던 내용위주로 설명해보겠다

<br/>
<br/>
<br/>

## UPDATE <br/>

![image](https://github.com/user-attachments/assets/2d6e01d7-e5cd-4653-b6ce-4364826e083c)
![image](https://github.com/user-attachments/assets/8e72c899-9926-42ed-b536-ac6d9cb0fc85)<br/>
## 기본적으로 찾고 삭제하고 수정하는 기능들이 모두 id로 부터나와서 <br/>
## 아이디를 출력하고자 MenuDto에 menuid를 넣었으나 <br/>
## 수정부분엔 id수정은 있으면 안될것 같아서 뻇다.


<br/>
<br/>

## 다음은 내가 만든 JPA문법!

![image](https://github.com/user-attachments/assets/0255e857-1235-40cb-b47b-998eb779710b)<br/> 
## 이런 느낌으로 4가지만 넣어봤다. <br/>
<br/> <br/>
## 특별한 점은 findByBname에서 이름을 넣고 가격'만'얻고자  <br/>
<br/>

![image](https://github.com/user-attachments/assets/f28d3831-abf2-4f33-b57e-e0f19a648ffb) <br/>
## 이렇게 PriceDto라는 Dto를 새로 만들어서 리턴값으로 해봤다
<br/>

# findTop1ByOrderByPriceAsc
> **요건 price가장 낮은걸 찾아준다** <br/>
> **기존의 아이디나 이름으로 찾는것과 비슷하다** <br/>
> **JPA가 자동으로 해주니 😁😁😁(쉬우니까 사진패스)**
<br/> <br/>
<br/>

# List<Menu> findByPriceBetween(int p1, int p2)
## 이건 p1과 p2의 값을받아 그 사이값의 있는 menu들을 보여준다!

![image](https://github.com/user-attachments/assets/982742d4-a304-4b8b-a5ae-0340011ae55f) <br/>
## 처음에 사이값이 목록으로 나올줄 모르고
## 그냥 Menu했다가 계속 오류떠서 힘들었다
## 덕분에 List랑 스트림 Map(->)좀 익숙해짐

<br/> <br/>

![image](https://github.com/user-attachments/assets/454389ae-2c05-437c-81ea-b927a78a3651) <br/>

## 마지막 JPA
## findAllByOrderByUserSignupTimeAsc
## 어려웠다
## 덕분에 JPA문 만드는 규칙을 찾은것같다고말할수있을지없을지모르겠다는느낌일까
## 동필정필방
## 동작 필터링 정렬 필드 방향 (아닐수도)
<br/> <br/> <br/>
# 하다보니 알게된것들 틀린것도있을수있음
<br/>

> **.get()을 어떨떈 붙이고 어떨땐 안붙이네👇👇** <br/> 
> **객체를 그대로 돌려주는 메서드를 쓰면 안붙여도됨** <br/>
> **Menu findTop1ByOrderByPriceAsc(); 요런거** <br/> 
> **내가 이번에 만든 것들(4가지)이 객체들을 그대로 돌려주는거라 get붙일 수 없다** <br/>
> **근데 안만들어도 알아서 만들어주는거 findbyid같은 놈은 optional로 돌려준다카더라(검색해보니)** <br/>
> **그래서 jpa가 자동으로 만들어준 애들은 객체그대로 돌려주는게 아니라서 .get()이 필요한듯하다** <br/>
<br/>

> **responseentity도 dto를 감싸면 좋다** <br/>
> **responseentity는 그냥 포장박스같은것(전송상태내용이 택배송장느낌)** <br/>
<br/>

> **Pathvariable이 주소가 쉽게 겹치는듯**<br/>
> **이래서 param쓰는게 편할 수도 있겠다 라는 생각을 함**<br/>
<br/>








