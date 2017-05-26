package com.fir.open.sorce.activity.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.fir.open.sorce.R;
/**
 * activity
 */
public abstract class BaseActivity extends AppCompatActivity {
    public String TAG=this.getClass().getCanonicalName();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(getLyout());
        init();
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
    protected void onDestroy() {
        super.onDestroy();
    }
}
