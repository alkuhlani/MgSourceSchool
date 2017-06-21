package com.mg_source.school;

/**
 * Created by said on 6/17/2017.
 */

public class Stuednt_Com {
    private int img;
    private String title;
    private String desc;

    public Stuednt_Com(){

    }
    public Stuednt_Com(int img, String title, String desc) {
        this.img = img;
        this.title = title;
        this.desc = desc;
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

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
