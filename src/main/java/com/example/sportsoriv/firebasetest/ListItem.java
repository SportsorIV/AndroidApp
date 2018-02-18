package com.example.sportsoriv.firebasetest;

import android.widget.ImageView;

/**
 * Created by sportsoriv on 7/5/17.
 */

public class ListItem {
    private  String head;
    private  String desc;
    private  String trackid;
    private  String answer3;
    private  String answer4;
    private  String answer5;
    private  String answer6;
    private  String image;
    private  String latitude;
    private  String longitutde;
    private  ImageView imageView;



    public ListItem(String head, String desc, String trackid, String answer3, String answer4, String answer5, String answer6, String image, String latitude, String longitutde) {
        this.head = head;
        this.desc = desc;
        this.trackid = trackid;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.answer5 = answer5;
        this.answer6 = answer6;
        this.image = image;
        this.latitude = latitude;
        this.longitutde = longitutde;


    }



    public String getHead() {
        return head;
    }

    public String getDesc() {
        return desc;
    }
    public String getTrackid(){

        return trackid;

    }

    public String getAnswer3() {
        return answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public String getAnswer5() {
        return  answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public String getImage() {
        return image;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitutde() {
        return longitutde;
    }


}
