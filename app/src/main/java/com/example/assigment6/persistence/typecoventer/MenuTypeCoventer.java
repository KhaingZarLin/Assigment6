package com.example.assigment6.persistence.typecoventer;

import android.arch.persistence.room.TypeConverter;

import com.example.assigment6.data.vos.RestaurantMenu;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

public class MenuTypeCoventer {
    @TypeConverter
    public static String restaurantMenuVoToJson(List<RestaurantMenu> userVos)
    {
        return new Gson().toJson(userVos);
    }
    @TypeConverter
    public static List<RestaurantMenu> jsonToMenuVo(String uservojson)
    {
        Type type=new TypeToken<List<RestaurantMenu>>() {}.getType();
        return new Gson().fromJson(uservojson,type);
    }

}
