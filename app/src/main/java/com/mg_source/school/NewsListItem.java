package com.mg_source.school;

import java.security.PublicKey;

/**
 * Created by said on 6/15/2017.
 */

public class NewsListItem {
    public int id;
    public String new_;
    public int img;

    public NewsListItem() {

    }

    public NewsListItem(int id, String new_, int img) {

        this.id = id;
        this.new_ = new_;
        this.img = img;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNew_() {
        return new_;
    }

    public void setNew_(String new_) {
        this.new_ = new_;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }
}
