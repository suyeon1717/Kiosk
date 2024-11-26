package com.example.kiosk.lv3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Kiosk: 키오스크 프로그램의 메뉴를 관리하고 사용자 입력을 처리하는 클래스
 * main 함수에서 관리하던 전체 순서 제어를 Kiosk 클래스를 통해 관리
 */

public class Kiosk {

    // 속성(필드)
    List<MenuItem> menuItems;

    // 생성자
    public Kiosk(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }

    // 기능
    public void start(){
        Scanner sc = new Scanner(System.in);
        boolean zeroEnd = true; // true : 0 입력하면 종료됨 , flase : 0 입력하면 뒤로가기

        System.out.println("[ SHAKESHACK MENU ]");

        // 메뉴 출력
        showMenu();

        // 숫자를 입력 받기
        // 입력된 숫자에 따른 처리
        while(true){

            int num = sc.nextInt();

            if(zeroEnd && num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else if(num == 1 || num == 2 || num == 3 || num == 4){
                System.out.println("선택한 메뉴 : " + menuItems.get(num-1).menuName +
                        " | W " + menuItems.get(num-1).menuPrice +
                        " | " + menuItems.get(num-1).menuInfo);
                System.out.print("번호를 입력하세요. (뒤로가기 : 0) >> ");
                zeroEnd = false;

            }
            else if(!zeroEnd && num ==0){
                zeroEnd = true;
                showMenu();
            }

            else{
                System.out.print("잘못 입력하였습니다. 메뉴 번호를 입력하세요. (뒤로가기 : 0) >> ");
                zeroEnd = false;
            }

        }

        sc.close();

    }

    // 메뉴를 보여주는 함수
    public void showMenu(){
        int i = 1;
        for (MenuItem m : menuItems){
            System.out.print(i + ". " + m.menuName);
            for(int j=0; j<14-m.menuName.length(); j++) // 메뉴명 옆에 띄어쓰기를 입력해서 간격 맞추기 (14-글자수)
                System.out.print(" ");
            System.out.println("| W " + m.menuPrice + " | " + m.menuInfo);
            i++;
        }
        System.out.println("0. 종료           | 종료");
        System.out.print("메뉴를 선택하세요 : ");
    }
}
