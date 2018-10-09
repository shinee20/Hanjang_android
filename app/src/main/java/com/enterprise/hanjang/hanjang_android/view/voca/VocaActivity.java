package com.enterprise.hanjang.hanjang_android.view.voca;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.enterprise.hanjang.hanjang_android.MainActivity;
import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.view.record.RecordActivity;
import com.enterprise.hanjang.hanjang_android.view.record.RecordWriteNewActivity;
import com.enterprise.hanjang.hanjang_android.view.setting.SettingActivity;
import com.enterprise.hanjang.hanjang_android.view.voca.adapter.VocaPagerAdapter;

/**
 * Created by shineeseo on 2018. 9. 13..
 */

public class VocaActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private ViewPager pager;
    private ImageView menu_btn;
    private DrawerLayout mDrawerLayout;
    private Intent intent;
    private NavigationView navigationView;
    private ImageView drawer_close_btn;
    public final static int[] VOCA_RECTANGLE_COLOR = {R.color.recordcolor, R.color.recordcolor2, R.color.recordcolor3, R.color.recordcolor4, R.color.recordcolor5, R.color.recordcolor6, R.color.recordcolor7};
    private ProgressBar progressBar;
    private FloatingActionButton fab;
    private TextView total_page;
    private TextView cur_page;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_voca);

        //navigation drawer menu
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        navigationView = (NavigationView) findViewById(R.id.navigation_view);

        View nav_header_view = navigationView.getHeaderView(0);

        menu_btn = (ImageView) findViewById(R.id.menu_btn);

        menu_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("click", "click");

                mDrawerLayout.openDrawer(Gravity.LEFT);

            }
        });

        navigationView.setNavigationItemSelectedListener(VocaActivity.this);
        navigationView.getMenu().getItem(1).setChecked(true);

        drawer_close_btn = (ImageView) nav_header_view.findViewById(R.id.drawer_close_btn);

        drawer_close_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mDrawerLayout.closeDrawer(Gravity.LEFT);
            }
        });
        total_page = (TextView)findViewById(R.id.total_page);
        cur_page = (TextView)findViewById(R.id.cur_page);

        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setMax(6);

        pager = (ViewPager) findViewById(R.id.voca_viewPager);

        //ViewPager에 설정할 Adapter 객체 생성

        //ListView에서 사용하는 Adapter와 같은 역할.

        //다만. ViewPager로 스크롤 될 수 있도록 되어 있다는 것이 다름

        //PagerAdapter를 상속받은 CustomAdapter 객체 생성

        //CustomAdapter에게 LayoutInflater 객체 전달

        VocaPagerAdapter adapter = new VocaPagerAdapter(progressBar.getMax(), getLayoutInflater());

        total_page.setText(String.valueOf(String.format("%02d",progressBar.getMax())));
        //ViewPager에 Adapter 설정

        pager.setAdapter(adapter);
        pager.setClipToPadding(false);
        pager.setPadding(40, 0, 40, 0);
//        pager.setPageMargin(getResources().getDisplayMetrics().widthPixels / -9);
        pager.setPageMargin(20);

        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                progressBar.setProgress(position+1);
                cur_page.setText(String.valueOf(String.format("%02d", position + 1)));
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        fab = (FloatingActionButton) findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VocaActivity.this, RecordWriteNewActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        item.setChecked(true);

        int id = item.getItemId();
        switch (id) {
            case R.id.navigation_item_today_word:
                intent = new Intent(VocaActivity.this, MainActivity.class);
                break;

            case R.id.navigation_item_voca:
                intent = new Intent(VocaActivity.this, VocaActivity.class);
                break;

            case R.id.navigation_item_record:
                intent = new Intent(VocaActivity.this, RecordActivity.class);
                break;
            case R.id.navigation_item_setting:
                intent = new Intent(VocaActivity.this, SettingActivity.class);
                break;

        }

        startActivity(intent);
        return true;

    }
}
