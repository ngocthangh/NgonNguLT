package com.example.ngocthang.ngonngulaptrinh;

/**
 * Created by Ngoc Thang on 7/2/2016.
 */
public class Language {
    private String Name;
    private String Detail;
    private int Image;

    public Language(String name, String detail, int image) {
        Name = name;
        Detail = detail;
        Image = image;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String detail) {
        Detail = detail;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getImage() {
        return Image;
    }

    public void setImage(int image) {
        Image = image;
    }

}
