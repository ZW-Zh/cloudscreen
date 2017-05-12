package com.android.zzw.cloudscreen.Wenke_Detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.Wenke_Detail.WDModel.WenkeDetailModelImpl;

/**
 * Created by zzw on 2017/5/10.
 */

public class WenkeDetailFragment extends Fragment{
    private ViewPager detailViewpager;
    private ImageButton right;
    private ImageButton left;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wenke_detail_fragment, container, false);
        right = (ImageButton) view.findViewById(R.id.rightbtn);
        left = (ImageButton) view.findViewById(R.id.leftbtn);
        detailViewpager = (ViewPager) view.findViewById(R.id.wenkedeteilvp);
        WenkeDetailModelImpl wenkeDetailModel =new WenkeDetailModelImpl();
        wenkeDetailModel.setWenkeDetail(detailViewpager,getActivity(),right,left);
        return view;

    }
}
