package com.example.kiosk.lv2;

public class MenuItem {

    /**
     * MenuItem: 개별 음식 항목을 관리하는 클래스
     */

    // 속성(필드)
    String menuName;
    double menuPrice;
    String menuInfo;

    // 생성자
    MenuItem(String menuName, double menuPrice, String menuInfo){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuInfo = menuInfo;
    }
}
