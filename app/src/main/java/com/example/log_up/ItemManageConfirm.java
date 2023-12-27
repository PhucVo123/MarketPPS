package com.example.log_up;

public class ItemManageConfirm {
    private String name;
    private String price;
    private int img;

    public ItemManageConfirm() {
    }

    public ItemManageConfirm(String name, String price, int img) {
        this.name = name;
        this.price = price;
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
