package com.enterprise.hanjang.hanjang_android.view.record.adapter;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enterprise.hanjang.hanjang_android.R;
import com.enterprise.hanjang.hanjang_android.model.record.RecordItem;

import java.util.ArrayList;

/**
 * Created by shineeseo on 2018. 10. 2..
 */

public class RecordAnotherViewAdapter extends RecyclerView.Adapter<RecordAnotherViewAdapter.ViewHolder> {

    Context context;
    ArrayList<RecordItem> recordItemArrayList;

    public RecordAnotherViewAdapter(Context context, ArrayList<RecordItem> recordItemArrayList) {
        super();
        this.context = context;
        this.recordItemArrayList = recordItemArrayList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.record_another_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int i) {
        final RecordItem recordItem = recordItemArrayList.get(i);
        final int pos = i;

        viewHolder.record_another_date.setText(recordItem.getRecord_date());
        viewHolder.record_another_title.setText(recordItem.getRecord_title());
        viewHolder.record_another_mean.setText(recordItem.getRecord_mean());
        viewHolder.record_number.setText(recordItem.getRecord_number() + "");

    }

    @Override
    public int getItemCount() {
        return recordItemArrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView record_another_title;
        public TextView record_another_mean;
        public TextView record_number;
        public TextView record_another_date;


        public ViewHolder(View itemView) {
            super(itemView);
            record_another_date = (TextView) itemView.findViewById(R.id.record_another_date);
            record_number = (TextView) itemView.findViewById(R.id.record_number);
            record_another_mean = (TextView) itemView.findViewById(R.id.record_another_mean);
            record_another_title = (TextView) itemView.findViewById(R.id.record_another_title);

        }


    }


}
