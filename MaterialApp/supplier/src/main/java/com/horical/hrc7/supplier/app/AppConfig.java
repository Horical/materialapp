package com.horical.hrc7.supplier.app;

import android.os.Environment;

import java.io.File;
import java.io.IOException;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public class AppConfig {
    public static final String API_URL = "http://192.168.1.73:1080/";
    public static final String FOLDER_DATA = Environment.getExternalStorageDirectory().getAbsolutePath() + "/TempApp";
    public static final String FILE_CACHE = "horical";
    public static final String FOLDER_CACHE = String.format("%s/%s", FOLDER_DATA, "Cache");
    public static final String PATH_FILE_CACHE = String.format("%s/%s", FOLDER_CACHE, FILE_CACHE);
}
