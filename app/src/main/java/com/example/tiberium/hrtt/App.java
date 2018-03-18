package com.example.tiberium.hrtt;

import android.app.Application;

/**
 * Created by TIBERIUM on 21.11.2017.
 */

public class App extends Application {
    private static App mInstance;
    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
    }
    public  static App getInstance()
    {
        return mInstance;
    }

}
