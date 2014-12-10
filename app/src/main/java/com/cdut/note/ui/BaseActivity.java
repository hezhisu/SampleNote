package com.cdut.note.ui;
import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import com.cdut.note.ActivityUtil;
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
}
