package com.cdut.note.ui;

import android.os.Bundle;

import com.cdut.note.R;

/**
 * Created by Administrator on 2014/12/14.
 */
public class AddNoteActivity extends BaseActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);
        setHeader("添加记录");

    }
}
