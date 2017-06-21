package com.mg_source.school;

/**
 * Created by said on 6/13/2017.
 */

public class Student {
    private String name;
    private String class_;
    private String img;
    private String note;

    public Student(){

    }

    public Student(String name, String class_, String img, String note) {
        this.name = name;
        this.class_ = class_;
        this.img = img;
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass_() {
        return class_;
    }

    public void setClass_(String class_) {
        this.class_ = class_;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
