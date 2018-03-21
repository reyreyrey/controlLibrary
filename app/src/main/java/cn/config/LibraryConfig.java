package cn.config;

import android.app.Application;
import android.support.annotation.DrawableRes;

import java.util.Date;

/**
 * Created by wiki on 2018/3/21.
 */

public class LibraryConfig extends AbstractLibraryConfig {
    private LibraryConfig(){}

    public static class Builder implements ILibraryConfig{
        private LibraryConfig libraryConfig = new LibraryConfig();

        @Override
        public Builder with(Application application) {
            libraryConfig.setApplication(application);
            return this;
        }

        @Override
        public Builder appId(String appId) {
            libraryConfig.setAppId(appId);
            return this;
        }

        @Override
        public Builder splashShowCaipiaoTime(Date date) {
            libraryConfig.setSplashShowCaipiaoTime(date);
            return this;
        }

        @Override
        public Builder slpashNormalRes(@DrawableRes int res) {
            libraryConfig.setNormalRes(res);
            return this;
        }

        @Override
        public Builder slpashCaipiaoRes(@DrawableRes int res) {
            libraryConfig.setCaipiaoRes(res);
            return this;
        }

        @Override
        public LibraryConfig build() {
            return libraryConfig;
        }
    }
}
