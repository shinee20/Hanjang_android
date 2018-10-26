package com.enterprise.hanjang.hanjang_android.model.record;

import com.enterprise.hanjang.hanjang_android.model.word.WordData;

import java.io.Serializable;

/**
 * Created by shineeseo on 2018. 10. 2..
 */

public class RecordItem implements Serializable{
    public String record_title;
    public String record_mean;
    public String record_date;

    public RecordItem(String record_title, String record_mean, String record_date) {
        this.record_title = record_title;
        this.record_mean = record_mean;
        this.record_date = record_date;
    }


    public String getRecord_title() {
        return record_title;
    }

    public void setRecord_title(String record_title) {
        this.record_title = record_title;
    }

    public String getRecord_mean() {
        return record_mean;
    }

    public void setRecord_mean(String record_mean) {
        this.record_mean = record_mean;
    }

    public String getRecord_date() {
        return record_date;
    }

    public void setRecord_date(String record_date) {
        this.record_date = record_date;
    }

    @Override
    public String toString() {
        return "RecordItem{" +
                "record_title='" + record_title + '\'' +
                ", record_mean='" + record_mean + '\'' +
                ", record_date='" + record_date + '\'' +
                '}';
    }
}
