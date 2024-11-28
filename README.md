# [Spring 4기] CH 2 키오스크 과제
#### 클래스의 개념 이해 및 자바의 기본 문법 실습과 객체 지향 개념의 적용을 목표로 한다.

## 📋 요구사항
#### - Level 1 
- 입력 처리와 간단한 흐름 제어 복습
#### - Level 2
- 햄버거 메뉴를 MenuItem 클래스와 List를 통해 관리
#### - Level 3
- main 함수에서 관리하던 전체 순서 제어를 Kiosk 클래스를 통해 관리
- 키오스크 프로그램을 시작하는 메서드 구현
- 사용자의 입력을 받아 메뉴를 선택하거나 프로그램을 종료
- 유효하지 않은 입력에 대해 오류 메시지를 출력
#### - Level 4
- MenuItem 클래스를 관리하는 클래스인 Menu 클래스 생성
- 메뉴 카테고리 이름을 반환하는 메서드 구현
#### - Level 5
- MenuItem, Menu 그리고 Kiosk 클래스의 필드에 직접 접근하지 못하도록 설정
- Getter와 Setter 메서드를 사용해 데이터를 관리
#### - Challenge Lv1
- 장바구니 생성 및 관리 기능
- 장바구니 출력 및 금액 계산
- 장바구니 담기 기능
- 주문 기능
<details>
<summary>예시</summary>
<div markdown="1">

```java

[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료
1 <- // 1을 입력

[ BURGERS MENU ]
1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거
2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거
3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거
4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거
0. 뒤로가기
2 <- // 2를 입력
선택한 메뉴: SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

// 2번을 누르면 나오는 메뉴입니다.
"SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"
위 메뉴를 장바구니에 추가하시겠습니까?
1. 확인        2. 취소
1 <-

// 1번을 누르면 나오는 메뉴입니다.
SmokeShack 이 장바구니에 추가되었습니다.

// 장바구니에 물건이 들어 있으면 아래와 같이 [ ORDER MENU ] 가 추가로 출력됩니다.
// 만약에 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않습니다. 
// 미출력일 때 4,5 번을 누르면 예외를 던저줘야 합니다.
아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.

[ MAIN MENU ]
1. Burgers
2. Drinks
3. Desserts
0. 종료      | 종료

[ ORDER MENU ]
4. Orders       | 장바구니를 확인 후 주문합니다.
5. Cancel       | 진행중인 주문을 취소합니다.
4 <- // 4를 입력

// 4번을 누르면 나오는 메뉴입니다.
아래와 같이 주문 하시겠습니까?

[ Orders ]
SmokeShack | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거

[ Total ]
W 8.9

1. 주문      2. 메뉴판
1 <-

// 1번을 누르면 나오는 메뉴입니다.
주문이 완료되었습니다. 금액은 W 8.9 입니다.

```

</details>

## 🌀 구조


## 🖥 구현 (Challenge Lv1)
- 메인 메뉴 선택 -> 메뉴 선택 -> 장바구니 추가<br>
  ![image](https://github.com/user-attachments/assets/3efc4e02-9d83-4e78-8035-6784762715ea)<br>
- 메뉴 선택 -> 뒤로 가기<br>
  ![image](https://github.com/user-attachments/assets/bf65e4e0-fa43-45b9-b434-75570f5a1d40)<br>
- 장바구니에 물건이 들어 있으면 [ ORDER MENU ] 가 추가로 출력<br>
  ![image](https://github.com/user-attachments/assets/e17c3c2d-8e4e-4836-a223-5ef21099f479)<br>
- 장바구니 초기화 -> 장바구니에 물건이 들어 있지 않다면 [ ORDER MENU ] 가 출력되지 않는다.<br>
  ![image](https://github.com/user-attachments/assets/fb14fab2-1cf2-4e4c-9d6e-0eb0466e3612)<br>
- 장바구니 확인 후 주문<br>
![image](https://github.com/user-attachments/assets/3304abcc-0972-42a8-8aec-1bb07841b6c3)<br>


  
## ⚠️ 에러 처리
- 입력 오류<br>
  ![image](https://github.com/user-attachments/assets/ae284c3b-9cfe-4f71-b8b8-cad27b863fef)
  ![image](https://github.com/user-attachments/assets/cdfb26c3-45a5-4353-94a8-ccb0e5a6599b)<br>

- [ ORDER MENU ] 미출력일 때 4,5 번을 누를 경우<br>
  ![image](https://github.com/user-attachments/assets/f5817627-6813-454c-a5df-9e5b8059a59c)<br>

## 💬 고찰
- 계산기 과제 진행했을 때에는 객체를 생성하고 어떻게 사용해야 할 지 막막했었는데 키오스크 과제를 하면서 객체 활용에 대해 많이 배웠고, 이제는 어렵지 않다!
- 도전 기능부터 코드 구조가 많이 복잡해져서 리팩토링 하는 데에 시간이 많이 들어 아쉬웠다. (리팩토링을 하긴 했지만 완벽하게 하지 못함..) 도식화, 순서도 등을 설계했더라면..!
- 코드의 구조화와 설계의 중요성을 깨달았다.
