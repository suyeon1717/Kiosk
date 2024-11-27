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

    void showSelectedItem(MenuItem selectedItem){
        System.out.printf("%s | W %.1f | %s",
                selectedItem.getMenuName(),
                selectedItem.getMenuPrice(),
                selectedItem.getMenuInfo());
    }


}
