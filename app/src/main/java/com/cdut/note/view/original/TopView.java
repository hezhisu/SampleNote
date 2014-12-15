package com.cdut.note.view.original;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.cdut.note.R;
import com.cdut.note.util.UIUtil;

/**
 * Created by Administrator on 2014/12/13.
 */
public class TopView extends FrameLayout{
    private ImageView mImg;
    private TranslateAnimation amin;
    public TopView(Context context) {
        super(context);
    }

    public TopView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TopView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public void init(Context context, Bitmap bitmap){
        LayoutInflater.from(context).inflate(R.layout.layout_topview, this, true);
        mImg = (ImageView) findViewById(R.id.img);
        initVerticalAnim(context,bitmap);
    }
    private void initVerticalAnim(Context context, Bitmap bitmap){
        LayoutParams params = (LayoutParams) mImg.getLayoutParams();
        params.width = UIUtil.getInstance().getScreenWidth(context);
        float scale = (float) (bitmap.getWidth() * 1.0 / UIUtil.getInstance().getScreenWidth(context));
        params.height = (int) (bitmap.getHeight()/scale);
        mImg.setLayoutParams(params);
        mImg.setImageBitmap(bitmap);
        amin = new TranslateAnimation(0, 0, 0, UIUtil.getInstance().dip2px(context, 200)-params.height);
        amin.setRepeatMode(Animation.REVERSE);
        amin.setRepeatCount(Animation.INFINITE);
        amin.setInterpolator(new AccelerateDecelerateInterpolator());
        amin.setDuration(25000);
        mImg.startAnimation(amin);
    }
}
