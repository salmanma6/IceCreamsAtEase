package com.example.salmanma.icecreamsatease;

import com.google.android.gms.maps.model.LatLng;
import com.google.maps.android.clustering.ClusterItem;

/**
 * Created by RAANSAS on 14-10-2017.
 */

public class Shop implements ClusterItem {
    public String lat,lng,photos,name,rating,tag;
    public LatLng latLng;
    public Shop()
    {

    }
    public Shop(String lat, String lng, String name, String photos, String rating, String tag) {
        this.lat = lat;
        this.lng = lng;
        this.photos = photos;
        this.name = name;
        this.rating = rating;
        this.tag = tag;
    }

    public java.lang.String getLat() {
        return lat;
    }

    public void setLat(java.lang.String lat) {
        this.lat = lat;
    }

    public java.lang.String getLng() {
        return lng;
    }

    public void setLng(java.lang.String lng) {
        this.lng = lng;
    }

    public java.lang.String getPhotos() {
        return photos;
    }

    public void setPhotos(java.lang.String photos) {
        this.photos = photos;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public java.lang.String getRating() {
        return rating;
    }

    public void setRating(java.lang.String rating) {
        this.rating = rating;
    }

    public java.lang.String getTag() {
        return tag;
    }

    public void setTag(java.lang.String tag) {
        this.tag = tag;
    }

    @Override
    public LatLng getPosition() {
        latLng=new LatLng(Double.parseDouble(lat),Double.parseDouble(lng));
        return latLng;
    }

    @Override
    public String getTitle() {
        return name;
    }

    @Override
    public String getSnippet() {
        return tag;
    }
}
