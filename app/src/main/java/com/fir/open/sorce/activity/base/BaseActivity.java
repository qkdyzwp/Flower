package com.fir.open.sorce.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.fir.open.sorce.R;
import com.fir.open.sorce.manager.Action;

import de.greenrobot.event.EventBus;

/**
 * activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    public String TAG=this.getClass().getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EventBus.getDefault().register(this);
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(getLyout());
        init();
    }
    public void onEventMainThread(final Action msg) {
        actionHandle(msg);
//        if (msg.getAction().equals("login_out")) {
//            alphaTabsIndicator.setTabCurrenItem(0);
//        }
    }

    public void actionHandle(Action msg){

    }
    /**
     * 获取布局文件
     * @return
     */
    public abstract int getLyout();
    /**
     * 初始化
     */
    public abstract void init();

    @Override
    protected void onResume() {
        super.onResume();
    }
    @Override
    protected void onDestroy()
    {
        EventBus.getDefault().unregister(this);//反注册EventBus
        super.onDestroy();
    }
}
