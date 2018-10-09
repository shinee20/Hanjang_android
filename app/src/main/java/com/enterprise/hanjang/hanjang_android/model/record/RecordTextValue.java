package com.enterprise.hanjang.hanjang_android.model.record;

/**
 * Created by shineeseo on 2018. 10. 9..
 */

public class RecordTextValue {
    public float record_txt_size;
    public float record_txt_letter_spacing;
    public float record_txt_line_spacing;

    public RecordTextValue(float record_txt_size, float record_txt_letter_spacing, float record_txt_line_spacing) {
        this.record_txt_size = record_txt_size;
        this.record_txt_letter_spacing = record_txt_letter_spacing;
        this.record_txt_line_spacing = record_txt_line_spacing;
    }

    public float getRecord_txt_size() {
        return record_txt_size;
    }

    public void setRecord_txt_size(float record_txt_size) {
        this.record_txt_size = record_txt_size;
    }

    public float getRecord_txt_letter_spacing() {
        return record_txt_letter_spacing;
    }

    public void setRecord_txt_letter_spacing(float record_txt_letter_spacing) {
        this.record_txt_letter_spacing = record_txt_letter_spacing;
    }

    public float getRecord_txt_line_spacing() {
        return record_txt_line_spacing;
    }

    public void setRecord_txt_line_spacing(float record_txt_line_spacing) {
        this.record_txt_line_spacing = record_txt_line_spacing;
    }
}
