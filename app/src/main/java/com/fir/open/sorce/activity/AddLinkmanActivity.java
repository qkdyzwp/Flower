package com.fir.open.sorce.activity;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bigkoo.pickerview.TimePickerView;
import com.bigkoo.pickerview.listener.CustomListener;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

    private TextView handle;

    private TimePickerView pvCustomTime;

    @Override
    public int getLyout() {
        return R.layout.activity_add_linkman;
    }

    @Override
    public void init() {
        handle=(TextView)findViewById(R.id.handle);
        add_linman_birthday = (TextView) findViewById(R.id.add_linman_birthday);
        add_linman_name = (EditText) findViewById(R.id.add_linman_name);
        type = getIntent().getStringExtra("type");
        title = (TextView) findViewById(R.id.title);
        back = (ImageView) findViewById(R.id.back);
        add_linkman_save = (TextView) findViewById(R.id.add_linkman_save);
        back.setVisibility(View.VISIBLE);
        initCustomTimePicker();
        if (type.equals("0")) {
            title.setText("添加联系人");
        } else {
            handle.setVisibility(View.VISIBLE);
            handle.setText("删除");
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
        handle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mProgressDialog = new ProgressDialog(AddLinkmanActivity.this);
                mProgressDialog.show();
                deleteLinkman();
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        add_linman_birthday.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pvCustomTime.show();
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
        HttpUtils http = new HttpUtils();
        Params params = new Params();
        params.put("linkmanId", linkmanId);
        http.post(FlowerApplication.url + "deleteLinkman", params, new BaseCallBack() {
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
                        action.setAction("delete_linkman");
                        action.setLocation(getIntent().getStringExtra("location"));
                        action.setMessage(add_linman_name.getText().toString()+","+add_linman_birthday.getText().toString());
                        //此处可以直接把字符串解析成实体类传过去，用法随意
                        EventBus.getDefault().post(action);
                        Toast.makeText(AddLinkmanActivity.this, "删除成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(AddLinkmanActivity.this, response.getResMsg(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(AddLinkmanActivity.this, "删除失败", Toast.LENGTH_SHORT).show();
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
    private void initCustomTimePicker() {
        /**
         * @description
         *
         * 注意事项：
         * 1.自定义布局中，id为 optionspicker 或者 timepicker 的布局以及其子控件必须要有，否则会报空指针.
         * 具体可参考demo 里面的两个自定义layout布局。
         * 2.因为系统Calendar的月份是从0-11的,所以如果是调用Calendar的set方法来设置时间,月份的范围也要是从0-11
         * setRangDate方法控制起始终止时间(如果不设置范围，则使用默认时间1900-2100年，此段代码可注释)
         */
        Calendar selectedDate = Calendar.getInstance();//系统当前时间
        Calendar startDate = Calendar.getInstance();
        startDate.set(2014, 1, 23);
        Calendar endDate = Calendar.getInstance();
        endDate.set(2027, 2, 28);
        //时间选择器 ，自定义布局
        pvCustomTime = new TimePickerView.Builder(this, new TimePickerView.OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {//选中事件回调
                add_linman_birthday.setText(getTime(date));
            }
        })
                /*.setType(TimePickerView.Type.ALL)//default is all
                .setCancelText("Cancel")
                .setSubmitText("Sure")
                .setContentSize(18)
                .setTitleSize(20)
                .setTitleText("Title")
                .setTitleColor(Color.BLACK)
               /*.setDividerColor(Color.WHITE)//设置分割线的颜色
                .setTextColorCenter(Color.LTGRAY)//设置选中项的颜色
                .setLineSpacingMultiplier(1.6f)//设置两横线之间的间隔倍数
                .setTitleBgColor(Color.DKGRAY)//标题背景颜色 Night mode
                .setBgColor(Color.BLACK)//滚轮背景颜色 Night mode
                .setSubmitColor(Color.WHITE)
                .setCancelColor(Color.WHITE)*/
               /*.gravity(Gravity.RIGHT)// default is center*/
                .setDate(selectedDate)
                .setRangDate(startDate, endDate)
                .setLayoutRes(R.layout.pickerview_custom_time, new CustomListener() {

                    @Override
                    public void customLayout(View v) {
                        final TextView tvSubmit = (TextView) v.findViewById(R.id.tv_finish);
                        ImageView ivCancel = (ImageView) v.findViewById(R.id.iv_cancel);
                        tvSubmit.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.returnData();
                                pvCustomTime.dismiss();
                            }
                        });
                        ivCancel.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                pvCustomTime.dismiss();
                            }
                        });
                    }
                })
                .setType(new boolean[]{true, true, true, false, false, false})
                .isCenterLabel(false) //是否只显示中间选中项的label文字，false则每项item全部都带有label。
                .setDividerColor(Color.RED)
                .build();

    }
    private String getTime(Date date) {//可根据需要自行截取数据显示
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return format.format(date);
    }
}
