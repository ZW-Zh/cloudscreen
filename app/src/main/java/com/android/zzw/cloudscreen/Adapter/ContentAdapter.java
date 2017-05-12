package com.android.zzw.cloudscreen.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.zzw.cloudscreen.R;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/5/5.
 */

public class ContentAdapter extends RecyclerView.Adapter<ContentAdapter.MyViewHolder> implements View.OnClickListener {
    private ArrayList<String>content = new ArrayList<>();
    private OnItemClickListener mOnItemClickListener = null;
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MyViewHolder holder = new MyViewHolder(LayoutInflater.from(
                parent.getContext()).inflate(R.layout.college_content_recyclerview, parent,
                false));

        holder.view.setOnClickListener(this);
        return holder;
    }
    public ContentAdapter(ArrayList<String> content){
        this.content=content;
    }
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.view.setTag(position);
        holder.tv.setText(content.get(position));
    }

    @Override
    public int getItemCount() {
        return content.size();
    }

    @Override
    public void onClick(View v) {
        if (mOnItemClickListener != null) {
            //注意这里使用getTag方法获取position
            mOnItemClickListener.onItemClick(v,(int)v.getTag());
        }
    }


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView gettextview(){
            return tv;
        }
        public ImageView getCursor(){return cursor;}
        public View getView(){return view;}
        TextView tv;
        ImageView cursor;
        View view;
        public MyViewHolder(View view)
        {
            super(view);
            this.view=view;
            tv = (TextView) view.findViewById(R.id.text);
            cursor= (ImageView) view.findViewById(R.id.cursor);
        }
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
