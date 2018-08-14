package com.example.salmanma.icecreamsatease;
//object class for new launch
public class mcatnew
{
    public String back,category,link,name,price;

    public mcatnew() {

    }

    public mcatnew(String back, String category, String link, String name, String price) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.link = link;
        this.back = back;
    }

    public String getBack() {
        return back;
    }

    public void setBack(String back) {
        this.back = back;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
