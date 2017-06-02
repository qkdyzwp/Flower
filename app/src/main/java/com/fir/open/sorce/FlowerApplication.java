package com.fir.open.sorce;

import android.app.Application;
import android.widget.BaseAdapter;

import org.xutils.x;

/**
 * Created by mododata-android on 2017/5/24.
 */

public class FlowerApplication extends Application{
    public static String url="http://47.93.207.65:8080/fshop/ajax/dao/";

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(BuildConfig.DEBUG); // 是否输出debug日志, 开启debug会影响性能.
    }
    public static boolean isLogin(){
        return false;
    }
}
