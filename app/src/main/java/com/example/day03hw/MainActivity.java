package com.example.day03hw;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.day03hw.fragment.AttFragment;
import com.example.day03hw.fragment.SchoolFragment;

import java.util.ArrayList;

//李聪   H1811b
public class MainActivity extends AppCompatActivity {

    private TabLayout mTab;
    private ViewPager mVp;
    private ArrayList<Fragment> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        mTab = (TabLayout) findViewById(R.id.tab);
        mVp = (ViewPager) findViewById(R.id.vp);

        mList = new ArrayList<>();
        mList.add(new SchoolFragment());
        mList.add(new AttFragment());

        mVp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mList.get(position);
            }

            @Override
            public int getCount() {
                return mList.size();
            }
        });

        mTab.setupWithViewPager(mVp);
        mTab.getTabAt(0).setText("校门");
        mTab.getTabAt(1).setText("关注");

    }
}
