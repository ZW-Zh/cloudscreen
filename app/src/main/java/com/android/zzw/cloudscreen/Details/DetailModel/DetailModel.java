package com.android.zzw.cloudscreen.Details.DetailModel;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.webkit.WebView;

/**
 * Created by zzw on 2017/5/11.
 */

public interface DetailModel {
    void setDetailContent(AppCompatActivity appCompatActivity, RecyclerView r, ViewPager v);
    void setDetailFragment();
}
