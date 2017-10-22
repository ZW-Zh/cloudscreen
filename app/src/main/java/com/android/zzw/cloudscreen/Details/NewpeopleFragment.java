package com.android.zzw.cloudscreen.Details;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.android.zzw.cloudscreen.R;
import com.bumptech.glide.Glide;

/**
 * Created by zzw on 2017/5/16.
 */

public class NewpeopleFragment extends Fragment {
    private ImageView imageView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.redpacket_fragment,container,false);
        imageView = (ImageView) view.findViewById(R.id.erweima);
        Glide.with(getActivity()).load("http://218.94.133.42:11180/img/ypind/bonus.png").into(imageView);
        return view;
    }
}
