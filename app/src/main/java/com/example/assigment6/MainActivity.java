package com.example.assigment6;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.assigment6.adapters.ViewPagerAdapter;
import com.example.assigment6.fragment.HomeFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.btn_nav);
        bottomNavigationView.setOnNavigationItemSelectedListener(navlister);
        goToFragment(new HomeFragment());

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navlister = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.circle:
                    goToFragment(new HomeFragment());
                    break;
                case R.id.app_black:
                    goToFragment(new HomeFragment());
                    break;
                case R.id.camera:
                    goToFragment(new HomeFragment());
                    break;
                case R.id.drop:
                    goToFragment(new HomeFragment());
                    break;
                case R.id.profile:
                    goToFragment(new HomeFragment());
                    break;

            }
            return false;
        }
    };

    private void goToFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, fragment).commit();
    }


}
