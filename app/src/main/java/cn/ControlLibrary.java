package cn;

import android.app.Application;

import cn.config.LibraryConfig;

/**
 * Created by wiki on 2018/3/8.
 */

public class ControlLibrary {
    private static Application application;
    private static LibraryConfig config;

    public static void init(LibraryConfig config) {
        ControlLibrary.config = config;
    }

    public static Application get() {
        return config.getApplication();
    }

    public static String getAppId() {
        return config.getAppId();
    }
}
