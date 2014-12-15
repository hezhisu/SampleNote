package com.cdut.note.view.original;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;
import com.cdut.note.R;
import java.util.Timer;
import java.util.TimerTask;

import static android.view.GestureDetector.SimpleOnGestureListener;

/**
 * Created by Administrator on 2014/12/13.
 */
public class TopBanner extends ViewFlipper{
    private Timer mAnimationTimer = null;
    private AnimationTimerTask mAnimationTimerTask = null;
    private Animation leftInAnimation;
    private Animation leftOutAnimation;
    private Animation rightInAnimation;
    private Animation rightOutAnimation;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            TopBanner.this.setInAnimation(leftInAnimation);
            TopBanner.this.setOutAnimation(leftOutAnimation);
            TopBanner.this.showNext();
        }

    };
    public TopBanner(Context context) {
        super(context);
        init(context);
    }

    public TopBanner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    private void init(Context context) {
        leftInAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        leftOutAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_out);
        rightInAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_in);
        rightOutAnimation = AnimationUtils.loadAnimation(context, R.anim.fade_out);
    }
    class AnimationTimerTask extends TimerTask {
        @Override
        public void run() {
            handler.sendEmptyMessage(0);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void destoryTimer() {
        if (mAnimationTimerTask != null) {
            mAnimationTimerTask = null;
        }
        if (mAnimationTimer != null) {
            mAnimationTimer.cancel();
            mAnimationTimer = null;
        }
    }

    public void createTimer() {
        mAnimationTimer = new Timer();
        mAnimationTimerTask = new AnimationTimerTask();
        mAnimationTimer.schedule(mAnimationTimerTask, 10000, 10000);
    }
}
