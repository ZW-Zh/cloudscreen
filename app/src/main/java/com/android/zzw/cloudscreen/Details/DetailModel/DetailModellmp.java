package com.android.zzw.cloudscreen.Details.DetailModel;

import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.webkit.WebView;

import com.android.zzw.cloudscreen.Bean.Api;
import com.android.zzw.cloudscreen.Details.DetailFragment;
import com.android.zzw.cloudscreen.Details.NewpeopleFragment;
import com.android.zzw.cloudscreen.Details.WenkeActivityFragment;
import com.android.zzw.cloudscreen.View.MyViewPagerTab;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by zzw on 2017/5/11.
 */

public class DetailModellmp implements DetailModel{
    private ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    private ArrayList<String> detailcontnet = new ArrayList<>();
    private String[] content={"签到","福利","文客行动","新人红包"};

    MyViewPagerTab myViewPagerTab;
    @Override
    public void setDetailContent(final AppCompatActivity appCompatActivity, RecyclerView recyclerView, ViewPager viewPager) {
        Collections.addAll(detailcontnet, content);
        fragmentArrayList.add(new DetailFragment());
        fragmentArrayList.add(new DetailFragment());
        fragmentArrayList.add(new WenkeActivityFragment());
        fragmentArrayList.add(new NewpeopleFragment());
        myViewPagerTab = new MyViewPagerTab(appCompatActivity,recyclerView,2,viewPager,detailcontnet,fragmentArrayList);
        myViewPagerTab.InitViewPager();
        new Handler().postDelayed(new Runnable(){
            public void run() {
                myViewPagerTab.getmViewPager().setCurrentItem(appCompatActivity.getIntent().getIntExtra("Index",0));
                if (appCompatActivity.getIntent().getIntExtra("Index",0)==2){
                    ((WenkeActivityFragment)myViewPagerTab.getAdapterFragment().getItem(2)).getView().setVisibility(View.VISIBLE);
                }
                appCompatActivity.getIntent().removeExtra("Index");
            }
        },20 );
    }

    @Override
    public void setDetailFragment() {
        myViewPagerTab.setOnItemClickListener(new MyViewPagerTab.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

                switch (position) {
                    case 0:
                        WebView webView=((DetailFragment)myViewPagerTab.getAdapterFragment().getItem(0)).getWebView();
                        webView.loadUrl(Api.QIANDAO);
                        break;
                    case 1:
                        WebView webView1=((DetailFragment)myViewPagerTab.getAdapterFragment().getItem(1)).getWebView();
                        webView1.loadUrl(Api.FULI);
                        break;
                    case 2:
                        ((WenkeActivityFragment)myViewPagerTab.getAdapterFragment().getItem(2)).getView().setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        break;
                }
            }
        });

    }

}
