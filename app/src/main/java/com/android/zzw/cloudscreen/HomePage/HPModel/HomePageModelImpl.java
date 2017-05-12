package com.android.zzw.cloudscreen.HomePage.HPModel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;

import com.android.zzw.cloudscreen.Adapter.CollegeAdapter;
import com.android.zzw.cloudscreen.Adapter.PageAdapter;
import com.android.zzw.cloudscreen.Bean.Api;
import com.android.zzw.cloudscreen.Bean.College;
import com.android.zzw.cloudscreen.Bean.CollegeNews;
import com.android.zzw.cloudscreen.Bean.HomepageBanner;
import com.android.zzw.cloudscreen.Bean.WenkeBean;
import com.android.zzw.cloudscreen.College_Detail.CollegeDetailActivity;
import com.android.zzw.cloudscreen.HomePage.HomePageCollegeFragment;
import com.android.zzw.cloudscreen.HomePage.HomePageWenkeFragment;
import com.android.zzw.cloudscreen.R;
import com.android.zzw.cloudscreen.View.MyViewpager;
import com.android.zzw.cloudscreen.Wenke_Detail.WenkeDetailActivity;
import com.android.zzw.cloudscreen.utils.HttpUtil;
import com.android.zzw.cloudscreen.utils.ViewFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

import okhttp3.Call;
import okhttp3.Response;

/**
 * Created by zzw on 2017/4/24.
 */

public class HomePageModelImpl implements HomePageModel {
    public static final String LOG_TAG = "MainActivity";
    private ArrayList<ImageView> views = new ArrayList<ImageView>();
    public ImageHandler handler = new ImageHandler(new WeakReference<HomePageModelImpl>(this));
    private ArrayList<String> bannerlist = new ArrayList<String>();
    private ArrayList<College> collegeList = new ArrayList<College>();
    private ArrayList<WenkeBean> listDatas=new ArrayList<>();
    private Handler foothandler;
    String result;
    private int before = 0;
    public MyViewpager myViewPager;

