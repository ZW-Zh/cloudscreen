package com.android.zzw.cloudscreen.Wenke_Detail.WDModel;

import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageButton;

/**
 * Created by zzw on 2017/5/7.
 */

public interface WenkeDetailModel {
    void setWenkeRecyclerview(AppCompatActivity appCompatActivity, RecyclerView recyclerView, ViewPager viewPager);
    void setWenkeDetail(ViewPager viewPager, FragmentActivity activity, ImageButton right, ImageButton left);
}
