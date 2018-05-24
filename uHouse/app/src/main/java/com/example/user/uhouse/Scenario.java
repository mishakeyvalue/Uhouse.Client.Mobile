package com.example.user.uhouse;

/**
 * Created by User on 022 22.05.18.
 */

public class Scenario {
    private int image_src;

    public int getImage_src() {
        return image_src;
    }

    public void setImage_src(int image_src) {
        this.image_src = image_src;
    }

    public String getTime_table() {
        return time_table;
    }

    public void setTime_table(String time_table) {
        this.time_table = time_table;
    }

    private String time_table;

    public Scenario(){

    }

    public Scenario(int image_src, String time_table) {
        this.image_src = image_src;
        this.time_table = time_table;

    }


}
