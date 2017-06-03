package com.fir.open.sorce.activity;

import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fir.open.sorce.FlowerApplication;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.BaseActivity;
import com.fir.open.sorce.entity.Buyer;
import com.fir.open.sorce.http.BaseCallBack;
import com.fir.open.sorce.http.HttpUtils;
import com.fir.open.sorce.http.Params;
import com.fir.open.sorce.manager.Action;
import com.fir.open.sorce.response.BaseResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.DbManager;
import org.xutils.x;

import java.lang.reflect.Type;

import de.greenrobot.event.EventBus;

/**
 * Created by fir on 17/6/3.
 */

public class AddLinkmanActivity extends BaseActivity {
    private TextView title;

    private ImageView back;

    private TextView add_linkman_save;

    private EditText add_linman_name;

    private TextView add_linman_birthday;

    private String type;//0的时候表示的添加1的时候表示的是修改

    private ProgressDialog mProgressDialog;

    private String linkmanId;

    @Override
    public int getLyout() {
        return R.layout.activity_add_linkman;
    }

    @Override
    public void init() {
        add_linman_birthday = (TextView) findViewById(R.id.add_linman_birthday);
        add_linman_name = (EditText) findViewById(R.id.add_linman_name);
        type = getIntent().getStringExtra("type");
        title = (TextView) findViewById(R.id.title);
        back = (ImageView) findViewById(R.id.back);
        add_linkman_save = (TextView) findViewById(R.id.add_linkman_save);
        back.setVisibility(View.VISIBLE);
        if (type.equals("0")) {
            title.setText("添加联系人");
        } else {
            title.setText("修改联系人");
            linkmanId=getIntent().getStringExtra("linkmanId");
            add_linman_name.setText(getIntent().getStringExtra("name"));
            add_linman_birthday.setText(getIntent().getStringExtra("birthday"));
        }
        add_linkman_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isNull()) {
                    mProgressDialog = new ProgressDialog(AddLinkmanActivity.this);
                    mProgressDialog.show();
                    if (type.equals("0")) {
                        saveLinkman();
                    } else {
                        updateLinkman();
                    }
                }
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    public void saveLinkman() {
        HttpUtils http = new HttpUtils();
        Params params = new Params();
        params.put("buyer.buyerId", FlowerApplication.getUserInfo().getBuyerId());
        params.put("name", add_linman_name.getText().toString());
        params.put("birthday", add_linman_birthday.getText().toString());
        http.post(FlowerApplication.url + "addLinkman", params, new BaseCallBack() {
            @Override
            public void onResponse(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                try {
                    BaseResponse response = new Gson().fromJson(result, BaseResponse.class);
                    if(response.isSuccess()){
                        Action action = new Action();
                        action.setAction("save_linkman");
                        //此处可以直接把字符串解析成实体类传过去，用法随意
                        EventBus.getDefault().post(action);
                        finish();
                        Toast.makeText(AddLinkmanActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(AddLinkmanActivity.this, response.getResMsg(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(AddLinkmanActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
            @Override
            public void onFail(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                Toast.makeText(AddLinkmanActivity.this, result, Toast.LENGTH_SHORT).show();
                Log.e("onFail", result);
            }
        });

    }

    public void updateLinkman() {
        HttpUtils http = new HttpUtils();
        Params params = new Params();
        params.put("linkmanId", linkmanId);
        params.put("buyer.buyerId", FlowerApplication.getUserInfo().getBuyerId());
        params.put("name", add_linman_name.getText().toString());
        params.put("birthday", add_linman_birthday.getText().toString());
        http.post(FlowerApplication.url + "updateLinkman", params, new BaseCallBack() {
            @Override
            public void onResponse(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                try {
                    BaseResponse response = new Gson().fromJson(result, BaseResponse.class);
                    if(response.isSuccess()){
                        finish();
                        Action action = new Action();
                        action.setAction("update_linkman");
                        action.setLocation(getIntent().getStringExtra("location"));
                        action.setMessage(add_linman_name.getText().toString()+","+add_linman_birthday.getText().toString());
                        //此处可以直接把字符串解析成实体类传过去，用法随意
                        EventBus.getDefault().post(action);
                        Toast.makeText(AddLinkmanActivity.this, "保存成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(AddLinkmanActivity.this, response.getResMsg(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(AddLinkmanActivity.this, "保存失败", Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
            @Override
            public void onFail(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                Toast.makeText(AddLinkmanActivity.this, result, Toast.LENGTH_SHORT).show();
                Log.e("onFail", result);
            }
        });
    }

    public void deleteLinkman() {

    }

    public boolean isNull() {
        if (add_linman_birthday.getText().toString().equals("")) {
            Toast.makeText(this, "请填写生日", Toast.LENGTH_SHORT).show();
            return false;
        } else if (add_linman_name.getText().toString().equals("")) {
            Toast.makeText(this, "请填写姓名", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
}
