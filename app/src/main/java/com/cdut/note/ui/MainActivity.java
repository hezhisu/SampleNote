package com.cdut.note.ui;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import com.cdut.note.ActivityUtil;
import com.cdut.note.R;
import com.cdut.note.adapter.JazzViewPagerAdapter;
import com.cdut.note.view.lib.JazzyViewPager;
import com.cdut.note.view.original.TopBanner;
import com.cdut.note.view.original.TopView;
import com.cdut.note.view.original.WeatherView;

import java.util.ArrayList;
import java.util.List;

import static android.view.GestureDetector.OnGestureListener;

/**
 * Created by Administrator on 2014/12/10.
 */
public class MainActivity extends BaseActivity{
    private JazzyViewPager mJazzyViewPager;
    private JazzViewPagerAdapter mAdapter;
    private TopBanner mWeaherBanner;
    private TopBanner mPhotoBanner;
    private WeatherView mWeatherView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initTopBanner();
        findViewById(R.id.btn_add_note).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ActivityUtil.next(getContext(),AddNoteActivity.class);
            }
        });
    }
    public void initTopBanner(){
        mJazzyViewPager = (JazzyViewPager) findViewById(R.id.jazzViewPager);
        mJazzyViewPager.setFadeEnabled(true);
        mJazzyViewPager.setTransitionEffect(JazzyViewPager.TransitionEffect.Stack);
        /**init the weather banner*/
        mWeaherBanner = new TopBanner(this);
        mWeatherView = new WeatherView(this);
        mWeaherBanner.addView(mWeatherView);
        mPhotoBanner = new TopBanner(this);

        /**init the photo banner*/
        TopView mTopView = new TopView(this);
        mTopView.init(this,BitmapFactory.decodeResource(getResources(),R.drawable.common_bar_bg));
        mPhotoBanner.addView(mTopView);
        mTopView = new TopView(this);
        mTopView.init(this,BitmapFactory.decodeResource(getResources(),R.drawable.common_bar_bg2));
        mPhotoBanner.addView(mTopView);
        mTopView = new TopView(this);
        mTopView.init(this,BitmapFactory.decodeResource(getResources(),R.drawable.common_bar_bg3));
        mPhotoBanner.addView(mTopView);
        mTopView = new TopView(this);
        mTopView.init(this,BitmapFactory.decodeResource(getResources(),R.drawable.common_bar_bg4));
        mPhotoBanner.addView(mTopView);
        mPhotoBanner.createTimer();
        List<TopBanner> banners = new ArrayList<TopBanner>();
        banners.add(mWeaherBanner);
        banners.add(mPhotoBanner);
        mAdapter = new JazzViewPagerAdapter(this,mJazzyViewPager,banners);
        mJazzyViewPager.setAdapter(mAdapter);
        mJazzyViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if(position == 1){
                    mWeatherView.changeBg();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }
}
