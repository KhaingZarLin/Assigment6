package com.example.assigment6.network.dataagents;

import com.example.assigment6.data.vos.RestaurantVO;

import java.util.List;

public interface RestaurantDataAgent {
    void getRestaurants(String accessToken,GetRestaurantFromNetworkDelegate delegate);

    interface GetRestaurantFromNetworkDelegate{
        void onSuccess(List<RestaurantVO> restaurants);
        void onFailure(String errorMessage);
    }
}
