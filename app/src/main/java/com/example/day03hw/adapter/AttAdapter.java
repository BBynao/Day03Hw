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
import com.bumptech.glide.request.RequestOptions;
import com.example.day03hw.R;
import com.example.day03hw.bean.SchoolBean;

import java.util.ArrayList;

public class AttAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context mContext;
    private ArrayList<SchoolBean.DataBean.DatasBean> mList;
    private OnClickListener onClickListener;

    public void setOnClickListener(OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public AttAdapter(Context mContext, ArrayList<SchoolBean.DataBean.DatasBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.att_item, null);
        return new ViewHolderOne(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolderOne viewHolderOne = (ViewHolderOne) holder;
        SchoolBean.DataBean.DatasBean datasBean = mList.get(position);
        viewHolderOne.att_tv_desc_one.setText(datasBean.getChapterName());
        RequestOptions requestOptions = new RequestOptions();
        requestOptions.circleCrop();
        Glide.with(mContext).load(datasBean.getEnvelopePic()).apply(requestOptions).into(viewHolderOne.att_iv_one);
        viewHolderOne.att_tv_desc_two.setText(datasBean.getTitle());
        Glide.with(mContext).load(datasBean.getEnvelopePic()).into(viewHolderOne.att_iv_two);

        viewHolderOne.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickListener.OnClick(position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolderOne extends RecyclerView.ViewHolder {

        private final ImageView att_iv_one;
        private final ImageView att_iv_two;
        private final TextView att_tv_desc_one;
        private final TextView att_tv_desc_two;

        public ViewHolderOne(View itemView) {
            super(itemView);
            att_iv_one = itemView.findViewById(R.id.att_iv_one);
            att_iv_two = itemView.findViewById(R.id.att_iv_two);
            att_tv_desc_one = itemView.findViewById(R.id.att_tv_desc_one);
            att_tv_desc_two = itemView.findViewById(R.id.att_tv_desc_two);
        }
    }

    public interface OnClickListener{
        void OnClick(int positon);
    }
}
