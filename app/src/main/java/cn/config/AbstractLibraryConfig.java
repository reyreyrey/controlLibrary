package cn.config;

import android.app.Application;
import android.support.annotation.DrawableRes;

import java.util.Date;

import cn.control.R;

/**
 * Created by wiki on 2018/3/21.
 */
abstract class AbstractLibraryConfig {
    private String appId;
    private Date splashShowCaipiaoTime;
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

    public void setSplashShowCaipiaoTime(Date splashShowCaipiaoTime) {
        this.splashShowCaipiaoTime = splashShowCaipiaoTime;
    }

    public Application getApplication() {
        return application;
    }

    public void setApplication(Application application) {
        this.application = application;
    }
}
