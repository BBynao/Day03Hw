package com.example.day03hw;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class WelcomeActivity extends AppCompatActivity {

    /**
     * 5
     */
    private TextView mTv;
    private String namw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        initView();
    }

    private void initView() {
        mTv = (TextView) findViewById(R.id.tv);
        new CountDownTimer(5000, 1000
        ) {
            @Override
            public void onTick(long l) {
                mTv.setText("倒计时："+ l / 1000);
            }

            @Override
            public void onFinish() {
                startActivity(new Intent(WelcomeActivity.this,MainActivity.class));
            }
        }.start();
    }
}
