package com.example.administrator.foodcalorie.view.adapter;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.foodcalorie.R;

public class ViewAdapter extends PagerAdapter{
    private TypedArray imageSlideArray;
    private Context context;
    private LayoutInflater layoutInflater;

    public ViewAdapter(Context context){
        this.context = context;
        imageSlideArray = context.getResources().obtainTypedArray(R.array.image_slide);
    }
    @Override
    public int getCount() {
        return imageSlideArray.length();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return (view == object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_view = layoutInflater.inflate(R.layout.image_bg_slide, container, false);
        ImageView imageView = (ImageView) item_view.findViewById(R.id.image_slid);
        imageView.setImageResource(imageSlideArray.getResourceId(position, R.drawable.logo_food));
        container.addView(item_view);
        return item_view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((LinearLayout) object);
    }
}
