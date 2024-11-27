package com.example.kiosk.challenge_lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * 장바구니를 관리하는 클래스
 */
public class Cart extends MenuItem{

    // 속성(필드)
    private List<MenuItem> cartMenuItems;

    // 생성자
//    Cart(List<MenuItem> cartMenuItems){
//
//        this.cartMenuItems = cartMenuItems;
//    }

//    Cart(MenuItem menuItem){
//    }

    Cart() {
        cartMenuItems = new ArrayList<MenuItem>();
    }

    // 기능

    // 장바구니에 메뉴 담기
    public void addToCart(MenuItem menuItem){
        cartMenuItems.add(menuItem);
    }

    // 장바구니 리턴
    public List<MenuItem> showCart(){
        return cartMenuItems;
    }
}
