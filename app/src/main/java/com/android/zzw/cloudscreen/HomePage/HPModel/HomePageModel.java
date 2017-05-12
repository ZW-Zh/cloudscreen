package com.android.zzw.cloudscreen.HomePage.HPModel;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

/**
 * Created by zzw on 2017/4/22.
 */

public interface HomePageModel {
    void setCollegeInformation(Fragment fragment);
    void setWenkePage(Fragment fragment, ImageView img, ImageView img1, ImageView img2);
    void setHomePageAd(AppCompatActivity appCompatActivity, ViewPager viewPager);
    void setFootViewpager(AppCompatActivity appCompatActivity, ViewPager viewpager);
}
