package com.enterprise.hanjang.hanjang_android.model.record;

/**
 * Created by shineeseo on 2018. 10. 2..
 */

public class RecordItem {
    public String record_title;
    public String record_mean;
    public String record_date;
    public int record_number;

    public RecordItem(String record_title, String record_mean, String record_date, int record_number) {
        this.record_title = record_title;
        this.record_mean = record_mean;
        this.record_date = record_date;
        this.record_number = record_number;
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

    public int getRecord_number() {
        return record_number;
    }

    public void setRecord_number(int record_number) {
        this.record_number = record_number;
    }
}
