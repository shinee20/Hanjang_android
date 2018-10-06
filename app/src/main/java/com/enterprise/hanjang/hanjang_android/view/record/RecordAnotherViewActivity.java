package com.enterprise.hanjang.hanjang_android.view.record;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.model.record.RecordItem;
import com.enterprise.hanjang.hanjang_android.view.record.adapter.RecordAnotherViewAdapter;

import java.util.ArrayList;

/**
 * Created by shineeseo on 2018. 10. 2..
 */

public class RecordAnotherViewActivity extends AppCompatActivity {
    ArrayList<RecordItem> recordItemList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_another);

        StaggeredGridLayoutManager mStgaggeredGridLayoutManager;

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.record_recyclerview);

        mStgaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(mStgaggeredGridLayoutManager);


        recordItemList = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            recordItemList.add(new RecordItem("온새미로", "오늘의 일기,\n" +
                    "정동 길 회화나무는 몇 년을 지나도 온새미로 고고하다. 너도 여전히 온새미로 보기 좋구나.", "2018. 06. 25",i ));
        }

        RecordAnotherViewAdapter recordAnotherViewAdapter = new RecordAnotherViewAdapter(this, recordItemList);

        mRecyclerView.setAdapter(recordAnotherViewAdapter);
    }
}
