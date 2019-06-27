package com.example.day03hw.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day03hw.R;
import com.example.day03hw.bean.SchoolBean;

import java.util.ArrayList;

public class SchoolAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<SchoolBean.DataBean.DatasBean> mList;
    private View inflate;
    private View inflate1;
    private View inflate2;
    private View inflate3;
    private SchoolBean.DataBean.DatasBean datasBean;

    public SchoolAdapter(Context mContext, ArrayList<SchoolBean.DataBean.DatasBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0){
            inflate = LayoutInflater.from(mContext).inflate(R.layout.school_itme_one, null);
            return new ViewHolder1(inflate);
        }else if (viewType == 1){
            inflate1 = LayoutInflater.from(mContext).inflate(R.layout.school_itme_two, null);
            return new ViewHolder2(inflate1);
        } else if (viewType == 2) {
            inflate2 = LayoutInflater.from(mContext).inflate(R.layout.school_itme_three, null);
            return new ViewHolder3(inflate2);
        } else if (viewType == 3) {
            inflate3 = LayoutInflater.from(mContext).inflate(R.layout.school_itme_four, null);
            return new ViewHolder4(inflate3);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        int itemViewType = getItemViewType(position);
        datasBean = mList.get(position);
        if (itemViewType == 0) {
            ViewHolder1 viewHolder1 = (ViewHolder1) holder;
            viewHolder1.tv_title_one.setText(datasBean.getTitle());
            Glide.with(mContext).load(datasBean.getEnvelopePic()).into(viewHolder1.iv_one);
        } else if (itemViewType == 1) {
            ViewHolder2 viewHolder2 = (ViewHolder2) holder;
            viewHolder2.tv_chapterName.setText(datasBean.getChapterName());
            viewHolder2.tv_chapterName2.setText(datasBean.getChapterName());
            Glide.with(mContext).load(datasBean.getEnvelopePic()).into(viewHolder2.iv_two);
            Glide.with(mContext).load(datasBean.getEnvelopePic()).into(viewHolder2.iv2_two);

        } else if (itemViewType == 2) {
            ViewHolder3 viewHolder3 = (ViewHolder3) holder;
            viewHolder3.tv_desc_three.setText(datasBean.getTitle());
            Glide.with(mContext).load(datasBean.getEnvelopePic()).into(viewHolder3.iv_three);
        } else if (itemViewType == 3) {
            ViewHolder4 viewHolder4 = (ViewHolder4) holder;
            viewHolder4.tv_desc_four.setText(datasBean.getTitle());
            Glide.with(mContext).load(datasBean.getEnvelopePic()).into(viewHolder4.iv_four);

        }

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0){
            return 0;
        } else if (position == 1) {
            return 1;
        }else {
            if (position % 2 == 1) {
                return 2;
            }else {
                return 3;
            }
        }

    }

    class ViewHolder1 extends RecyclerView.ViewHolder {

        private final ImageView iv_one;
        private final TextView tv_title_one;
        private final View view;

        public ViewHolder1(View itemView) {
            super(itemView);
            iv_one = itemView.findViewById(R.id.iv_one);
            tv_title_one = itemView.findViewById(R.id.tv_title_one);
            view = itemView;
        }
    }

    class ViewHolder2 extends RecyclerView.ViewHolder {

        private final ImageView iv_two;
        private final ImageView iv2_two;
        private final TextView tv_chapterName;
        private final TextView tv_chapterName2;
        private final View view;

        public ViewHolder2(View itemView) {
            super(itemView);
            iv_two = itemView.findViewById(R.id.iv_two);
            iv2_two = itemView.findViewById(R.id.iv2_two);
            tv_chapterName = itemView.findViewById(R.id.tv_chapterName);
            tv_chapterName2 = itemView.findViewById(R.id.tv_chapterName2);
            view = itemView;

        }
    }

    class ViewHolder3 extends RecyclerView.ViewHolder {

        private final ImageView iv_three;
        private final TextView tv_desc_three;
        private final View view;

        public ViewHolder3(View itemView) {
            super(itemView);
            iv_three = itemView.findViewById(R.id.iv_three);
            tv_desc_three = itemView.findViewById(R.id.tv_desc_three);
            view = itemView;
        }
    }

    class ViewHolder4 extends RecyclerView.ViewHolder {

        private final ImageView iv_four;
        private final TextView tv_desc_four;
        private final View view;

        public ViewHolder4(View itemView) {
            super(itemView);
            iv_four = itemView.findViewById(R.id.iv_four);
            tv_desc_four = itemView.findViewById(R.id.tv_desc_four);
            view = itemView;
        }
    }
}
