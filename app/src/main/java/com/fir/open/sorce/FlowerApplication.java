package com.fir.open.sorce;

import android.app.Application;
import android.widget.BaseAdapter;

import com.fir.open.sorce.entity.Buyer;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mododata-android on 2017/5/24.
 */

public class FlowerApplication extends Application {
    public static String url = "http://47.93.207.65:8080/fshop/ajax/dao/";

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
    public static boolean isLogin() {
        DbManager db = x.getDb(getDaoConfig());
        List<Buyer> list = new ArrayList<Buyer>();
        try {
            list = db.findAll(Buyer.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        if (list != null && list.size() > 0) {
            return true;
        } else {
            return false;
        }
    }
    public static Buyer getUserInfo() {
        DbManager db = x.getDb(getDaoConfig());
        List<Buyer> list = new ArrayList<Buyer>();
        try {
            list = db.findAll(Buyer.class);
        } catch (DbException e) {
            e.printStackTrace();
        }
        return list.get(0);
    }

    /**
     * 更新用户信息
     *
     * @param userInfo
     */
    public static void updateInfo(Buyer userInfo) {
        DbManager db = x.getDb(getDaoConfig());
        try {
            db.update(userInfo);
        } catch (DbException e) {
            e.printStackTrace();
        }
    }

    public static DbManager.DaoConfig getDaoConfig() {
        DbManager.DaoConfig daoConfig = new DbManager.DaoConfig()
                .setDbName("mdy_db")//创建数据库的名称
                .setDbVersion(1)//数据库版本号
                .setDbOpenListener(new DbManager.DbOpenListener() {
                    @Override
                    public void onDbOpened(DbManager db) {
                        // 开启WAL, 对写入加速提升巨大
                        db.getDatabase().enableWriteAheadLogging();
                    }
                }).setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        // TODO: ...
                        // db.addColumn(...);
                        // db.dropTable(...);
                        // ...
                    }
                });//数据库更新操作
return daoConfig;
    }
}
