package com.android.zzw.cloudscreen.Adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.android.zzw.cloudscreen.Bean.College;
import com.android.zzw.cloudscreen.R;

import java.util.ArrayList;

/**
 * Created by zzw on 2017/5/7.
 */

public class CollegeDetailAdapter extends RecyclerView.Adapter<CollegeDetailAdapter.ViewHolder> {
    private ArrayList<College> list;
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.college_detail_recvclerview, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        College data = list.get(position);
        holder.content.setText(data.getNewsContent());
        holder.title.setText(data.getNewsTitle());
        holder.view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(position,v);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView content;
        View view;

        public ViewHolder(View view) {
            super(view);
            this.view = view;
            title = (TextView) view.findViewById(R.id.title);
            content = (TextView) view.findViewById(R.id.content);
        }
    }

    public CollegeDetailAdapter(Context context, ArrayList<College> list) {
        this.list = list;
        this.context = context;
    }

    public interface OnItemClickListener {
        void onClick(int position, View v);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.mOnItemClickListener = onItemClickListener;
    }
}
