package com.example.assigment6.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.assigment6.fragment.HomeFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {
    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

            if(position==0)
            {
                return new HomeFragment();
            }
            else if(position==1)
            {
                return new HomeFragment();
            }
            else
            {
                return new HomeFragment();
            }

    }

    @Override
    public int getCount() {
        return 3;
    }
//    public void addFragment(Fragment fragment){
//
//        mFragmentList.add(fragment);
//    }
}
