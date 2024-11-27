package com.example.kiosk.challenge_lv1;

/**
 * MenuItem: 개별 음식 항목을 관리하는 클래스
 */

public class MenuItem {

    // 속성(필드)
    private String menuName;
    private double menuPrice;
    private String menuInfo;

    // 생성자
    public MenuItem(String menuName, double menuPrice, String menuInfo){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuInfo = menuInfo;
    }

    public MenuItem(){

    }

    // 기능

    //getter
    String getMenuName(){
        return menuName;
    }

    Double getMenuPrice(){
        return menuPrice;
    }

    String getMenuInfo(){
        return menuInfo;
    }
}