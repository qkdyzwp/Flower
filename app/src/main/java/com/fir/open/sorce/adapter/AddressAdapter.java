package com.fir.open.sorce.adapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fir.open.sorce.FlowerApplication;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.AddAddressActivity;
import com.fir.open.sorce.activity.AddLinkmanActivity;
import com.fir.open.sorce.entity.Delivery;
import com.fir.open.sorce.entity.Linkman;
import com.fir.open.sorce.http.BaseCallBack;
import com.fir.open.sorce.http.HttpUtils;
import com.fir.open.sorce.http.Params;
import com.fir.open.sorce.manager.Action;
import com.fir.open.sorce.response.BaseResponse;
import com.google.gson.Gson;

import java.util.List;

import de.greenrobot.event.EventBus;

/**
 * Created by mododata-android on 2017/5/24.
 */

public class AddressAdapter extends RecyclerView.Adapter<AddressAdapter.ViewHolder>{
    private List<Delivery> strList;
    private LayoutInflater inflater;
    private Activity context;
    public AddressAdapter(List<Delivery> strList, Activity context){
        this.strList=strList;
        this.inflater=LayoutInflater.from(context);
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.address_item, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.address_item_name.setText(strList.get(position).getReceiver());
        holder.address_item_phone.setText(strList.get(position).getPhone());
        holder.address_item_dddress.setText(strList.get(position).getAddress().replace("-",""));
        if(strList.get(position).getIsDefault()!=null&&strList.get(position).getIsDefault().equals("yes")){
            holder.cb_is_defualt.setChecked(true);
            holder.cb_is_defualt.setTextColor(Color.RED);
            holder.cb_is_defualt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "不可取消默认地址", Toast.LENGTH_SHORT).show();
                }
            });
        }else{
            holder.cb_is_defualt.setChecked(false);
            holder.cb_is_defualt.setTextColor(Color.GRAY);
            holder.cb_is_defualt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mProgressDialog = new ProgressDialog(context);
                    mProgressDialog.show();
                    updateAddress(strList.get(position).getDeliveryAddressId());
                }
            });
        }
        holder.address_item_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(context,AddAddressActivity.class);
                intent.putExtra("type","1");
                intent.putExtra("addressId",strList.get(position).getDeliveryAddressId());
                intent.putExtra("name",strList.get(position).getReceiver());
                intent.putExtra("address",strList.get(position).getAddress());
                intent.putExtra("phone",strList.get(position).getPhone());
                intent.putExtra("location",""+position);
                intent.putExtra("isDefault",""+strList.get(position).getIsDefault());
                context.startActivity(intent);
            }
        });
        //取消不了默认
    }
    @Override
    public int getItemCount() {
        return strList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView address_item_name;
        TextView address_item_phone;
        TextView address_item_dddress;
        CheckBox cb_is_defualt;
        TextView address_item_edit;
        public ViewHolder(View itemView){
            super(itemView);
            address_item_name= (TextView) itemView.findViewById(R.id.address_item_name);
            address_item_phone= (TextView) itemView.findViewById(R.id.address_item_phone);
            address_item_dddress= (TextView) itemView.findViewById(R.id.address_item_dddress);
            address_item_edit= (TextView) itemView.findViewById(R.id.address_item_edit);
            cb_is_defualt= (CheckBox) itemView.findViewById(R.id.cb_is_defualt);
        }
    }
    private ProgressDialog mProgressDialog;
    public void updateAddress(String id) {
        HttpUtils http = new HttpUtils();
        Params params = new Params();
        params.put("deliveryAddressId",id);
        params.put("isDefault","yes");
        http.post(FlowerApplication.url + "updateAddress", params, new BaseCallBack() {
            @Override
            public void onResponse(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                try {
                    BaseResponse response = new Gson().fromJson(result, BaseResponse.class);
                    if(response.isSuccess()){

                        Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();
                    }else{
                        Toast.makeText(context, response.getResMsg(), Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(context, "保存失败", Toast.LENGTH_SHORT).show();
                    ex.printStackTrace();
                }
            }
            @Override
            public void onFail(String result) {
                if (mProgressDialog != null) {
                    mProgressDialog.dismiss();
                }
                Toast.makeText(context, result, Toast.LENGTH_SHORT).show();
                Log.e("onFail", result);
            }
        });
    }
}
