package com.example.assigment6.persistence.daos;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.assigment6.data.vos.RestaurantVO;

import java.util.List;

@Dao
public interface RestaurantDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long[]  insertRent(List<RestaurantVO> rentVOS);

    @Query("SELECT * FROM restaurant")
    List<RestaurantVO> getAllRentFromDB();

    @Query("Select * from restaurant where id=:id")
    public abstract RestaurantVO getRentById(int id);

}