package com.example.day03hw.callback;

import com.example.day03hw.bean.SchoolBean;

public interface SchoolCallBack {
    void OnTrue(SchoolBean schoolBean);
    void OnFalse(String error);

}
