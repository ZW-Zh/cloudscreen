package com.android.zzw.cloudscreen.Details;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.android.zzw.cloudscreen.Adapter.CoverFlowAdapter;
import com.android.zzw.cloudscreen.View.CoverFlowView;
import com.android.zzw.cloudscreen.R;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/5/12.
 */

public class WenkeActivityFragment extends Fragment {
    private ArrayList<Bitmap> imgList;
    private LinearLayout group;
    private ImageView[] ivPoints;
    private ImageButton left;
    private ImageButton right;
    private int currIndex=0;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.wenke_activity_fragment, container, false);
        group = (LinearLayout) v.findViewById(R.id.points);
        left = (ImageButton) v.findViewById(R.id.leftbtn);
        right = (ImageButton) v.findViewById(R.id.rightbtn);

        final CoverFlowView<MyCoverFlowAdapter> mCoverFlowView = (CoverFlowView<MyCoverFlowAdapter>) v.findViewById(R.id.coverflow);
        v.setVisibility(View.INVISIBLE);

        imgList = new ArrayList<Bitmap>();
        imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.qdadao));
        imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.dakashuo));
        imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.haomeimei));
        imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.qdadao));
        imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.dakashuo));
        imgList.add(BitmapFactory.decodeResource(this.getResources(), R.drawable.haomeimei));

        ivPoints = new ImageView[imgList.size()];
        for (int i = 0; i < imgList.size(); i++) {
            //循坏加入点点图片组
            ivPoints[i] = new ImageView(getContext());
            if (i == 0) {
                ivPoints[i].setImageResource(R.drawable.focused);
            } else {
                ivPoints[i].setImageResource(R.drawable.unfocused);
            }
            ivPoints[i].setPadding(8, 8, 8, 8);
            group.addView(ivPoints[i]);
        }
        MyCoverFlowAdapter adapter = new MyCoverFlowAdapter();
        mCoverFlowView.setAdapter(adapter);
        mCoverFlowView.setCoverFlowListener(new CoverFlowView.CoverFlowListener<MyCoverFlowAdapter>() {
            @Override
            public void imageOnTop(CoverFlowView<MyCoverFlowAdapter> coverFlowView, int position, float left, float top, float right, float bottom) {
                currIndex=position;
                for (int i = 0; i < imgList.size(); i++) {
                    if (i == position) {
                        ivPoints[i].setImageResource(R.drawable.focused);
                    } else {
                        ivPoints[i].setImageResource(R.drawable.unfocused);
                    }
                }
            }

            @Override
            public void topImageClicked(CoverFlowView<MyCoverFlowAdapter> coverFlowView, int position) {

            }

            @Override
            public void invalidationCompleted() {
                System.out.println("1");
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currIndex!=0) {
                    mCoverFlowView.setSelection(currIndex - 1);
                }else {
                    mCoverFlowView.setSelection(imgList.size()-1);
                }
            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currIndex!=imgList.size()-1) {
                    mCoverFlowView.setSelection(currIndex + 1);
                }else {
                    mCoverFlowView.setSelection(0);
                }
            }
        });
        return v;
    }

    public class MyCoverFlowAdapter extends CoverFlowAdapter {
        private Bitmap image1=BitmapFactory.decodeResource(getActivity().getResources(),
                R.drawable.qdadao);
        public int getCount() {
            return 6;
        }

        public Bitmap getImage(final int position) {

            if (position<imgList.size()) {
                return imgList.get(position);
            }else return image1;
        }
    }

}
