package com.example.administrator.foodcalorie.view.adapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.administrator.foodcalorie.view.fragment.DetailFragment;
import com.example.administrator.foodcalorie.view.fragment.ReviewFragment;
import com.example.administrator.foodcalorie.view.fragment.SearchFragment;

public class TabAdapter extends FragmentPagerAdapter{
    //integer to count number of tabs
    int tabsCount;

    //Constructor to the class
    public TabAdapter(FragmentManager fm, int tabCount) {
        super(fm);
        //Initializing tab count
        this.tabsCount= tabCount;
    }
    //Overriding method getItem
    @Override
    public Fragment getItem(int position) {
        //Returning the current tabs
        switch (position) {
            case 0:
                DetailFragment tab1 = new DetailFragment();
                return tab1;
            case 1:
                SearchFragment tab2 = new SearchFragment();
                return tab2;
            case 2:
                ReviewFragment tab3 = new ReviewFragment();
                return tab3;
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return tabsCount;
    }
}
