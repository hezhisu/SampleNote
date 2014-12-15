package com.cdut.note.view.original;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.cdut.note.R;

/**
 * Created by Administrator on 2014/12/14.
 */
public class WeatherView extends RelativeLayout{
    public WeatherView(Context context) {
        super(context);
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public WeatherView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }
    public void init(Context context){
        LayoutInflater.from(context).inflate(R.layout.layout_weather_view, this, true);
        changeBg();
    }
    public void changeBg(){
        int bg = Color.rgb((int) Math.floor(Math.random() * 128) + 64,
                (int) Math.floor(Math.random() * 128) + 64,
                (int) Math.floor(Math.random() * 128) + 64);
        this.setBackgroundColor(bg);
    }
}
