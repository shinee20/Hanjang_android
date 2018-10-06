package com.enterprise.hanjang.hanjang_android;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.enterprise.hanjang.hanjang_android.view.login.LoginActivity;
import com.enterprise.hanjang.hanjang_android.view.record.RecordAnotherViewActivity;
import com.enterprise.hanjang.hanjang_android.view.record.RecordWriteNewActivity;

/**
 * Created by shineeseo on 2018. 9. 12..
 */

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        final Intent intent = new Intent(this,MainActivity.class);

        handler.postDelayed(new Runnable(){
            @Override
            public void run() {
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
