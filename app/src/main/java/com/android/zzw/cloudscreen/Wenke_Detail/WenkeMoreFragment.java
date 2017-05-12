package com.android.zzw.cloudscreen.Wenke_Detail;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.zzw.cloudscreen.Bean.WenkeBean;
import com.android.zzw.cloudscreen.R;

/**
 * Created by zzw on 2017/5/10.
 */

public class WenkeMoreFragment extends Fragment {
    private ImageView img;
    private TextView title;
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.wenke_more_fragment, container, false);
        img= (ImageView) view.findViewById(R.id.wenkeimg);
        title = (TextView) view.findViewById(R.id.title);
        WenkeBean wenkeBean= (WenkeBean) getArguments().getSerializable("key");
        img.setImageResource(wenkeBean.getImgid());
        title.setText(wenkeBean.getActivity());
        return view;

    }
}
