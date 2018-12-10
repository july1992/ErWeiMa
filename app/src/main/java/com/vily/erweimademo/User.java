package com.vily.erweimademo;

/**
 * description :
 * Author : Vily
 * Date : 2018/03/15
 * Time : 11:20
 */

public class User {
    private int icon;
    private String name;

    public User( int icon, String name) {
        this.icon = icon;
        this.name = name;
    }


    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
