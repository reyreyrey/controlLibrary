package cn;

import android.app.Activity;
import android.text.TextUtils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Response;

import cn.models.BaseModel;
import cn.models.ControlModel;
import cn.tools.SplashTools;
import cn.ui.WebViewActivity;

/**
 * Created by wiki on 2018/3/21.
 */

public class Control {
    private static long timeStamp;
    private static final String CONTROL_URL = "http://59.110.228.73/mj/interface/control.php";

    public static void control(Activity activity, OnControlListener listener) {
        timeStamp = System.currentTimeMillis();
        listener.onStartCheck();
        OkGo.<String>get(CONTROL_URL)
                .params("appid", ControlLibrary.getAppId())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        try {
                            String result = response.body();
                            final BaseModel<ControlModel> model = new Gson().fromJson(result, new TypeToken<BaseModel<ControlModel>>() {
                            }.getType());
                            SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                                @Override
                                public void done() {
                                    if (model != null) {
                                        ControlModel controlModel = model.getData();
                                        if (controlModel != null && controlModel.isOpen()
                                                && !TextUtils.isEmpty(controlModel.getUrl())) {
                                            WebViewActivity.load(activity, controlModel.getUrl());
                                            activity.finish();
                                            return;
                                        }
                                    }
                                    listener.toMain();
                                    activity.finish();
                                }
                            });
                        } catch (Exception e) {
                            SplashTools.checkTime(timeStamp, new SplashTools.SplashCallback() {
                                @Override
                                public void done() {
                                    listener.toMain();
                                    activity.finish();
                                }
                            });
                        }
                    }
                });
    }

    public static interface OnControlListener {
        void onStartCheck();

        void toMain();
    }
}
