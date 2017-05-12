package com.android.zzw.cloudscreen.College_Detail.CDModel;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

/**
 * Created by zzw on 2017/5/4.
 */

public interface CollegeDetailModel {
    void setCollegeContnet(AppCompatActivity appCompatActivity);
    void InitViewPager(AppCompatActivity appCompatActivity, RecyclerView recyclerView, ViewPager viewPager);
    void setCollegeDetail(Fragment fragment);
}
