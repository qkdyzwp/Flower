package com.fir.open.sorce.activity;

import android.app.ProgressDialog;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.fir.open.sorce.FlowerApplication;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.BaseActivity;
import com.fir.open.sorce.entity.Banner;
import com.fir.open.sorce.entity.Buyer;
import com.fir.open.sorce.http.BaseCallBack;
import com.fir.open.sorce.http.HttpUtils;
import com.fir.open.sorce.http.Params;
import com.fir.open.sorce.response.BaseResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.xutils.DbManager;
import org.xutils.x;

import java.lang.reflect.Type;
/**
 * Created by modata_fir on 2017/6/2.
 */
public class LoginActivity extends BaseActivity {
    private EditText login_username_et;

    private EditText login_password_et;

    private TextView login_mobile;

    private ProgressDialog mProgressDialog;
    @Override
    public int getLyout() {
        return R.layout.activity_login;
    }

    @Override
    public void init() {
        login_mobile = (TextView) findViewById(R.id.login_mobile);
        login_username_et = (EditText) findViewById(R.id.login_username_et);
        login_password_et = (EditText) findViewById(R.id.login_password_et);
        login_mobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = login_username_et.getText().toString();
                String password = login_password_et.getText().toString();
                if (userName.length() != 11) {
                    Toast.makeText(LoginActivity.this, "请输入正确的电话号码", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    Toast.makeText(LoginActivity.this, "密码不小于6位", Toast.LENGTH_SHORT).show();
                } else {
                    mProgressDialog = new ProgressDialog(LoginActivity.this);
                    mProgressDialog.show();
                    login();
                }
            }
        });
    }
    public void login(){
        HttpUtils http = new HttpUtils();
        Params params = new Params();
        params.put("phone",login_username_et.getText().toString());
        http.post(FlowerApplication.url + "login", params, new BaseCallBack() {
            @Override
            public void onResponse(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                try {
                    Type objectType = new TypeToken<BaseResponse<Buyer>>() {}.getType();
                    BaseResponse<Buyer> response=new Gson().fromJson(result,objectType);
                    if(response.getData().getCount()<1){
                        Toast.makeText(LoginActivity.this, "账号不存在", Toast.LENGTH_SHORT).show();
                    }else if(!response.getData().getList().get(0).getPassword().equals(login_password_et.getText().toString())){
                        Toast.makeText(LoginActivity.this, "密码不正确", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(LoginActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        DbManager db = x.getDb(FlowerApplication.getDaoConfig());
                        db.save(response.getData().getList().get(0));
                        finish();
                    }
                }catch (Exception ex){
                    Toast.makeText(LoginActivity.this, "账号或密码不正确", Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
            @Override
            public void onFail(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                Toast.makeText(LoginActivity.this, result, Toast.LENGTH_SHORT).show();
                Log.e("onFail", result);
            }
        });
    }
}
