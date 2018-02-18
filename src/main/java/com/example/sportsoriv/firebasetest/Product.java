package com.example.sportsoriv.firebasetest;

/**
 * Created by sportsoriv on 12/10/17.
 */

public class Product {
    private String image;
    private String name;
    private String price;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private String latitude;
    private String longitude;


    public Product (String image, String name, String price, String answer2, String answer3, String answer4, String answer5, String answer6 , String latitude, String longitude){
        this.image = image;
        this.name = name;
        this.price = price;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;
        this.latitude = latitude;
        this.longitude = longitude;


    }

    public String getImage() {
        return image;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public String getAnswer2() {
        return answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }
}
