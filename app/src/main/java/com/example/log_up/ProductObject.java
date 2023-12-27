package com.example.log_up;

import java.io.Serializable;

public class ProductObject implements Serializable {
    private int id;
    private String danhmucSanPham;
    private String tenSanPham;
    private String giaSanPham;
    private String tieudeSanPham;
    private String motaSanPham;
    private String imageUrl;
    private String verify;
    private String diachiSanPham;
    private String sodienthoaiUser;

    public ProductObject() {
    }

    public ProductObject(int id, String danhmucSanPham, String tenSanPham, String giaSanPham, String tieudeSanPham, String motaSanPham,String diachiSanPham ,String imageUrl,String verify) {
        this.id = id;
        this.danhmucSanPham = danhmucSanPham;
        this.tenSanPham = tenSanPham;
        this.giaSanPham = giaSanPham;
        this.tieudeSanPham = tieudeSanPham;
        this.motaSanPham = motaSanPham;
        this.diachiSanPham = diachiSanPham;
        this.imageUrl = imageUrl;
        this.verify = verify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDanhmucSanPham() {
        return danhmucSanPham;
    }


    public String getTenSanPham() {
        return tenSanPham;
    }



    public String getGiaSanPham() {
        return giaSanPham;
    }



    public String getTieudeSanPham() {
        return tieudeSanPham;
    }

    public String getDiachiSanPham(){ return diachiSanPham; }

    public String getMotaSanPham() {
        return motaSanPham;
    }



    public String getImageUrl() {
        return imageUrl;
    }

    public String getVerify() {return verify;}

    public String getSodienthoaiUser() {
        return sodienthoaiUser;
    }
}
