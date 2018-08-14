package com.example.salmanma.icecreamsatease;
//object class for recent orders
public class mcatrecent
{
    private String name,category,price,delivery,total;
    private int imgid,back;
    private boolean delivered;
    public mcatrecent(String name,String category,String price,String delivery,String total,Boolean delivered,int imgid,int back)
    {
        this.name=name;
        this.category=category;
        this.price=price;
        this.imgid=imgid;
        this.back=back;
        this.delivery=delivery;
        this.delivered=delivered;
        this.total=total;
    }
    public int getImgid() {
        return imgid;
    }

    public String getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }

    public int getBack() {
        return back;
    }

    public String getDelivery() {
        return delivery;
    }

    public String getTotal() {
        return total;
    }

    public boolean isDelivered() {
        return delivered;
    }

}
