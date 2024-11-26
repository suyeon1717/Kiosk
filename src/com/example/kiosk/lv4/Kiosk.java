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
            boolean zeroEnd = true; // true : 0 입력하면 종료됨 , flase : 0 입력하면 뒤로가기
            int num, num2;

            System.out.println("[ MAIN MENU ]");
            for(Menu m : menu){
                System.out.println(menu.indexOf(m)+1 + ". " + m.categoryName);
            }
            System.out.println("0. 종료      | 종료");

            while (true){
                try{
                    num = sc.nextInt();
                    if(num < 0 || num > menu.size())
                        throw new InputMismatchException();
                    else if(num == 0)
                        break;
                    else{
                        menu.get(num-1).showMenuItem();
                        num2 = sc.nextInt();
                        if(num2 < 0 || num2 > menu.size())
                            throw new InputMismatchException();
                        else if(num2 == 0)
                            break;
                        else{
                            System.out.println(menu.get(num-1).menuItems.get(num2-1).menuName);
                            break;
                        }
                    }

                }catch (InputMismatchException e){
                    System.out.println("다시 입력하세요.");
                    continue;
                }

            }

            break;
        }


    }

    void showMainMenu(){
        for(Menu m : menu){
            System.out.println(menu.indexOf(m)+1 + ". " + m.categoryName);
        }
        System.out.println("0. 종료      | 종료");
    }

}
