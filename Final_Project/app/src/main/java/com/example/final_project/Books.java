package com.example.final_project;

import java.io.Serializable;

public class Books implements Serializable {
    private String name;
    private int image;
    private String releaseDate;
    private String sum;
    private String pdfname;
    private  String url;



    public Books(String name, int image, String releaseDate, String sum,String pdfname,String url) {
        this.name = name;
        this.image = image;
        this.releaseDate = releaseDate;
        this.sum = sum;
        this.pdfname = pdfname;
        this.url = url;
    }

    public String getPdfname() {
        return pdfname;
    }

    public void setPdfname(String pdfname) {
        this.pdfname = pdfname;
    }

    public String getSum() {
        return sum;
    }

    public void setSum(String sum) {
        this.sum = sum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
