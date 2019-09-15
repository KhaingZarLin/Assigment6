package com.example.assigment6.data.models;

import android.content.Context;

import com.example.assigment6.network.dataagents.RestaurantDataAgent;
import com.example.assigment6.network.dataagents.RetrofitDataAgentImpl;
import com.example.assigment6.persistence.RestaurantDataBase;

public class BaseModel {
    protected RestaurantDataAgent mDataAgent;
    protected RestaurantDataBase restaurantDataBase;

    BaseModel(Context context){
        //this.mDataAgent = HttpUrlConnectionDataAgentImpl.getObjInstance();
        //mDataAgent = OkHttpDataAgentImpl.getObjInstance();
        mDataAgent = RetrofitDataAgentImpl.getObjInstance();
        restaurantDataBase=RestaurantDataBase.getObjInstance(context);
    }
}
