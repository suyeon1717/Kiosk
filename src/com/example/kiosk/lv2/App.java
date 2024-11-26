package com.example.kiosk.lv2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 키오스크 Lv2. 객체 지향 설계를 적용해 햄버거 메뉴를 클래스로 관리하기
 * 햄버거 메뉴를 MenuItem 클래스와 List를 통해 관리
 */
public class App {
    public static void main(String[] args) {
        List<MenuItem> menuItems = new ArrayList<>();

        // MenuItem 추가
        menuItems.add(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        menuItems.add(new MenuItem("Hamburger", 6.9, "비프패티를 기반으로 야채가 들어간 기본버거"));

        Scanner sc = new Scanner(System.in);
        System.out.println("[ SHAKESHACK MENU ]");

        // 반복문을 활용해 menuItems를 탐색하면서 하나씩 접근
        int i = 1;
        for (MenuItem m : menuItems){
            System.out.print(i + ". " + m.menuName);
            for(int j=0; j<14-m.menuName.length(); j++) // 메뉴명 옆에 띄어쓰기를 입력해서 간격 맞추기 (14-글자수)
                System.out.print(" ");
            System.out.println("| W " + m.menuPrice + " | " + m.menuInfo);
            i++;
        }
        System.out.println("0. 종료           | 종료");

        // 숫자를 입력 받기
        // 입력된 숫자에 따른 처리
        while(true){
            System.out.print("메뉴를 선택하세요 : ");
            int num = sc.nextInt();

            if(num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else if(num == 1 || num == 2 || num == 3 || num == 4){
                System.out.println("선택한 메뉴 : " + menuItems.get(num-1).menuName +
                        " | W " + menuItems.get(num-1).menuPrice +
                        " | " + menuItems.get(num-1).menuInfo);
            }
            else
                System.out.print("다시 ");
        }

        sc.close();

    }
}
