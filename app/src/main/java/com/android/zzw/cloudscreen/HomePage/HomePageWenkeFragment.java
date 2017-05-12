package com.android.zzw.cloudscreen.HomePage;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.zzw.cloudscreen.HomePage.HPModel.HomePageModelImpl;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.Wenke_Detail.WenkeDetailActivity;

/**
 * Created by zzw on 2017/4/22.
 */

public class HomePageWenkeFragment extends Fragment {
    private TextView wenkedeteil;
    ImageView img1;
    ImageView img2;
    ImageView img3;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.wenke_fragment,container,false);
        initView(v);
        img1 = (ImageView) v.findViewById(R.id.img1);
        img2  = (ImageView) v.findViewById(R.id.img2);
        img3 = (ImageView) v.findViewById(R.id.img3);
        HomePageModelImpl homePageModel =new HomePageModelImpl();
        homePageModel.setWenkePage(HomePageWenkeFragment.this,img1,img2,img3);
        return v;
    }
    public void initView(View v) {
        wenkedeteil = (TextView) v.findViewById(R.id.wenkedeteil);
        wenkedeteil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), WenkeDetailActivity.class);
                startActivity(intent);
            }
        });
    }

}
