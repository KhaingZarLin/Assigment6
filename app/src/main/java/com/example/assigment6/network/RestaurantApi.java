package com.example.assigment6.network;

import com.example.assigment6.network.response.GetRestaurantResponse;
import com.example.assigment6.utils.RestaurantConstants;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RestaurantApi {

    @GET(RestaurantConstants.GET_EVENTS)
    Call<GetRestaurantResponse> getAllRestaurant();
}
