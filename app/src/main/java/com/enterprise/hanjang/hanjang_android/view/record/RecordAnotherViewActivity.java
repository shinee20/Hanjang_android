package com.enterprise.hanjang.hanjang_android.view.record;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.ImageView;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.model.record.RecordItem;
import com.enterprise.hanjang.hanjang_android.view.record.adapter.RecordAnotherViewAdapter;
import com.enterprise.hanjang.hanjang_android.view.voca.VocaActivity;

import java.util.ArrayList;

/**
 * Created by shineeseo on 2018. 10. 2..
 */

public class RecordAnotherViewActivity extends AppCompatActivity {
    ArrayList<RecordItem> recordItemList;
    private FloatingActionButton actionBtn1;
    private FloatingActionButton actionBtn2;
    private Intent intent;
    private ImageView change_view_layout_btn;
    private ImageView back_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record_another);

        back_btn = (ImageView)findViewById(R.id.back_btn);

        change_view_layout_btn = (ImageView)findViewById(R.id.change_view_layout_btn);

        back_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        change_view_layout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(RecordAnotherViewActivity.this, RecordActivity.class);
                startActivity(intent);
            }
        });

        StaggeredGridLayoutManager mStgaggeredGridLayoutManager;

        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.record_recyclerview);

        mStgaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
//        mStgaggeredGridLayoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_MOVE_ITEMS_BETWEEN_SPANS);
        mRecyclerView.setLayoutManager(mStgaggeredGridLayoutManager);


        recordItemList = new ArrayList<>();

        recordItemList.add(new RecordItem("온새미로", "오늘의 일기, 정동 길 회화나무는 몇 년을 지나도 온새미로 고고하다. 너도 여전히 온새미로 보기 좋구나.", "2018. 06. 25"));
        recordItemList.add(new RecordItem("그느르다", "그것은 처음 온 사람이라 해서 그런 것이요 윗사람이 아랫사람 그느르는 태도거나 또는 그만치나 설면하니까 인사치레로 그렇게 할 것이다.", "2018. 06. 25"));
        recordItemList.add(new RecordItem("글길", "우리 어머니는 내가 알기로 50평생 글길을 걸어왔다. 이 앱 다운받아 드려야겠다.", "2018. 06. 25"));
        recordItemList.add(new RecordItem("불편과 고독", "외로움이 찾아올 때면 살며시 세상을 빠져나와 홀로 외로움을 껴안아라 " , "2018. 06. 25"));
        recordItemList.add(new RecordItem("생각", "허술한내 마음을 많은 생각들이 잡아먹지 않았으면 단단한 내 믿음이 얕은 견해들로 무너지지 않았으면" , "2018. 06. 25"));
        recordItemList.add(new RecordItem("삶", "삶이 무엇이냐고 묻는 너에게 말해주고 싶구나" , "2018. 06. 25"));


        RecordAnotherViewAdapter recordAnotherViewAdapter = new RecordAnotherViewAdapter(this, recordItemList);

        mRecyclerView.setAdapter(recordAnotherViewAdapter);

        actionBtn1 = (FloatingActionButton) findViewById(R.id.actionBtn1);

        actionBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(RecordAnotherViewActivity.this, RecordWriteNewActivity.class);
                startActivity(intent);
            }
        });

        actionBtn2 = (FloatingActionButton) findViewById(R.id.fab_to_voca);

        actionBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                intent = new Intent(RecordAnotherViewActivity.this, VocaActivity.class);
                startActivity(intent);
            }
        });

        mRecyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy)
            {
                if (dy > 0 ||dy<0 && actionBtn1.isShown() && actionBtn2.isShown() )
                {
                    actionBtn1.hide();
                    actionBtn2.hide();
                }
            }

            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState)
            {
                if (newState == RecyclerView.SCROLL_STATE_IDLE)
                {
                    actionBtn1.show();
                    actionBtn2.show();
                }

                super.onScrollStateChanged(recyclerView, newState);
            }
        });

    }
}
