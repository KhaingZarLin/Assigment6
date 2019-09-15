package com.example.assigment6.network.response;

import com.example.assigment6.data.vos.RestaurantVO;
import com.example.assigment6.utils.RestaurantConstants;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetRestaurantResponse {
    @SerializedName("message")
    private String message;

    @SerializedName("code")
    private int code;

    @SerializedName("data")
    private List<RestaurantVO> hotelVOList;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<RestaurantVO> getHotelVOList() {
        return hotelVOList;
    }

    public void setHotelVOList(List<RestaurantVO> hotelVOList) {
        this.hotelVOList = hotelVOList;
    }

    public Boolean isResponseOk(){
        return code == RestaurantConstants.CODE_RESPONSE_OK && hotelVOList != null;
    }
}
