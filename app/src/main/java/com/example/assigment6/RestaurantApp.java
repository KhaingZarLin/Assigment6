package com.example.assigment6;

import android.app.Application;

import com.example.assigment6.data.models.RestaurantModelImpl;

public class RestaurantApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        RestaurantModelImpl.initializeRentModel(getApplicationContext());
    }
}

