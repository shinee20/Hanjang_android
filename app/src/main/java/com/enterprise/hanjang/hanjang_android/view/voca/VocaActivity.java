package com.enterprise.hanjang.hanjang_android.view.voca;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.view.voca.adapter.VocaPagerAdapter;

/**
 * Created by shineeseo on 2018. 9. 13..
 */

public class VocaActivity extends AppCompatActivity {
    private ViewPager pager;
    private ImageView menu_btn;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    public final static int[] VOCA_RECTANGLE_COLOR = {R.color.recordcolor,R.color.recordcolor2,R.color.recordcolor3,R.color.recordcolor4,R.color.recordcolor5,R.color.recordcolor6,R.color.recordcolor7};
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_voca);

        pager= (ViewPager)findViewById(R.id.voca_viewPager);

        menu_btn = (ImageView) findViewById(R.id.menu_btn);


        //ViewPager에 설정할 Adapter 객체 생성

        //ListView에서 사용하는 Adapter와 같은 역할.

        //다만. ViewPager로 스크롤 될 수 있도록 되어 있다는 것이 다름

        //PagerAdapter를 상속받은 CustomAdapter 객체 생성

        //CustomAdapter에게 LayoutInflater 객체 전달

        VocaPagerAdapter adapter= new VocaPagerAdapter(getLayoutInflater());

        //ViewPager에 Adapter 설정

        pager.setAdapter(adapter);
        pager.setClipToPadding(false);
        pager.setPadding(40, 0, 40, 0);
//        pager.setPageMargin(getResources().getDisplayMetrics().widthPixels / -9);
        pager.setPageMargin(20);



    }

}
