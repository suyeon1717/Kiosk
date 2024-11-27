package com.example.kiosk.lv4;

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

        // 반복문 시작
        while(true){
            int n1;
            int n2 = 0;

            // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력
            System.out.println("\n[ MAIN MENU ]");
            for(Menu m : menu){
                System.out.println(menu.indexOf(m)+1 + ". " + m.categoryName);
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

            // MenuItem List 출력
            selectedMenu.showMenuItem();

            while (true){
                // 숫자 입력 받기
                try{
                    n2 = sc.nextInt();
                    // 메뉴 번호 외의 숫자를 입력했을 경우 throw Exception
                    if(n2 < 0 || n2 > selectedMenu.menuItems.size())
                        throw new InputMismatchException();
                        // 0 입력 시 프로그램 뒤로가기
                    else if(n2 == 0)
                        break;
                }catch (InputMismatchException e) {
                    System.out.println("다시 입력하세요.");
                    continue;
                }
                // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
                MenuItem selectedItem = selectedMenu.menuItems.get(n2 - 1);

                // 선택한 MenuItem 출력
                System.out.printf("선택한 메뉴 : %s | W %.1f | %s%n",
                        selectedItem.menuName,
                        selectedItem.menuPrice,
                        selectedItem.menuInfo);
                break;
            }

        }

    }


}
