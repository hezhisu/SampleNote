package com.cdut.note.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cdut.note.view.lib.JazzyViewPager;
import com.cdut.note.view.lib.OutlineContainer;
import com.cdut.note.view.original.TopBanner;

import java.util.List;

/**
 * Created by Administrator on 2014/12/14.
 */
public class JazzViewPagerAdapter extends PagerAdapter {
    private Context mContext;
    private JazzyViewPager mJazzy;
    private List<TopBanner> mBanners;
    public JazzViewPagerAdapter(Context mContext, JazzyViewPager jazz, List<TopBanner> banners) {
        this.mContext = mContext;
        this.mJazzy = jazz;
        this.mBanners = banners;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        container.addView(mBanners.get(position), ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        mJazzy.setObjectForPosition(mBanners.get(position), position);
        return mBanners.get(position);
    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object obj) {
        container.removeView(mJazzy.findViewFromObject(position));
    }
    @Override
    public int getCount() {
        return mBanners.size();
    }
    @Override
    public boolean isViewFromObject(View view, Object obj) {
        if (view instanceof OutlineContainer) {
            return ((OutlineContainer) view).getChildAt(0) == obj;
        } else {
            return view == obj;
        }
    }
}
