package com.cdut.note;

import android.app.Application;

import com.cdut.note.util.FileUtil;

/**
 * App Application as a singleton object
 * Created by Administrator on 2014/12/10.
 */
public class NoteApplication extends Application{
    private static NoteApplication mApp;
    private NoteApplication(){
        //Private Constructor
    }
    // Get the singleton object
    public static NoteApplication getInstance(){
        if(mApp == null){
            mApp = new NoteApplication();
        }
        return mApp;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        loadData();
    }
    /**
     * load the config or other app data
     */
    public void loadData(){
        //create the working directory
        if(FileUtil.isHasSdcard()){
            FileUtil.createDir(AppConfig.IMAGE_CACHE);
        }
    }
}
