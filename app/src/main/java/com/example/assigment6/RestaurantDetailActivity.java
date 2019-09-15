package com.example.assigment6;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.assigment6.data.vos.RestaurantVO;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantDetailActivity extends BaseActivity {

    public static final String Rent_EXTRA_ID="rentID";

    public static Intent newIntent(Context context, int hotelIdExtra){
        Intent intent = new Intent(context, RestaurantDetailActivity.class);
        intent.putExtra(Rent_EXTRA_ID, hotelIdExtra);
        return intent;
    }

    @BindView(R.id.detial_title)
    TextView detialtitle;

    @BindView(R.id.detail_text)
    TextView detailDesc;

    @BindView(R.id.txt_time)
    TextView time;

    @BindView(R.id.txt_lenght)
    TextView lenght;

    @BindView(R.id.txt_map)
    TextView ma;

    @BindView(R.id.fl_map)
    FloatingActionButton map_fb;

    @BindView(R.id.txt_delivery)
    TextView delivery;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_detail);

        ButterKnife.bind(this);

       /* ImageView back_iv = findViewById(R.id.back);
        back_iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });*/
        final int rentID = getIntent().getIntExtra(Rent_EXTRA_ID, 0);

        final RestaurantVO rentVO = restaurantModel.findRentById(rentID);
        bindData(rentVO);

        /*map_fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String  lattitude = String.valueOf(rentVO.getLattitude());
                String  longitude = String.valueOf(rentVO.getLongitude());
                String openInMapPrefix = "google.navigation:q=" + lattitude + "," + longitude;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(openInMapPrefix));
                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }
            }
        });*/
    }
    private void bindData(RestaurantVO rentVO){

        detialtitle.setText(rentVO.getName());
        detailDesc.setText(rentVO.getDescription());

    }
}
