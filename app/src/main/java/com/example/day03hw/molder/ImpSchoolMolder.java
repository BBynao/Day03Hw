package com.example.day03hw.molder;

import com.example.day03hw.bean.SchoolBean;
import com.example.day03hw.callback.SchoolCallBack;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class ImpSchoolMolder implements SchoolMolder {
    @Override
    public void initData(final SchoolCallBack schoolCallBack) {
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .build();

        Request request = new Request.Builder()
                .url("https://www.wanandroid.com/project/list/1/json?cid=294")
                .get()
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                schoolCallBack.OnFalse(e.getMessage());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String string = response.body().string();
                Gson gson = new Gson();
                SchoolBean schoolBean = gson.fromJson(string, SchoolBean.class);
                schoolCallBack.OnTrue(schoolBean);


            }
        });
    }
}
