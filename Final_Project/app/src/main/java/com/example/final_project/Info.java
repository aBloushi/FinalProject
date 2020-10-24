package com.example.final_project;

import android.widget.ImageView;

public class Info {
    public static String name;
    public static String email;
    public static String pass;
    public static String phone;
    public static ImageView image;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Info.name = name;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Info.email = email;
    }

    public static String getPass() {
        return pass;
    }

    public static void setPass(String pass) {
        Info.pass = pass;
    }

    public static String getPhone() {
        return phone;
    }

    public static void setPhone(String phone) {
        Info.phone = phone;
    }

    public static ImageView getImage() {
        return image;
    }

    public static void setImage(ImageView image) {
        Info.image = image;
    }
}
