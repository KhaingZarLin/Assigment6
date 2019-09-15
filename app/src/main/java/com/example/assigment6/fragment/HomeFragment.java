package com.example.assigment6.fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.example.assigment6.R;
import com.example.assigment6.RestaurantDetailActivity;
import com.example.assigment6.adapters.RestaurantCollectionAdapter;
import com.example.assigment6.data.models.RestaurantModel;
import com.example.assigment6.data.models.RestaurantModelImpl;
import com.example.assigment6.data.vos.RestaurantVO;
import com.example.assigment6.delegate.FragmentDelegateOne;

import java.util.List;

import butterknife.BindView;


public class HomeFragment extends Fragment implements FragmentDelegateOne {
    LinearLayoutManager linearLayoutManager;
    private FragmentDelegateOne fragmentDelegateOne;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_home, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       final RecyclerView recyclerView=view.findViewById(R.id.recyclerView);
        linearLayoutManager=new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(linearLayoutManager);

        final RestaurantCollectionAdapter restaurantCollectionAdapter = new RestaurantCollectionAdapter(this);
        recyclerView.setAdapter(restaurantCollectionAdapter);

        RestaurantModelImpl.getObjInstance().getRestaurants(new RestaurantModel.GetRestaurantFromNetworkDelegate() {
            @Override
            public void onSuccess(List<RestaurantVO> restaurantVOS) {
                restaurantCollectionAdapter.setNewData(restaurantVOS);
            }

            @Override
            public void onFailure(String errorMessage) {
                Log.d("Error Message",errorMessage);
            }
        });
    }

    @Override
    public void onTapDElegate(int holdId) {
        Intent intent = RestaurantDetailActivity.newIntent(getContext(), holdId);
        startActivity(intent);
    }
}
