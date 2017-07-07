package com.horical.hrc7.supplier.app;

import android.content.Context;

import com.horical.hrc7.libsupports.AssetHelper;
import com.horical.hrc7.libsupports.CacheHelper;
import com.horical.hrc7.libsupports.FileHelper;
import com.horical.hrc7.libsupports.HttpHelper;

import java.io.File;

import static com.horical.hrc7.supplier.app.AppConfig.FOLDER_CACHE;
import static com.horical.hrc7.supplier.app.AppConfig.FOLDER_DATA;

/**
 * Created by Billy Phan on 6/21/2017.
 */

public class AppManager {
    private static Context context;
    private static AssetHelper asset = null;
    private static CacheHelper cache = null;
    private static HttpHelper http = null;
    private static FileHelper file = null;
    private static AppDataConfig appDataConfig = null;

    public static void load(Context context) {
        AppManager.context = context;
        initConfig();
    }

    synchronized static public AssetHelper asset() {
        if (asset == null) asset = new AssetHelper(context);
        return asset;
    }

    synchronized static public CacheHelper cache() {
        if (cache == null) cache = new CacheHelper(context,
                AppConfig.FOLDER_CACHE,
                AppConfig.FILE_CACHE);
        return cache;
    }

    synchronized static public HttpHelper http() {
        if (http == null) http = new HttpHelper(AppConfig.API_URL);
        return http;
    }

    synchronized public static FileHelper file() {
        if (file == null) file = new FileHelper();
        return file;
    }

    synchronized public static AppDataConfig dataConfig() {
        if (appDataConfig == null) appDataConfig = new AppDataConfig();
        return appDataConfig;
    }

    private static void initConfig() {
        //create folder data
        File file = new File(FOLDER_DATA);
        boolean dirExist = true;
        if (!file.exists()) {
            dirExist = file.mkdir();
        }
        if (!dirExist) throw new RuntimeException("Folder Data can't created ");

        //create folder cache
        file = new File(FOLDER_CACHE);
        if (!file.exists()) {
            dirExist = file.mkdir();
        }
        if (!dirExist) throw new RuntimeException("Folder Cache can't created ");
    }
}
