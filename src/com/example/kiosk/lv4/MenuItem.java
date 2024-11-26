package com.example.kiosk.lv4;

/**
 * MenuItem: 개별 음식 항목을 관리하는 클래스 (lv2는 햄버거만 관리)
 */

public class MenuItem {

    // 속성(필드)
    String menuName;
    double menuPrice;
    String menuInfo;

    // 생성자
    public MenuItem(String menuName, double menuPrice, String menuInfo){
        this.menuName = menuName;
        this.menuPrice = menuPrice;
        this.menuInfo = menuInfo;
    }
}
