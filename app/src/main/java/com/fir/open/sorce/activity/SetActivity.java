package com.fir.open.sorce.activity;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fir.open.sorce.FlowerApplication;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.BaseActivity;
import com.fir.open.sorce.entity.Buyer;
import com.fir.open.sorce.manager.Action;
import com.fir.open.sorce.manager.DataCleanManager;

import org.xutils.DbManager;
import org.xutils.ex.DbException;
import org.xutils.x;

import de.greenrobot.event.EventBus;

/**
 * Created by modata_fir on 2017/6/3.
 */
public class SetActivity extends BaseActivity {
    private ImageView back;
    private TextView title;
    private TextView dataTv;
    private RelativeLayout my_integral_shop;
    private RelativeLayout loginout;
    @Override
    public int getLyout() {
        return R.layout.activity_set;
    }
    @Override
    public void init() {
        loginout= (RelativeLayout) findViewById(R.id.loginout);
        back= (ImageView) findViewById(R.id.back);
        back.setVisibility(View.VISIBLE);
        title= (TextView) findViewById(R.id.title);
        dataTv= (TextView) findViewById(R.id.dataTv);
        my_integral_shop= (RelativeLayout) findViewById(R.id.my_integral_shop);
        title.setText("设置");
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        my_integral_shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    DataCleanManager.clearAllCache(SetActivity.this);
                    dataTv.setText(DataCleanManager.getTotalCacheSize(SetActivity.this));
                } catch (Exception e) {
                    e.printStackTrace();
                    dataTv.setText("0.00MB");
                }
            }
        });
        loginout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DbManager db = x.getDb(FlowerApplication.getDaoConfig());
                try {
                    db.delete(Buyer.class);
                } catch (DbException e) {
                    e.printStackTrace();
                }
                Action action = new Action();
                action.setAction("login_out");
                //此处可以直接把字符串解析成实体类传过去，用法随意
                EventBus.getDefault().post(action);
                finish();
            }
        });
        try {
            dataTv.setText(DataCleanManager.getTotalCacheSize(SetActivity.this));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
