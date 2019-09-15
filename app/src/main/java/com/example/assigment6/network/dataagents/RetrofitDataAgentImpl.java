package com.example.assigment6.network.dataagents;

import com.example.assigment6.network.RestaurantApi;
import com.example.assigment6.network.response.GetRestaurantResponse;
import com.example.assigment6.utils.RestaurantConstants;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitDataAgentImpl implements RestaurantDataAgent {

    private static RetrofitDataAgentImpl objInstance;

    private RestaurantApi restaurantApi;

    public RetrofitDataAgentImpl(){
      final OkHttpClient  okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .build();

       Retrofit    retrofit = new Retrofit.Builder()
                .baseUrl(RestaurantConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build();

        restaurantApi = retrofit.create(RestaurantApi.class);
    }

    public static RetrofitDataAgentImpl getObjInstance(){
        if(objInstance == null){
            objInstance = new RetrofitDataAgentImpl();
        }
        return objInstance;
    }

    @Override
    public void getRestaurants(String accessToken,final GetRestaurantFromNetworkDelegate delegate) {
        Call<GetRestaurantResponse> eventsResponseCall = restaurantApi.getAllRestaurant();
        eventsResponseCall.enqueue(new Callback<GetRestaurantResponse>() {
            @Override
            public void onResponse(Call<GetRestaurantResponse> call, Response<GetRestaurantResponse> response) {
                GetRestaurantResponse getEventsResponse = response.body();
                delegate.onSuccess(getEventsResponse.getHotelVOList());
            }

            @Override
            public void onFailure(Call<GetRestaurantResponse> call, Throwable t) {
                delegate.onFailure(t.getLocalizedMessage());
            }
        });
    }
}
