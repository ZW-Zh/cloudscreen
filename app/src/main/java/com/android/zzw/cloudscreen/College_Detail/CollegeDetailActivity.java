package com.android.zzw.cloudscreen.College_Detail;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.android.zzw.cloudscreen.College_Detail.CDModel.CollegeDetailModelImpl;
import com.android.zzw.cloudscreen.HomePage.HPModel.HomePageModelImpl;
import com.android.zzw.cloudscreen.HomePage.MainActivity;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.utils.TransparentStatusBar;


/**
 * Created by zzw on 2017/5/4.
 */

public class CollegeDetailActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.college_detail_layout);
        //透明状态栏
        TransparentStatusBar.setTransparentStatusBar(CollegeDetailActivity.this);
        initView();

        CollegeDetailModelImpl collegeDetailModel = new CollegeDetailModelImpl();
        collegeDetailModel.setCollegeContnet(CollegeDetailActivity.this);
        collegeDetailModel.InitViewPager(CollegeDetailActivity.this,recyclerView,viewPager);

        HomePageModelImpl homePageModel=new HomePageModelImpl();
        ViewPager viewPager = (ViewPager) findViewById(R.id.collegedeteilad);
        homePageModel.setHomePageAd(CollegeDetailActivity.this,viewPager);
    }
    private void initView(){
        recyclerView = (RecyclerView) findViewById(R.id.collegecontent);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
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
                Intent intent=new Intent(CollegeDetailActivity.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);;
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });


    }
}
