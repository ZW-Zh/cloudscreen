package com.android.zzw.cloudscreen.View;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.android.zzw.cloudscreen.Adapter.AdapterFragment;
import com.android.zzw.cloudscreen.Adapter.PageAdapter;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/4/22.
 */

 public class MyViewpager{
    private ArrayList<Fragment> fragmentContainter;
    private ViewPager viewPager;


    public ViewPager getViewPager() {
        return viewPager;
    }

    public void addfragment(Fragment fragment){
        fragmentContainter.add(fragment);
    }
    public MyViewpager(ViewPager viewpager){
        this.viewPager = viewpager;
        fragmentContainter=new ArrayList<Fragment>();
    }
    public ArrayList getFragmentList(){
        return fragmentContainter;
    }
    public void setViewPager(ArrayList<ImageView> viewContainer){
        viewPager.setAdapter(new PageAdapter(viewContainer));
    }
    public void setFragmentViewPager(AppCompatActivity appCompatActivity) {
        FragmentManager fragmentManager = appCompatActivity.getSupportFragmentManager();
        AdapterFragment adapterFragment = new AdapterFragment(fragmentManager, fragmentContainter);
        viewPager.setAdapter(adapterFragment);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }
            @Override
            public void onPageSelected(int position) {
            }
            @Override
            public void onPageScrollStateChanged(int state) {
            }

        });

    }
}
