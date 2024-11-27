package com.example.kiosk.challenge_lv1;

import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Kiosk {

    // 속성(필드)
    List<Menu> menu;

    // 생성자
    public Kiosk(List<Menu> menu){
        this.menu = menu;
    }

    // 기능
    public void start(){

        // 스캐너 선언
        Scanner sc = new Scanner(System.in);

        // 장바구니 생성
        Cart cart = new Cart();

        // 장바구니에 메뉴가 들어있는지 여부
        boolean cartIsExist = false;

        // 장바구니 금액
        double totalPrice = 0;

        // 장바구니 주문 완료
        boolean orderDone = false;

        // 반복문 시작
        while(true){
            int n1;
            int n2 = 0;

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("\n[ MAIN MENU ]");
            for(Menu m : menu){
                System.out.println(menu.indexOf(m)+1 + ". " + m.getCategoryName());
            }
            System.out.println("0. 종료      | 종료");

            if(!cartIsExist){
                // 숫자 입력 받기
                try{
                    n1 = sc.nextInt();
                    // 메뉴 번호 외의 숫자를 입력했을 경우 throw Exception
                    if(n1 < 0 || n1 > menu.size())
                        throw new InputMismatchException();
                        // 0 입력 시 프로그램 종료
                    else if(n1 == 0)
                        break;
                }catch (InputMismatchException e){
                    System.out.println("다시 입력하세요.");
                    continue;
                }

                // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
                Menu selectedMenu = menu.get(n1-1);

                while (true){
                    // MenuItem List 출력
                    selectedMenu.showMenuItem();

                    // 숫자 입력 받기
                    try{
                        n2 = sc.nextInt();
                        // 메뉴 번호 외의 숫자를 입력했을 경우 throw Exception
                        if(n2 < 0 || n2 > selectedMenu.getMenuItems().size())
                            throw new InputMismatchException();
                            // 0 입력 시 프로그램 뒤로가기
                        else if(n2 == 0)
                            break;
                    }catch (InputMismatchException e) {
                        System.out.println("다시 입력하세요.");
                        continue;
                    }
                    // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                    MenuItem selectedItem = selectedMenu.getMenuItems().get(n2 - 1);

                    // 선택한 MenuItem 출력
                    System.out.print("선택한 메뉴 : ");
                    showSelectedItem(selectedItem);
                    System.out.println();

                    System.out.print("\n\"");
                    showSelectedItem(selectedItem);
                    System.out.println("\"");

                    System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                    System.out.println("1. 확인        2. 취소");

                    while (true){
                        try{
                            // 장바구니에 추가 여부 입력받기
                            int n3 = sc.nextInt();

                            // 장바구니에 추가 O
                            if(n3 == 1){
                                cart.addToCart(selectedItem);
                                System.out.println(selectedItem.getMenuName() + " 이 장바구니에 추가되었습니다.");
                                cartIsExist = true;
                                System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                                break;
                            }
                            // 장바구니에 추가 X
                            else if(n3 == 2)
                                break;

                                // 입력 에러 처리
                            else
                                throw new InputMismatchException();
                        }catch (InputMismatchException e){
                            System.out.println("다시 입력하세요.");
                        }
                    }


                    break;
                }
            }
            else {
                int ordersNum = menu.size()+1;
                int cancelNum = menu.size()+2;
                System.out.println("\n[ ORDER MENU ]");
                System.out.println(ordersNum + ". Orders       | 장바구니를 확인 후 주문합니다.");
                System.out.println(cancelNum + ". Cancel       | 진행중인 주문을 취소합니다.");

                while (true){
                    try{
                        int n4 = sc.nextInt();

                        // 4. Orders 선택
                        if(n4 == ordersNum){
                            System.out.println("아래와 같이 주문하시겠습니까?");
                            System.out.println("\n[ Orders ]");

                            // 장바구니에 담긴 메뉴 출력
                            cart.showCart();

                            // Total 금액 출력
                            totalPrice = cart.getTotalPrice();
                            System.out.println("\n[ Total ]");
                            System.out.println("W " + totalPrice);

                            // 주문할 지 메뉴판으로 돌아갈 지 결정
                            System.out.println("\n1. 주문      2. 메뉴판");
                            while(true){
                                try{
                                    int n5 = sc.nextInt();

                                    if(n5 == 1){
                                        System.out.printf("\n주문이 완료되었습니다. 금액은 W %.1f 입니다.",totalPrice);
                                        orderDone = true;
                                        break;
                                    }
                                    else
                                        break;
                                }catch (InputMismatchException e){
                                    System.out.println("다시 입력하세요.");
                                }
                            }

                        }
                        // 5. Cancel 선택
                        else if(n4 == cancelNum) {
                            System.out.println("\n 장바구니를 초기화합니다.");
                            cart.setEmptyCart();
                            cartIsExist = false;
                            break;
                        }
                        // 유효하지 않은 숫자 입력 처리
                        else
                            throw new InputMismatchException();
                    }catch (InputMismatchException e){
                        System.out.println("다시 입력하세요.");
                    }

                    break;
                }

            }

            // 주문 완료
            if(orderDone){
                break;
            }


        }

    }

    void showSelectedItem(MenuItem selectedItem){
        System.out.printf("%s | W %.1f | %s",
                selectedItem.getMenuName(),
                selectedItem.getMenuPrice(),
                selectedItem.getMenuInfo());
    }

    void aaaaa(Cart cart){
        Scanner sc = new Scanner();
        int n1, n2;

        while (true){
            // 숫자 입력 받기
            try{
                n1 = sc.nextInt();
                // 메뉴 번호 외의 숫자를 입력했을 경우 throw Exception
                if(n1 < 0 || n1 > menu.size())
                    throw new InputMismatchException();
                    // 0 입력 시 프로그램 종료
                else if(n1 == 0)
                    break;
            }catch (InputMismatchException e){
                System.out.println("다시 입력하세요.");
                continue;
            }

            // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
            Menu selectedMenu = menu.get(n1-1);

            while (true){
                // MenuItem List 출력
                selectedMenu.showMenuItem();

                // 숫자 입력 받기
                try{
                    n2 = sc.nextInt();
                    // 메뉴 번호 외의 숫자를 입력했을 경우 throw Exception
                    if(n2 < 0 || n2 > selectedMenu.getMenuItems().size())
                        throw new InputMismatchException();
                        // 0 입력 시 프로그램 뒤로가기
                    else if(n2 == 0)
                        break;
                }catch (InputMismatchException e) {
                    System.out.println("다시 입력하세요.");
                    continue;
                }
                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                MenuItem selectedItem = selectedMenu.getMenuItems().get(n2 - 1);

                // 선택한 MenuItem 출력
                System.out.print("선택한 메뉴 : ");
                showSelectedItem(selectedItem);
                System.out.println();

                System.out.print("\n\"");
                showSelectedItem(selectedItem);
                System.out.println("\"");

                System.out.println("위 메뉴를 장바구니에 추가하시겠습니까?");
                System.out.println("1. 확인        2. 취소");

                while (true){
                    try{
                        // 장바구니에 추가 여부 입력받기
                        int n3 = sc.nextInt();

                        // 장바구니에 추가 O
                        if(n3 == 1){
                            cart.addToCart(selectedItem);
                            System.out.println(selectedItem.getMenuName() + " 이 장바구니에 추가되었습니다.");
                            cartIsExist = true;
                            System.out.println("아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.");
                            break;
                        }
                        // 장바구니에 추가 X
                        else if(n3 == 2)
                            break;

                            // 입력 에러 처리
                        else
                            throw new InputMismatchException();
                    }catch (InputMismatchException e){
                        System.out.println("다시 입력하세요.");
                    }
                }


                break;
            }
        }

    }


}
