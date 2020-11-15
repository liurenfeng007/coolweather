package com.aserbao.aserbaosandroid.functions.database.greenDao.db;

import android.content.Context;

public class DaoManager {
    private Context mContext;
    // 创建数据库名字
    private static final String DB_NAME = "cool_weather.db";

    // 多线程要被共享的使用volatile关键字修饰，GreenDao管理类
    private volatile static DaoManager mDaoManager;

    // 实际保存数据库对象
    private static DaoMaster mDaoMaster;

    // 创建数据库的工具
    private static DaoMaster.DevOpenHelper mHelper;

    // 管理生成的所有的Dao对象里面带有的增删改查的方法
    private static DaoSession mDaoSession;

    public DaoManager(Context context) {
        this.mContext = context;
    }


    /**
     * 使用单例模式获得操作数据库的对象
     *
     * @return
     */
    public static DaoManager getInstance(Context context) {
        if (mDaoManager == null) {
            synchronized (DaoManager.class) {
                if (mDaoManager == null) {
                    mDaoManager = new DaoManager(context);
                }
            }
        }
        return mDaoManager;
    }

    /**
     * 判断数据库是否存在，如果不存在则创建
     *
     * @return
     */
    public DaoMaster getDaoMaster() {
        if (null == mDaoMaster) {
            mHelper = new DaoMaster.DevOpenHelper(mContext, DB_NAME, null);
            mDaoMaster = new DaoMaster(mHelper.getWritableDb());
        }
        return mDaoMaster;
    }

    /**
     * 获取DaoSession,完成对数据库的添加、删除、修改、查询操作
     *
     * @return
     */
    public synchronized DaoSession getDaoSession() {
        if (null == mDaoSession) {
            mDaoSession = getDaoMaster().newSession();
        }
        return mDaoSession;
    }

    /**
     * 关闭数据库
     */
    public synchronized void closeDataBase() {
        closeHelper();
        closeDaoSession();
    }

    private void closeDaoSession() {
        if (null != mDaoSession) {
            mDaoSession.clear();
            mDaoSession = null;
        }
    }

    private void closeHelper() {
        if (mHelper != null) {
            mHelper.close();
            mHelper = null;
        }
    }


}
