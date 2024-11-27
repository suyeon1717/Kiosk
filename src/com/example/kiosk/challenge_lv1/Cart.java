package com.example.kiosk.challenge_lv1;

import java.util.ArrayList;
import java.util.List;

/**
 * 장바구니를 관리하는 클래스
 */
public class Cart extends MenuItem{

    // 속성(필드)
    private List<MenuItem> cartMenuItems;

    private boolean cartStatus = false;
    // 생성자
//    Cart(List<MenuItem> cartMenuItems){
//
//        this.cartMenuItems = cartMenuItems;
//    }

//    Cart(MenuItem menuItem){
//    }

    public Cart() {
        cartMenuItems = new ArrayList<MenuItem>();
    }

    // 기능

    // 장바구니에 메뉴 담기
    public void addToCart(MenuItem menuItem){
        this.cartMenuItems.add(menuItem);
        cartStatus = true;
    }

    // 장바구니에 담긴 메뉴 출력
    public void showCart(){
        for(MenuItem m : this.cartMenuItems)
            System.out.printf("%s | W %.1f | %s\n",
                    m.getMenuName(),
                    m.getMenuPrice(),
                    m.getMenuInfo());
    }

    // 장바구니 초기화
    public void setEmptyCart(){
        this.cartMenuItems.clear();
        cartStatus = false;
    }

    // 장바구니 상태 반환
    public boolean getCartStatus(){
        return cartStatus;
    }


    // 장바구니 총 금액 반환
    public Double getTotalPrice(){
        double totalPrice = 0;
        for(MenuItem m : this.cartMenuItems)
            totalPrice += m.getMenuPrice();

        return totalPrice;
    }

}
