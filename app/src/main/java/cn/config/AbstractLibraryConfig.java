package cn.config;

import android.app.Application;
import android.support.annotation.DrawableRes;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import cn.control.R;

/**
 * Created by wiki on 2018/3/21.
 */
abstract class AbstractLibraryConfig {
    private String appId;
    private Date splashShowCaipiaoTime;
    private String strSplashShowCaipiaoTime;
    private Application application;
    private @DrawableRes int normalRes;
    private @DrawableRes int caipiaoRes;

    AbstractLibraryConfig(){
        normalRes = R.drawable.ic_splash_normal;
    }

    public int getNormalRes() {
        return normalRes;
    }

    public void setNormalRes(int normalRes) {
        this.normalRes = normalRes;
    }

    public int getCaipiaoRes() {
        return caipiaoRes;
    }

    public void setCaipiaoRes(int caipiaoRes) {
        this.caipiaoRes = caipiaoRes;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Date getSplashShowCaipiaoTime() {
        return splashShowCaipiaoTime;
    }

    public String getStrSplashShowCaipiaoTime() {
        return strSplashShowCaipiaoTime;
    }

    public void setSplashShowCaipiaoTime(String splashShowCaipiaoTime) {
            this.strSplashShowCaipiaoTime = splashShowCaipiaoTime;
        try {
            this.splashShowCaipiaoTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(splashShowCaipiaoTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
