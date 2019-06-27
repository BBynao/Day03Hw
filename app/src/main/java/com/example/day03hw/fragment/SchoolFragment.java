package com.example.day03hw.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day03hw.R;
import com.example.day03hw.adapter.SchoolAdapter;
import com.example.day03hw.bean.SchoolBean;
import com.example.day03hw.molder.ImpSchoolMolder;
import com.example.day03hw.presenter.ImpSchoolPresenten;
import com.example.day03hw.view.SchooolView;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class SchoolFragment extends Fragment implements SchooolView {


    private View view;
    private RecyclerView mRev;
    private ImpSchoolPresenten impSchoolPresenten;
    private List<SchoolBean.DataBean.DatasBean> mList;
    private SchoolAdapter schoolAdapter;
    private ArrayList<SchoolBean.DataBean.DatasBean> datasBeans;

    public SchoolFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflate = inflater.inflate(R.layout.fragment_school, container, false);
        impSchoolPresenten = new ImpSchoolPresenten(new ImpSchoolMolder(), this);
        initView(inflate);
        initData();
        return inflate;
    }

    private void initData() {
        impSchoolPresenten.initData();
    }

    private void initView(View inflate) {
        mRev = (RecyclerView) inflate.findViewById(R.id.rev);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        mRev.setLayoutManager(linearLayoutManager);
    }


    @Override
    public void OnTrue(final SchoolBean schoolBean) {
        mList = schoolBean.getData().getDatas();
        datasBeans = new ArrayList<>();
        datasBeans.addAll(mList);
        schoolAdapter = new SchoolAdapter(getContext(),datasBeans);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {

                mRev.setAdapter(schoolAdapter);
            }
        });

    }

    @Override
    public void OnFalse(String error) {

    }
}
