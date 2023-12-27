package com.example.log_up;

public class ItemSport {
    private  int img;
    private String title;
    private String describe;
    private int price;


    public ItemSport(int img, String title, String describe, int price) {
        this.img = img;
        this.title = title;
        this.describe = describe;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
