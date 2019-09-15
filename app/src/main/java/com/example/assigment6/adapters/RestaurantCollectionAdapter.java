package com.example.assigment6.adapters;

import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;

import com.example.assigment6.R;
import com.example.assigment6.data.vos.RestaurantVO;
import com.example.assigment6.delegate.FragmentDelegateOne;
import com.example.assigment6.view.holder.RestaurantCollectionViewHolder;

import java.util.ArrayList;
import java.util.List;

public class RestaurantCollectionAdapter extends BaseAdapter<RestaurantCollectionViewHolder, RestaurantVO> implements Filterable {
    private FragmentDelegateOne fragmentDelegateOne;
    private List<RestaurantVO> restaurantVOList;

    public RestaurantCollectionAdapter(FragmentDelegateOne delegateOne) {
        this.fragmentDelegateOne = delegateOne;
    }

    @NonNull
    @Override
    public RestaurantCollectionViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemview= LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_view,viewGroup,false);
        return new RestaurantCollectionViewHolder(itemview,fragmentDelegateOne);
    }

    @Override
    public Filter getFilter() {
        return item;
    }
    private Filter item=new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<RestaurantVO> voList=new ArrayList<>();
            if (constraint==null || constraint.length()==0)
            {
                voList.addAll(restaurantVOList);
            }
            else
            {
                String filterpattern=constraint.toString().toLowerCase().trim();
                for (RestaurantVO rentVO:restaurantVOList)
                {
                    if(rentVO.getName().toLowerCase().contains(filterpattern))
                    {
                        voList.add(rentVO);
                    }
                }
            }
            FilterResults filterResults=new FilterResults();
            filterResults.values=voList;

            return filterResults;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            restaurantVOList.clear();
            restaurantVOList.addAll((List)results.values);
            notifyDataSetChanged();
        }
    };

}
