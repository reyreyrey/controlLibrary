package cn.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;

import cn.control.R;
import cn.tools.ToastUtils;
import cn.webview.x5.ProgressWebView;


public class WebViewActivity extends AppCompatActivity {
    private ProgressWebView progressWebview;

    public static void load(Context context, String url) {
        Intent intent = new Intent(context, WebViewActivity.class);
        intent.putExtra("url", url);
        context.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        init();
    }
    protected void init() {
        progressWebview = (ProgressWebView) findViewById(R.id.progress_webview);
        String url = getIntent().getStringExtra("url");
        progressWebview.getWebView().loadUrl(url);
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
    private long backTime;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (progressWebview.getWebView().canGoBack()) {
            progressWebview.getWebView().goBack();
            return super.onKeyDown(keyCode, event);
        }
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (backTime == 0) {
                backTime = System.currentTimeMillis();
                ToastUtils.toastWarn(this, getString(R.string.hybrid_exit_app));
                return true;
            }
            if ((System.currentTimeMillis() - backTime) >= 2000) {
                backTime = System.currentTimeMillis();
                ToastUtils.toastWarn(this, getString(R.string.hybrid_exit_app));
                return true;
            }
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
