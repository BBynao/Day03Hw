package com.example.day03hw.presenter;

import com.example.day03hw.bean.SchoolBean;
import com.example.day03hw.callback.SchoolCallBack;
import com.example.day03hw.molder.ImpSchoolMolder;
import com.example.day03hw.view.SchooolView;

public class ImpSchoolPresenten implements SchoolPresenter, SchoolCallBack {
    private ImpSchoolMolder molder;
    private SchooolView view;

    public ImpSchoolPresenten(ImpSchoolMolder molder, SchooolView view) {
        this.molder = molder;
        this.view = view;
    }

    @Override
    public void initData() {
        if (molder != null) {
            molder.initData(this);
        }
    }

    @Override
    public void OnTrue(SchoolBean schoolBean) {
        if (view != null) {
            view.OnTrue(schoolBean);
        }
    }

    @Override
    public void OnFalse(String error) {
        if (view != null) {
            view.OnFalse(error);
        }

    }
}
