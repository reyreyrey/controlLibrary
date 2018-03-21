package cn.config;

import android.app.Application;
import android.support.annotation.DrawableRes;

import java.util.Date;

/**
 * Created by wiki on 2018/3/21.
 */

public interface ILibraryConfig {

    LibraryConfig.Builder with(Application application);

    LibraryConfig.Builder appId(String appId);

    LibraryConfig.Builder splashShowCaipiaoTime(Date date);

    LibraryConfig.Builder slpashNormalRes(@DrawableRes int res);

    LibraryConfig.Builder slpashCaipiaoRes(@DrawableRes int res);

    LibraryConfig build();
}
