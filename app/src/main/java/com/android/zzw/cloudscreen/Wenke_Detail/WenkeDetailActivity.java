package com.android.zzw.cloudscreen.Wenke_Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.android.zzw.cloudscreen.HomePage.HPModel.HomePageModelImpl;
import com.android.zzw.cloudscreen.HomePage.MainActivity;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.Wenke_Detail.WDModel.WenkeDetailModelImpl;
import com.android.zzw.cloudscreen.utils.TransparentStatusBar;

/**
 * Created by zzw on 2017/5/7.
 */

public class WenkeDetailActivity extends AppCompatActivity{
    private ViewPager viewPager;
    private RecyclerView recyclerView;
    private ViewPager contentviewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.wenke_detail_layout);
        TransparentStatusBar.setTransparentStatusBar(WenkeDetailActivity.this);
        initView();
        HomePageModelImpl homePageModel=new HomePageModelImpl();
        homePageModel.setHomePageAd(WenkeDetailActivity.this,viewPager);
        WenkeDetailModelImpl wenkeDetailModel=new WenkeDetailModelImpl();
        wenkeDetailModel.setWenkeRecyclerview(WenkeDetailActivity.this,recyclerView,contentviewPager);
    }
    private void initView(){
        viewPager = (ViewPager) findViewById(R.id.wenkedeteilad);
        recyclerView= (RecyclerView) findViewById(R.id.wenkecontent);
        contentviewPager = (ViewPager) findViewById(R.id.viewpager);

        ImageButton back = (ImageButton) findViewById(R.id.back);
        ImageButton home = (ImageButton) findViewById(R.id.home);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();

            }
        });
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(WenkeDetailActivity.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);;
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }
}
