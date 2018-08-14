/**
 * Created by Salman M.A on 04-08-2017.
 */
package com.example.salmanma.icecreamsatease;
//object class for main menu
public class mcat {
    public String name;
    public String imgid;

    public mcat(String name, String imgid) {
        this.name = name;
        this.imgid = imgid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgid() {
        return imgid;
    }

    public void setImgid(String imgid) {
        this.imgid = imgid;
    }
}