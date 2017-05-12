package com.android.zzw.cloudscreen.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.zzw.cloudscreen.College_Detail.CollegeDetailActivity;
import com.android.zzw.cloudscreen.HomePage.HPModel.HomePageModelImpl;
import com.android.zzw.cloudscreen.R;

/**
 * Created by zzw on 2017/4/22.
 */

public class HomePageCollegeFragment extends Fragment{
    private TextView collegeDeteil;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v =inflater.inflate(R.layout.college_fragment,container,false);
        initView(v);
        HomePageModelImpl homePageModel = new HomePageModelImpl();
        homePageModel.setCollegeInformation(HomePageCollegeFragment.this);
        return v;
    }
    public void initView(View v){
        collegeDeteil = (TextView) v.findViewById(R.id.collegedeteil);
        collegeDeteil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomePageCollegeFragment.this.getActivity(), CollegeDetailActivity.class);
                startActivity(intent);
            }
        });
    }




}
