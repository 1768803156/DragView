package com.yanxuwen.dragviewlayout;

import android.app.Application;

import com.yanxuwen.dragview.DImageLoader;

/**
 * Created by yangc on 2017/9/4.
 * E-Mail:yangchaojiang@outlook.com
 * Deprecated:
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DImageLoader.getInstance().init(new ImageLoader());
    }
}
