package com.coolweather.coolweather;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoMaster;
import com.aserbao.aserbaosandroid.functions.database.greenDao.db.DaoSession;

public class MainActivity extends AppCompatActivity {

    private static DaoSession mDaoSession;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // GreenDao
        initGreenDao();
    }

    private void initGreenDao() {
        // 创建数据库cool_weather
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(this, "cool_weather");
        SQLiteDatabase database = helper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(database);
        mDaoSession = daoMaster.newSession();
    }

    public static DaoSession getDaoSession() {
        return mDaoSession;
    }
}