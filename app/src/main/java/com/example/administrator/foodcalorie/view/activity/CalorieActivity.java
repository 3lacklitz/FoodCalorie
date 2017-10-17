package com.example.administrator.foodcalorie.view.activity;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.administrator.foodcalorie.R;
import com.example.administrator.foodcalorie.view.adapter.TabAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CalorieActivity extends AppCompatActivity implements TabLayout.OnTabSelectedListener{

    @BindView(R.id.tab_layout_cal)
    TabLayout myTabLayout;
    @BindView(R.id.view_pager_cal)
    ViewPager myViewPager;

    //This is our tablayout
//    private TabLayout myTabLayout;
//    //This is our viewPager
//    private ViewPager myViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calorie);
        ButterKnife.bind(this);


        //Adding toolbar to the activity
//        Toolbar myToolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(myToolbar);

        //Initializing the tablayout
//        myTabLayout = (TabLayout) findViewById(R.id.tabLayout);

        //Adding the tabs using addTab() method

        myTabLayout.addTab(myTabLayout.newTab().setIcon(R.drawable.icon_detail));
        myTabLayout.addTab(myTabLayout.newTab().setIcon(R.drawable.icon_search));
        myTabLayout.addTab(myTabLayout.newTab().setIcon(R.drawable.icon_review));
        myTabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        //Initializing viewPager
//        myViewPager = (ViewPager) findViewById(R.id.pager);

        //Creating our pager adapter
        TabAdapter adapter = new TabAdapter(getSupportFragmentManager(), myTabLayout.getTabCount());

        //Adding adapter to pager
        myViewPager.setAdapter(adapter);

        //Adding onTabSelectedListener to swipe views
        myTabLayout.setOnTabSelectedListener(this);
    }

    @Override
    public void onTabSelected(TabLayout.Tab tab) {
        myViewPager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(TabLayout.Tab tab) {

    }

    @Override
    public void onTabReselected(TabLayout.Tab tab) {

    }
}
