package com.example.compshopper3;

public class MyList {

    String itemtitle;
    String price1;
    String price2;
    String price3;

    public MyList() {
    }

    public MyList(String itemtitle, String price1, String price2, String price3) {
        this.itemtitle = itemtitle;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
    }

    public String getItemtitle() {
        return itemtitle;
    }

    public void setItemtitle(String itemtitle) {
        this.itemtitle = itemtitle;
    }

    public String getPrice1() {
        return price1;
    }

    public void setPrice1(String price1) {
        this.price1 = price1;
    }

    public String getPrice2() {
        return price2;
    }

    public void setPrice2(String price2) {
        this.price2 = price2;
    }

    public String getPrice3() {
        return price3;
    }

    public void setPrice3(String price3) {
        this.price3 = price3;
    }
}
