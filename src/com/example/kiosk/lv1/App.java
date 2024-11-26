package com.example.kiosk.lv1;

import java.util.Scanner;

/**
 * 키오스크 Lv1. 기본적인 키오스크
 * 햄버거 메뉴 출력 및 선택하기
 * - Scanner를 사용하여 여러 햄버거 메뉴를 출력합니다.
 * - 제시된 메뉴 중 입력받은 숫자에 따라 다른 로직을 실행하는 코드를 작성합니다.
 * - 반복문을 이용해서 특정 번호가 입력되면 프로그램을 종료합니다.
 */
public class App {
    public static void main(String[] args) {

        System.out.println("[ SHAKESHACK MENU ]");
        String[] menu = {
        "1. ShackBurger   | W 6.9 | 토마토, 양상추, 쉑소스가 토핑된 치즈버거",
        "2. SmokeShack    | W 8.9 | 베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거",
        "3. Cheeseburger  | W 6.9 | 포테이토 번과 비프패티, 치즈가 토핑된 치즈버거",
        "4. Hamburger     | W 5.4 | 비프패티를 기반으로 야채가 들어간 기본버거",
        "0. 종료      | 종료"};

        for(String m : menu){
            System.out.println(m);
        }

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.print("메뉴를 선택하세요: ");
            int num = sc.nextInt();

            if(num == 0) {
                System.out.println("프로그램을 종료합니다.");
                break;
            }
            else if(num == 1 || num == 2 || num == 3 || num == 4)
                System.out.println(menu[num-1]);
            else
                System.out.print("다시 ");
        }

        sc.close();

    }
}
