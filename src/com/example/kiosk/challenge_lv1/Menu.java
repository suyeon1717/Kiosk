package com.example.kiosk.challenge_lv1;

import java.util.List;


/**
 * Menu: MenuItem 클래스를 관리하는 클래스
 * 버거 메뉴, 음료 메뉴 등 각 카테고리 내에 여러 MenuItem을 포함한다.
 * List<MenuItem> 은 Kiosk 클래스가 관리하기에 적절하지 않으므로 Menu 클래스가 관리하도록 변경한다.
 * 여러 버거들을 포함하는 상위 개념 ‘버거’ 같은 카테고리 이름 필드를 갖는다.
 * 메뉴 카테고리 이름을 반환하는 메서드가 구현되어야 한다.
 */

public class Menu {

    // 속성(필드)
    private final List<MenuItem> menuItems;
    private final String categoryName;

    // 생성자
    public Menu(String categoryName, List<MenuItem> menuItems){
        this.menuItems = menuItems;
        this.categoryName = categoryName;
    }

    // 기능

    // List에 들어있는 MenuItem을 순차적으로 보여주는 함수
    public void showMenuItem(){

        // [ 카테고리명 ]
        System.out.println("\n" + "[ " + categoryName.toUpperCase() + " MENU ]");

        for (MenuItem m : menuItems){
            System.out.print(menuItems.indexOf(m)+1 + ". " + m.getMenuName());
            for(int j=0; j<14-m.getMenuName().length(); j++) // 메뉴명 옆에 띄어쓰기를 입력해서 간격 맞추기 (14-글자수)
                System.out.print(" ");
            System.out.println("| W " + m.getMenuPrice() + " | " + m.getMenuInfo());
        }
        System.out.println("0. 뒤로가기");
    }

    // 메뉴를 리스트에 저장하는 메서드
    public void setMenuItem(MenuItem menuItem){
        this.menuItems.add(menuItem);
    }

    // 메뉴 리스트를 반환하는 메서드
    public List<MenuItem> getMenuItems(){
        return menuItems;
    }

    // 메뉴 카테고리 이름을 반환하는 메서드
    public String getCategoryName(){
        return categoryName;
    }

}

