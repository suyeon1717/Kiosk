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
        // 반복문 시작

        // List와 Menu 클래스 활용하여 상위 카테고리 메뉴 출력

        // 숫자 입력 받기

        // 입력 받은 숫자가 올바르다면 인덱스로 활용하여 List에 접근하기
        // List<Menu>에 인덱스로 접근하면 Menu만 추출할 수 있겠죠?

        // Menu가 가진 List<MenuItem>을 반복문을 활용하여 햄버거 메뉴 출력

        // 숫자 입력 받기
        // 입력 받은 숫자가 올바르다면 인덱스로 활용해서 Menu가 가지고 있는 List<MenuItem>에 접근하기
        // menu.getMenuItems().get(i); 같은 형식으로 하나씩 들어가서 얻어와야 합니다.

        Scanner sc = new Scanner(System.in);

        while(true){
            int n1;
            int n2 = 0;

            // *메인 메뉴* 출력
            System.out.println("\n[ MAIN MENU ]");
            for(Menu m : menu){
                System.out.println(menu.indexOf(m)+1 + ". " + m.categoryName);
            }
            System.out.println("0. 종료      | 종료");

            // *메인 메뉴* 숫자 입력
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

            Menu selectedMenu = menu.get(n1-1);

            // *상세 메뉴* MenuItem List 출력
            selectedMenu.showMenuItem();

            // *상세 메뉴* MenuItem 입력
            while (true){
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
                // 선택한 MenuItem
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
