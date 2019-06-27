package com.example.day03hw.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03hw.R;
import com.example.day03hw.Web;
import com.example.day03hw.adapter.AttAdapter;
import com.example.day03hw.bean.SchoolBean;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class AttFragment extends Fragment {


    private View view;
    private RecyclerView mRev;
    private ArrayList<SchoolBean.DataBean.DatasBean> mList;
    private AttAdapter attAdapter;

    public AttFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_att, container, false);
        initView(inflate);
        return inflate;
    }

    private void initView(View inflate) {
        mRev = (RecyclerView) inflate.findViewById(R.id.rev);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRev.setLayoutManager(linearLayoutManager);
        initData();
    }

    private void initData() {
        OkHttpClient okHttpClient = new OkHttpClient.Builder().build();
        Request build = new Request.Builder()
                .url("https://www.wanandroid.com/project/list/1/json?cid=294")
                .get()
                .build();
        Call call = okHttpClient.newCall(build);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                SchoolBean schoolBean = new Gson().fromJson(string, SchoolBean.class);
                mList = new ArrayList<>();
                List<SchoolBean.DataBean.DatasBean> datas = schoolBean.getData().getDatas();
                mList.addAll(datas);
                attAdapter = new AttAdapter(getContext(), mList);
                attAdapter.setOnClickListener(new AttAdapter.OnClickListener() {
                    @Override
                    public void OnClick(int positon) {
                        String envelopePic = mList.get(positon).getLink();
                        Intent intent = new Intent(getContext(), Web.class);
                        intent.putExtra("pic",envelopePic);
                        startActivity(intent);
                    }
                });
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        mRev.setAdapter(attAdapter);
                    }
                });

            }
        });

    }
}
