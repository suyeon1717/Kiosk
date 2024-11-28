package com.example.kiosk.challenge_lv1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 속성(필드)
    List<Menu> menu;
    Scanner sc;

    // 생성자
    public Kiosk(List<Menu> menu){
        this.menu = menu;
        this.sc = new Scanner(System.in);
    }

    public void start(){

        // 장바구니 생성
        Cart cart = new Cart();

        // 장바구니 주문 완료 변수
        boolean orderComplete = false;

        // 반복문 시작
        while(true){

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            mainMenu();

            // * 장바구니가 비어있는 상황 *
            if(!cart.getCartStatus()){

                // *[Main Menu]*
                //숫자 입력 받기
                int mainChoiceNum = userSelect(0, menu.size());
                if(mainChoiceNum == 0) break; // [ Main Menu ] 에서 0을 입력하면 프로그램 종료

                menuSelect(mainChoiceNum, cart); // 메뉴 선택 처리
            }

            // * 장바구니가 비어있지 않은 상황 *
            else {
                int ordersNum = menu.size()+1;
                int cancelNum = menu.size()+2;

                // *[ORDER MENU]*
                System.out.println("\n[ ORDER MENU ]");
                System.out.println(ordersNum + ". Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println(cancelNum + ". Cancel       | 진행중인 주문을 취소합니다.");

                //숫자 입력 받기
                int choiceNum = userSelect(0, cancelNum);

                // Orders 선택
                if(choiceNum == ordersNum){
                    System.out.println("아래와 같이 주문하시겠습니까?");
                    System.out.println("\n[ Orders ]");

                    // 장바구니에 담긴 메뉴 출력
                    cart.showCart();

                    // Total 금액 출력
                    System.out.println("\n[ Total ]");
                    System.out.println("W " + cart.getTotalPrice());

                    // 주문할 지 메뉴판으로 돌아갈 지 결정
                    // 숫자 입력받기
                    System.out.println("\n1. 주문      2. 메뉴판");
                    int backNum = userSelect(1,2);

                    // 주문하기 선택
                    if(backNum == 1){
                        System.out.printf("\n주문이 완료되었습니다. 금액은 W %.1f 입니다.",cart.getTotalPrice());
                        orderComplete = true;
                        break;
                    }
                    //메뉴판 선택
                    else
                        continue;
                }

                // Cancel 선택
                else if(choiceNum == cancelNum) {
                    System.out.println("\n장바구니를 초기화합니다.");
                    cart.setEmptyCart();
                    continue;
                }

                // Main Menu의 0 종료 선택
                else  if(choiceNum == 0)
                    break;

                // Main Menu의 메뉴 선택
                else{
                    menuSelect(choiceNum, cart);
                }

            }

            // 주문 완료
            if(orderComplete){
                break;
            }
        }
    }

    // [ MAIN MENU ] 출력하는 메서드
    void mainMenu(){
        System.out.println("\n[ MAIN MENU ]");
        for(Menu m : menu){
            System.out.println(menu.indexOf(m)+1 + ". " + m.getCategoryName());
        }
        System.out.println("0. 종료      | 종료");
    }

    // 숫자 입력 받는 메서드와 예외 처리
    int userSelect(int minIndex, int maxIndex){
        while(true){

            try{
                int n = sc.nextInt();
                // 메뉴 번호 외의 숫자를 입력했을 경우 throw Exception
                if(n >= minIndex && n <= maxIndex)
                    return n;
                throw new InputMismatchException();
            }catch (InputMismatchException e){
                System.out.println("다시 입력하세요.1");
                sc.nextLine();
            }
        }
    }

    // 선택한 메뉴 출력하는 메서드
    void showSelectedItem(MenuItem selectedItem){
        System.out.printf("%s | W %.1f | %s",
                selectedItem.getMenuName(),
                selectedItem.getMenuPrice(),
                selectedItem.getMenuInfo());
    }

    // 메뉴 선택하여 장바구니 추가하는 메서드
    void menuSelect(int n, Cart cart) {
        if (n < 0 || n > menu.size()) {
            System.out.println("잘못된 입력입니다. 다시 시도하세요.");
            return;
        }

        // 선택한 상위 메뉴 접근
        Menu selectedMenu = menu.get(n - 1);

        while (true) {
            // 하위 메뉴 출력
            selectedMenu.showMenuItem();

            // 사용자 입력 받기
            int menuChoiceNum = userSelect(0, selectedMenu.getMenuItems().size());
            if (menuChoiceNum == 0) break; // 0 입력 시 뒤로가기

            // 유효한 입력일 경우 하위 메뉴 선택
            MenuItem selectedItem = selectedMenu.getMenuItems().get(menuChoiceNum - 1);

            // 선택한 MenuItem 출력
            System.out.print("선택한 메뉴 : ");
            showSelectedItem(selectedItem);
            System.out.println();

            System.out.print("\n\"");
            showSelectedItem(selectedItem);
            System.out.println("\"");

            System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
            System.out.println("1. 확인        2. 취소");

            int addConfirmCart = userSelect(1, 2);

            if (addConfirmCart == 1) {
                // 장바구니에 추가
                cart.addToCart(selectedItem);
                System.out.println(selectedItem.getMenuName() + " 이 장바구니에 추가되었습니다.");
                break; // 장바구니에 추가 후 종료
            }
            sc.nextLine();
        }
    }


}
