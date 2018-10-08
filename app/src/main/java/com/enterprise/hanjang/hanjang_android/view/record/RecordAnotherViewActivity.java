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

        recordItemList.add(new RecordItem("온새미로", "오늘의 일기, 정동 길 회화나무는 몇 년을 지나도 온새미로 고고하다. 너도 여전히 온새미로 보기 좋구나.", "2018. 06. 25"));
        recordItemList.add(new RecordItem("그느르다", "그것은 처음 온 사람이라 해서 그런 것이요 윗사람이 아랫사람 그느르는 태도거나 또는 그만치나 설면하니까 인사치레로 그렇게 할 것이다.", "2018. 06. 25"));
        recordItemList.add(new RecordItem("글길", "우리 어머니는 내가 알기로 50평생 글길을 걸어왔다. 이 앱 다운받아 드려야겠다.", "2018. 06. 25"));
        recordItemList.add(new RecordItem("불편과고독", "외로움이 찾아올 때면 살며시 세상을 빠져나와 홀로 외로움을 껴안아라 얼마나 깊숙이 껴 안는가에 따라 네 삶의 깊이가 결정되리니" , "2018. 06. 25"));
        recordItemList.add(new RecordItem("생각", "허술한내 마음을 많은 생각들이 잡아먹지 않았으면 단단한 내 믿음이 얕은 견해들로 무너지지 않았으면" , "2018. 06. 25"));
        recordItemList.add(new RecordItem("삶이 무엇이냐고 묻는 너에게", "삶이 무엇이냐고 묻는 너에게 말해주고 싶구나 우리들의 삶이란 가꿀수록 아름다운 것이라고 살아갈수록 애착이 가는것이라고" , "2018. 06. 25"));


        RecordAnotherViewAdapter recordAnotherViewAdapter = new RecordAnotherViewAdapter(this, recordItemList);

        mRecyclerView.setAdapter(recordAnotherViewAdapter);
    }
}
