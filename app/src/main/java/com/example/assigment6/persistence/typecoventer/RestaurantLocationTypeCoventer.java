package com.example.assigment6.persistence.typecoventer;

import android.arch.persistence.room.TypeConverter;

import com.example.assigment6.data.vos.TimeVo;
import com.google.gson.Gson;


public class RestaurantLocationTypeCoventer {
    @TypeConverter
    public static  String restaurantTimeToJson(TimeVo timeVo)
    {
        return  new Gson().toJson(timeVo);
    }
    @TypeConverter
    public static TimeVo jsonToEventOrganizer(String eventOrganizerjson)
    {
        return new Gson().fromJson(eventOrganizerjson,TimeVo.class);
    }

}
