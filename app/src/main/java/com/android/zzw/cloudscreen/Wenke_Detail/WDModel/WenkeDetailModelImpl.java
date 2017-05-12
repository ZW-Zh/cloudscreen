package com.android.zzw.cloudscreen.Wenke_Detail.WDModel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageButton;


import com.android.zzw.cloudscreen.Adapter.MyGridViewAdpter;
import com.android.zzw.cloudscreen.Adapter.WenkePageAdapter;
import com.android.zzw.cloudscreen.Bean.WenkeBean;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.View.MyViewPagerTab;
import com.android.zzw.cloudscreen.Wenke_Detail.WenkeDetailFragment;
import com.android.zzw.cloudscreen.Wenke_Detail.WenkeMoreFragment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by zzw on 2017/5/7.
 */

public class WenkeDetailModelImpl implements WenkeDetailModel{
    private ArrayList<Fragment> fragmentArrayList=new ArrayList<>();
    private ArrayList<String> wenkecontnet = new ArrayList<>();
    private int totalPage; //总的页数
    private int mPageSize = 6; //每页显示的最大的数量
    private ArrayList<WenkeBean> listDatas=new ArrayList<>();//总的数据源
    private List<View> viewPagerList;
    private String[] content={"电影","演唱会","音乐节","戏剧","展览"};
    private int currentPage=0;
    @Override
    public void setWenkeRecyclerview(AppCompatActivity appCompatActivity, RecyclerView recyclerView, final ViewPager viewPager) {
        Collections.addAll(wenkecontnet, content);
        fragmentArrayList.add(new Fragment());
        fragmentArrayList.add(new Fragment());
        fragmentArrayList.add(new WenkeDetailFragment());
        fragmentArrayList.add(new Fragment());
        fragmentArrayList.add(new Fragment());
        MyViewPagerTab myViewPagerTab = new MyViewPagerTab(appCompatActivity,recyclerView,2,viewPager,wenkecontnet,fragmentArrayList);
        myViewPagerTab.InitViewPager();
        myViewPagerTab.setOnItemClickListener(new MyViewPagerTab.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {

            }
        });

    }

    @Override
    public void setWenkeDetail(final ViewPager viewPager, final FragmentActivity appCompatActivity, ImageButton right, ImageButton left) {
        for(int i=0;i<3;i++) {
            listDatas.add(new WenkeBean("刘健大咖说", R.drawable.dakashuo));
            listDatas.add(new WenkeBean("好妹妹乐队", R.drawable.haomeimei));
            listDatas.add(new WenkeBean("Q大道", R.drawable.qdadao));
        }
        totalPage = (int) Math.ceil(listDatas.size() * 1.0 / mPageSize);
        viewPagerList = new ArrayList<View>();
        for (int i = 0; i < totalPage; i++) {
            //每个页面都是inflate出一个新实例
            final GridView gridView = (GridView) View.inflate(appCompatActivity, R.layout.wenke_detail_gridview, null);
            gridView.setAdapter(new MyGridViewAdpter(appCompatActivity, listDatas, i, mPageSize));
            //添加item点击监听
            gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> arg0, View arg1,
                                        int position, long arg3) {
                    // TODO Auto-generated method stub
                    Object obj = gridView.getItemAtPosition(position);
                    System.out.println(obj);

                    WenkeMoreFragment wenkeMoreFragment =new WenkeMoreFragment();
                    Bundle bundle =new Bundle();
                    bundle.putSerializable("key",(WenkeBean)obj);
                    wenkeMoreFragment.setArguments(bundle);
                    //Toast.makeText(appCompatActivity, ((WenkeBean) obj).getActivity(), Toast.LENGTH_SHORT).show();
                    appCompatActivity.getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.container,wenkeMoreFragment).commit();
                }

            });
            //每一个GridView作为一个View对象添加到ViewPager集合中
            viewPagerList.add(gridView);
        }
        //设置ViewPager适配器
        viewPager.setAdapter(new WenkePageAdapter(viewPagerList));
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                currentPage=position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentPage!=fragmentArrayList.size()-1){
                    viewPager.setCurrentItem(currentPage+1);
                }
            }
        });
        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(currentPage!=0){
                    viewPager.setCurrentItem(currentPage-1);
                }
            }
        });
        Intent intent = appCompatActivity.getIntent();

        if (intent.getIntExtra("1", 0) == 1) {
            System.out.println(1);
            Bundle bundle = intent.getExtras();
            WenkeBean wenkeBean = (WenkeBean) bundle.getSerializable("2");
            WenkeMoreFragment wenkeMoreFragment =new WenkeMoreFragment();
            Bundle mBundle = new Bundle();
            mBundle.putSerializable("key", wenkeBean);
            wenkeMoreFragment.setArguments(mBundle);
            appCompatActivity.getSupportFragmentManager().beginTransaction().addToBackStack(null).add(R.id.container, wenkeMoreFragment).commit();
            intent.removeExtra("1");
        }
    }

}
