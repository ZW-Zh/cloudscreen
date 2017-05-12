package com.android.zzw.cloudscreen.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.zzw.cloudscreen.Details.DetailActivity;
import com.android.zzw.cloudscreen.HomePage.HPModel.HomePageModelImpl;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.utils.TransparentStatusBar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageButton redpacket;
    private ImageButton signin;
    private ImageButton welfare;
    private ImageButton action;
    private ImageView homepagead;
    private ViewPager viewPager;
    private ViewPager adviewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        TransparentStatusBar.setTransparentStatusBar(MainActivity.this);
    }
    public void initView() {
        redpacket = (ImageButton) findViewById(R.id.redpacket);
        signin = (ImageButton) findViewById(R.id.signin);
        action = (ImageButton) findViewById(R.id.action);
        welfare = (ImageButton) findViewById(R.id.welfare);
        adviewPager = (ViewPager) findViewById(R.id.homepagead);
        redpacket.setOnClickListener(this);
        signin.setOnClickListener(this);
        action.setOnClickListener(this);
        welfare.setOnClickListener(this);
        viewPager= (ViewPager) findViewById(R.id.viewpager);


        HomePageModelImpl homePageModel = new HomePageModelImpl();
        homePageModel.setFootViewpager(MainActivity.this,viewPager);
        homePageModel.setHomePageAd(MainActivity.this,adviewPager);

    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.redpacket:
                startActivity(3);
                break;
            case R.id.signin:
                startActivity(0);
                break;
            case R.id.action:
                startActivity(2);
                break;
            case R.id.welfare:
                startActivity(1);
                break;
        }
    }
    private void startActivity(int i){
        Intent intent = new Intent(MainActivity.this, DetailActivity.class);
        intent.putExtra("Index",i);
        startActivity(intent);
    }
}
