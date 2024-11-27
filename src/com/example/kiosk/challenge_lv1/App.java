package com.example.kiosk.challenge_lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * 키오스크 도전 Lv1. 장바구니 및 구매하기 기능을 추가하기
 * [요구사항]
 * 1. 장바구니 생성 및 관리 기능
 * 2. 장바구니 출력 및 금액 계산
 * 3. 장바구니 담기 기능
 * 4. 주문 기능
 *
 */
public class App {
    public static void main(String[] args) {

        // Menu 객체 생성하면서 카테고리 이름 설정
        List<Menu> menu = new ArrayList<Menu>();

        Menu burgersMenu = new Menu("Burgers", new ArrayList<>());
        Menu drinksMenu = new Menu("Drinks", new ArrayList<>());
        Menu dessertsMenu = new Menu("Desserts", new ArrayList<>());

        menu.add(burgersMenu);
        menu.add(drinksMenu);
        menu.add(dessertsMenu);

        burgersMenu.setMenuItem(new MenuItem("ShackBurger", 6.9, "토마토, 양상추, 쉑소스가 토핑된 치즈버거"));
        burgersMenu.setMenuItem(new MenuItem("SmokeShack", 8.9, "베이컨, 체리 페퍼에 쉑소스가 토핑된 치즈버거"));
        burgersMenu.setMenuItem(new MenuItem("Cheeseburger", 6.9, "포테이토 번과 비프패티, 치즈가 토핑된 치즈버거"));
        burgersMenu.setMenuItem(new MenuItem("Hamburger", 6.9, "비프패티를 기반으로 야채가 들어간 기본버거"));

        drinksMenu.setMenuItem(new MenuItem("Coke", 2.0, "코카콜라"));
        drinksMenu.setMenuItem(new MenuItem("Sprite", 2.0, "스프라이트"));
        drinksMenu.setMenuItem(new MenuItem("Fanta", 2.0, "환타 파인애플 맛"));
        drinksMenu.setMenuItem(new MenuItem("Coke Zero", 2.0, "제로 코카콜라"));

        dessertsMenu.setMenuItem(new MenuItem("Ice cream", 1.5, "소프트콘"));
        dessertsMenu.setMenuItem(new MenuItem("Cookie", 1.5, "마카다미아 쿠키"));


        // Kiosk 객체 생성
        Kiosk kiosk = new Kiosk(menu);

        // Kiosk 내 시작하는 함수 호출
        kiosk.start();
    }
}