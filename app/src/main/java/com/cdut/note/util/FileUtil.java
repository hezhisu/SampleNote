package com.cdut.note.util;

import android.os.Environment;

import java.io.File;

/**Provide some file operations
 * Created by Administrator on 2014/12/13.
 */
public class FileUtil {
    public static boolean isHasSdcard(){
        String status = Environment.getExternalStorageState();
        if (status.equals(Environment.MEDIA_MOUNTED)) {
            return true;
        } else {
            return false;
        }
    }
    public static void createDir(String dir_path){
        File destDir = new File(dir_path);
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
    }
}
