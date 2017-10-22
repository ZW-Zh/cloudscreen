package com.android.zzw.cloudscreen.Details;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.android.zzw.cloudscreen.Details.DetailModel.DetailModellmp;
import com.android.zzw.cloudscreen.HomePage.HPModel.HomePageModelImpl;
import com.android.zzw.cloudscreen.HomePage.MainActivity;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.utils.TransparentStatusBar;

/**
 * Created by zzw on 2017/5/11.
 */

public class DetailActivity extends AppCompatActivity {
    private ViewPager adviewPager;
    private RecyclerView recyclerView;
    private ViewPager viewPager;
    DetailModellmp detailmodellmp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        TransparentStatusBar.setTransparentStatusBar(DetailActivity.this);
        initViews();
        HomePageModelImpl homePageModel =new HomePageModelImpl();
        homePageModel.setHomePageAd(DetailActivity.this,adviewPager);
        detailmodellmp = new DetailModellmp();

        detailmodellmp.setDetailContent(DetailActivity.this,recyclerView,viewPager);
        detailmodellmp.setDetailFragment();
    }


    private void initViews(){
        adviewPager= (ViewPager) findViewById(R.id.deteilad);
        recyclerView = (RecyclerView) findViewById(R.id.detailcontent);
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
                Intent intent=new Intent(DetailActivity.this,MainActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);;
                startActivity(intent);
                overridePendingTransition(0, 0);
                finish();
            }
        });
    }

}
