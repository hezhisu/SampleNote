package com.cdut.note.ui;
import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

import com.cdut.note.ActivityUtil;
import com.cdut.note.R;

/**
 * The BaseActivity package some base operations,your activity
 * should inherit the class,so that you can use these operations.
 * In this way, you can manage your activities easily
 * Created by Administrator on 2014/12/10.
 */
public class BaseActivity extends Activity{
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        /**pop the activity out-of the stack*/
        ActivityUtil.popActivity(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**push the activity into the stack*/
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        ActivityUtil.pushActivity(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        /**here sava your data*/
    }
    protected void setHeader(String text){
        TextView mHeaderText = (TextView) findViewById(R.id.header_text);
        mHeaderText.setText(text);
        findViewById(R.id.btn_header_back).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.goBack(BaseActivity.this);
            }
        });
    }
    protected Activity getContext(){
        return BaseActivity.this;
    }
}
