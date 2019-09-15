package com.example.assigment6.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.assigment6.data.vos.RestaurantVO;
import com.example.assigment6.persistence.daos.RestaurantDao;
import com.example.assigment6.utils.RestaurantConstants;

@Database(entities = {RestaurantVO.class},version = 1,exportSchema = false)
public abstract class RestaurantDataBase extends RoomDatabase {

    public abstract RestaurantDao restaurantDao();
    public static RestaurantDataBase objInstance;

    public static RestaurantDataBase getObjInstance(Context context)
    {
        if (objInstance==null)
        {
            objInstance= Room.databaseBuilder(context,RestaurantDataBase.class, RestaurantConstants.EVENT_DR)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return objInstance;
    }
    public boolean areRestaurantExitInDB(){
        return !restaurantDao().getAllRentFromDB().isEmpty();
    }
}