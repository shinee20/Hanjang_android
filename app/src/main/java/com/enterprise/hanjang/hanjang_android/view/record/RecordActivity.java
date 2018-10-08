package com.enterprise.hanjang.hanjang_android.view.record;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.view.record.adapter.RecordPagerAdapter;
import com.enterprise.hanjang.hanjang_android.view.voca.VocaActivity;
import com.enterprise.hanjang.hanjang_android.view.voca.adapter.VocaPagerAdapter;

/**
 * Created by shineeseo on 2018. 9. 13..
 */

public class RecordActivity extends AppCompatActivity {
    ViewPager pager;
    private FloatingActionButton actionBtn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_record);



        pager= (ViewPager)findViewById(R.id.record_viewPager);



        //ViewPager에 설정할 Adapter 객체 생성

        //ListView에서 사용하는 Adapter와 같은 역할.

        //다만. ViewPager로 스크롤 될 수 있도록 되어 있다는 것이 다름

        //PagerAdapter를 상속받은 CustomAdapter 객체 생성

        //CustomAdapter에게 LayoutInflater 객체 전달

        RecordPagerAdapter adapter= new RecordPagerAdapter(this,getLayoutInflater());



        //ViewPager에 Adapter 설정

        pager.setAdapter(adapter);
        pager.setClipToPadding(false);
        pager.setPadding(0, 0, 0, 0);
        pager.setPageMargin(0);

        actionBtn1 = (FloatingActionButton) findViewById(R.id.actionBtn1);

        actionBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecordActivity.this, RecordWriteNewActivity.class);
                startActivity(intent);
            }
        });

    }

}
