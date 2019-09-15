package com.example.assigment6.data.models;

import android.content.Context;

import com.example.assigment6.data.vos.RestaurantVO;
import com.example.assigment6.network.dataagents.RestaurantDataAgent;
import com.example.assigment6.utils.RestaurantConstants;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestaurantModelImpl extends BaseModel implements RestaurantModel{

    private Map<Integer, RestaurantVO> restaurantsDataRepository;
    private static RestaurantModelImpl objInstance;

    private RestaurantModelImpl(Context context){
        super(context);
        restaurantsDataRepository = new HashMap<>();
    }
    public static void initializeRentModel(Context context)
    {
        objInstance=new RestaurantModelImpl(context);
    }

    public static RestaurantModelImpl getObjInstance(){
        if(objInstance == null){
           // objInstance = new RestaurantModelImpl();
            throw new RuntimeException(RestaurantConstants.EM_EVENT_MODEL_NOT_INITIALIZE);
        }
        return objInstance;
    }
    @Override
    public void getRestaurants(final GetRestaurantFromNetworkDelegate delegate) {

        if (restaurantDataBase.areRestaurantExitInDB())
        {
            List<RestaurantVO> rentFromDb=restaurantDataBase.restaurantDao().getAllRentFromDB();
            delegate.onSuccess(rentFromDb);
        }
        else {
           mDataAgent.getRestaurants(RestaurantConstants.DUAMY_ACCESS_TOKEN, new RestaurantDataAgent.GetRestaurantFromNetworkDelegate() {
               @Override
               public void onSuccess(List<RestaurantVO> restaurants) {
//                    for (RestaurantVO restaurant:restaurants)
//                {
//                    restaurantsDataRepository.put(restaurant.getId(),restaurant);
//                }
                   Long id[] = restaurantDataBase.restaurantDao().insertRent(restaurants);
                   delegate.onSuccess(restaurants);
               }

               @Override
               public void onFailure(String errorMessage)
               {
                   delegate.onFailure(errorMessage);
               }
           });
        }
    }

    @Override
    public RestaurantVO findRentById(int hotelId) {
        // RestaurantVO restaurantVO = restaurantsDataRepository.get(hotelId);
        RestaurantVO restaurantVO=restaurantDataBase.restaurantDao().getRentById(hotelId);
        return restaurantVO;
    }

}











