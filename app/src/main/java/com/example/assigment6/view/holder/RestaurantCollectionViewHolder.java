package com.example.assigment6.view.holder;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.assigment6.R;
import com.example.assigment6.data.vos.RestaurantVO;
import com.example.assigment6.delegate.FragmentDelegateOne;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RestaurantCollectionViewHolder extends BaseViewHolder<RestaurantVO>  {
    private FragmentDelegateOne fragmentDelegateOne;
    public Context context;

//    @BindView(R.id.background_img)
//    ImageView backgroundimg;

    @BindView(R.id.txt_mex)
    TextView txt_title;

    @BindView(R.id.txt_rate_value)
    TextView txt_rate;

    @BindView(R.id.descript)
    TextView descript;



    public RestaurantCollectionViewHolder(View itemView,FragmentDelegateOne delegateOne) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        fragmentDelegateOne=delegateOne;

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentDelegateOne.onTapDElegate(mData.getId());
            }
        });
    }


    @Override
    public void bindData(RestaurantVO data) {
        mData=data;
        txt_title.setText(data.getName());
        txt_rate.setText(String.valueOf(data.getRating()));
        descript.setText(data.getDescription());
       // Glide.with(itemView).load(data.getImageurl()).into(backgroundimg);
    }
}
