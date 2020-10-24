package com.example.final_project;

import android.widget.ImageView;

import java.util.ArrayList;

public class FavClass {
    public static ArrayList<String> name;
    public static ArrayList<String> date;
    public static ArrayList<Integer> img;
    public static ArrayList<String> pdf;
    public static ArrayList<String> sum;

    public FavClass(ArrayList<String> name,ArrayList<String> date,ArrayList<Integer> img,ArrayList<String> pdf,ArrayList<String> sum) {
        this.name = name;
        this.date = date;
        this.img = img;
        this.pdf = pdf;
        this.sum = sum;


    }
}
