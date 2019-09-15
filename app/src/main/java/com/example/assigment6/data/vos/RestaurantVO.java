package com.example.assigment6.data.vos;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.Index;
import android.arch.persistence.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "restaurant",
        indices = {@Index(value = "id",unique = true)})
public class RestaurantVO {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "restaurantIdPK")
    private int restaurantIdPK;

    @ColumnInfo(name = "id")
    @SerializedName("id")
    private int id;

    @ColumnInfo(name = "name")
    @SerializedName("name")
    private String name;

    @ColumnInfo(name = "image_url")
    @SerializedName("image_url")
    private String imageurl;

    @ColumnInfo(name = "address")
    @SerializedName("address")
    private String address;

    @ColumnInfo(name = "description")
    @SerializedName("description")
    private String description;

    @Ignore
    @SerializedName("opening_closing_times")
    private TimeVo opening_closing_times;

    @ColumnInfo(name = "rating")
    @SerializedName("rating")
    private double rating;

    @Ignore
    @SerializedName("restaurant_location")
    private RestaurantLocation restaurant_location;

    @Ignore
    @SerializedName("menus")
    private List<RestaurantMenu>  menus;

    public int getRestaurantIdPK() {
        return restaurantIdPK;
    }

    public void setRestaurantIdPK(int restaurantIdPK) {
        this.restaurantIdPK = restaurantIdPK;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TimeVo getOpening_closing_times() {
        return opening_closing_times;
    }

    public void setOpening_closing_times(TimeVo opening_closing_times) {
        this.opening_closing_times = opening_closing_times;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public RestaurantLocation getRestaurant_location() {
        return restaurant_location;
    }

    public void setRestaurant_location(RestaurantLocation restaurant_location) {
        this.restaurant_location = restaurant_location;
    }

    public List<RestaurantMenu> getMenus() {
        return menus;
    }

    public void setMenus(List<RestaurantMenu> menus) {
        this.menus = menus;
    }
}