    @Override
    public void setCollegeInformation(final Fragment fragment) {
        for (int i = 2; i <= 4; i++) {
            HttpUtil.sentOkHttpRequest("http://221.226.251.244:5188/wenkor_service/school/news/" + i + "/detail", new okhttp3.Callback() {
                @Override
                public void onFailure(Call call, IOException e) {

                }

                @Override
                public void onResponse(Call call, Response response) throws IOException {
                    final String a = response.body().string();
                    Gson gson = new Gson();
                    java.lang.reflect.Type type = new TypeToken<CollegeNews>() {
                    }.getType();
                    CollegeNews jsonBean = gson.fromJson(a, type);
                    String content = jsonBean.getData().getNewsContent();
                    College data = new College(jsonBean.getData().getImgUrl(), jsonBean.getData().getNewsTitle(), Html.fromHtml(content).toString(),content);
                    collegeList.add(data);
                    fragment.getActivity().runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            RecyclerView recyclerView = (RecyclerView) fragment.getActivity().findViewById(R.id.collegeinformation);
                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(fragment.getContext());
                            recyclerView.setLayoutManager(linearLayoutManager);
                            CollegeAdapter adapter = new CollegeAdapter(fragment.getContext(), collegeList);
                            recyclerView.setAdapter(adapter);
                            adapter.setOnItemClickListener(new CollegeAdapter.OnItemClickListener() {
                                @Override
                                public void onClick(int position, View v) {
                                    Intent intent = new Intent(fragment.getActivity(), CollegeDetailActivity.class);
                                    College college=collegeList.get(position);
                                    intent.putExtra("1",1);
                                    Bundle mBundle = new Bundle();
                                    mBundle.putSerializable("2",college);
                                    intent.putExtras(mBundle);
                                    fragment.getActivity().startActivity(intent);
                                }
                            });
                        }
                    });

                }
            });
        }
    }

    @Override
    public void setWenkePage(final Fragment fragment,ImageView img1,ImageView img2,ImageView img3) {
        listDatas.add(new WenkeBean("大圣归来", R.drawable.dasheng));
        listDatas.add(new WenkeBean("最强大脑", R.drawable.danao));
        listDatas.add(new WenkeBean("我是传奇", R.drawable.legend));
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragment.getActivity(), WenkeDetailActivity.class);
                intent.putExtra("1",1);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("2",listDatas.get(0));
                intent.putExtras(mBundle);
                fragment.getActivity().startActivity(intent);
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragment.getActivity(), WenkeDetailActivity.class);
                intent.putExtra("1",1);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("2",listDatas.get(1));
                intent.putExtras(mBundle);
                fragment.getActivity().startActivity(intent);
            }
        });
        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(fragment.getActivity(), WenkeDetailActivity.class);
                intent.putExtra("1",1);
                Bundle mBundle = new Bundle();
                mBundle.putSerializable("2",listDatas.get(2));
                intent.putExtras(mBundle);
                fragment.getActivity().startActivity(intent);
            }
        });

    }

    @Override
    public void setFootViewpager(AppCompatActivity appCompatActivity, ViewPager viewpager) {
        final MyViewpager myViewpager = new MyViewpager(viewpager);
        myViewpager.addfragment(new HomePageWenkeFragment());
        myViewpager.addfragment(new HomePageCollegeFragment());
        myViewpager.setFragmentViewPager(appCompatActivity);
        foothandler = new Handler() {
            public void handleMessage(Message msg) {
                switch (msg.what) {
                    case 1:
/**
 * 判断viewpager当前页面,然后设置为下一页面;
 */
                        before = myViewpager.getViewPager().getCurrentItem();
                        if (before == myViewpager.getFragmentList().size() - 1) {// 如果滑动到了最后一页
                    // 那就滚动到第一个页面
                            myViewpager.getViewPager().setCurrentItem(0);
                        } else {
                            myViewpager.getViewPager().setCurrentItem(before + 1);
                        }
                        break;
                    default:
                        break;
                }
            }
        };
        new Thread() {
            public void run() {
                while (true) {
                    try {
                        sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    foothandler.sendEmptyMessage(1);
                }
            }

            ;
        }.start();
    }

    @Override
    public void setHomePageAd(final AppCompatActivity appCompatActivity, final ViewPager adviewPager) {
        myViewPager = new MyViewpager(adviewPager);
        HttpUtil.sentOkHttpRequest(Api.BANNER, new okhttp3.Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                System.out.println(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                result = response.body().string();
                System.out.println(result);
                Gson gson = new Gson();
                HomepageBanner post = gson.fromJson(result, HomepageBanner.class);
                for (HomepageBanner.Data item : post.getData()) {
                    bannerlist.add(item.getImgUrl());
                    appCompatActivity.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            setImg(appCompatActivity);
                        }
                    });

                }
            }
        });
        myViewPager.getViewPager().setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            //配合Adapter的currentItem字段进行设置。
            @Override
            public void onPageSelected(int arg0) {
                handler.sendMessage(Message.obtain(handler, ImageHandler.MSG_PAGE_CHANGED, arg0, 0));
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            //覆写该方法实现轮播效果的暂停和恢复
            @Override
            public void onPageScrollStateChanged(int arg0) {
                switch (arg0) {
                    case ViewPager.SCROLL_STATE_DRAGGING:
                        handler.sendEmptyMessage(ImageHandler.MSG_KEEP_SILENT);
                        break;
                    case ViewPager.SCROLL_STATE_IDLE:
                        handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);
                        break;
                    default:
                        break;
                }
            }
        });
        myViewPager.getViewPager().setCurrentItem(Integer.MAX_VALUE / 2);//默认在中间，使用户看不到边界
        //开始轮播效果
        handler.sendEmptyMessageDelayed(ImageHandler.MSG_UPDATE_IMAGE, ImageHandler.MSG_DELAY);

    }

    private void setImg(AppCompatActivity appCompatActivity) {
        for (int i = 0; i < bannerlist.size(); i++) {
            views.add(ViewFactory.getImageView(appCompatActivity, bannerlist.get(i)));
        }
        myViewPager.getViewPager().setAdapter(new PageAdapter(views));

    }
    /*private class MyTask extends AsyncTask<String,Integer,String>{
        private Fragment fragment;
        private RecyclerView recyclerView;
        public MyTask(Fragment fragment,RecyclerView recyclerView){
            this.fragment=fragment;
            this.recyclerView=recyclerView;
        }
        @Override
        protected String doInBackground(String... params) {
            for(int i=2;i<=4;i++){
                HttpUtil.sentOkHttpRequest("http://221.226.251.244:5188/wenkor_service/school/news/"+i+"/detail", new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String a = response.body().string();
                        System.out.println(a);
                        Gson gson = new Gson();
                        java.lang.reflect.Type type = new TypeToken<CollegeNews>() {
                        }.getType();
                        CollegeNews jsonBean = gson.fromJson(a, type);
                        String content = jsonBean.getData().getNewsContent();
                        System.out.println(jsonBean.getData().getImgUrl());
                        String reg = "[^\u4e00-\u9fa5]";
                        content = content.replaceAll(reg, "");
                        College data = new College(jsonBean.getData().getImgUrl(), jsonBean.getData().getNewsTitle(), content);
                        collegeList.add(data);
                    }
                });
            }
            return null;
        }
        protected void onPostExecute(String result){
            System.out.println(collegeList);
                    CollegeAdapter adapter = new CollegeAdapter(fragment.getContext(), collegeList);
                    recyclerView.setAdapter(adapter);

        }
    }*/

}





