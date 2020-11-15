package com.coolweather.coolweather;

import android.app.Application;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DaoManager daoManager = DaoManager.getInstance(this);
        daoManager.getDaoMaster();
    }
}
