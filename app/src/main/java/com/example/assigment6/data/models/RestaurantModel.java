package com.example.assigment6.data.models;

import com.example.assigment6.data.vos.RestaurantVO;

import java.util.List;

public interface RestaurantModel {
    void getRestaurants(GetRestaurantFromNetworkDelegate delegate);

    RestaurantVO findRentById(int hotelId);

    interface GetRestaurantFromNetworkDelegate{
        void onSuccess(List<RestaurantVO> events);
        void onFailure(String errorMessage);
    }
}
