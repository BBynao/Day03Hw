package com.example.day03hw;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Web extends AppCompatActivity {

    private WebView mWeb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        initView();
    }

    private void initView() {
        mWeb = (WebView) findViewById(R.id.web);
        mWeb.setWebViewClient(new WebViewClient());
        Intent intent = getIntent();
        String stringExtra = intent.getStringExtra("pic");
        mWeb.loadUrl(stringExtra);

    }
}
