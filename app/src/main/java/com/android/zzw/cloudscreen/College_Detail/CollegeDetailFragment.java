package com.android.zzw.cloudscreen.College_Detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.zzw.cloudscreen.College_Detail.CDModel.CollegeDetailModelImpl;
import com.android.zzw.cloudscreen.R;

/**
 * Created by zzw on 2017/5/7.
 */

public class CollegeDetailFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.college_detail_fragment, container, false);
       CollegeDetailModelImpl collegeDetailModel=new CollegeDetailModelImpl();
        collegeDetailModel.setCollegeDetail(CollegeDetailFragment.this);
        return view;

    }
}
