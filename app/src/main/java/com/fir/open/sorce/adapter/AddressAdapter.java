package com.fir.open.sorce.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.AddLinkmanActivity;
import com.fir.open.sorce.entity.Delivery;
import com.fir.open.sorce.entity.Linkman;

import java.util.List;

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
//        holder.linkman_item_name.setText(strList.get(position).getName());
//        holder.linkman_item_birthday.setText(strList.get(position).getBirthday());
//        holder.linkman_item_edit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent(context,AddLinkmanActivity.class);
//                intent.putExtra("type","1");
//                intent.putExtra("linkmanId",strList.get(position).getLinkmanId());
//                intent.putExtra("name",strList.get(position).getName());
//                intent.putExtra("birthday",strList.get(position).getBirthday());
//                intent.putExtra("location",""+position);
//                context.startActivity(intent);
//            }
//        });
    }
    @Override
    public int getItemCount() {
        return strList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
//        TextView linkman_item_name;
//        TextView linkman_item_birthday;
//        ImageView linkman_item_edit;

        public ViewHolder(View itemView){
            super(itemView);
//            linkman_item_name= (TextView) itemView.findViewById(R.id.linkman_item_name);
//            linkman_item_birthday= (TextView) itemView.findViewById(R.id.linkman_item_birthday);
//            linkman_item_edit= (ImageView) itemView.findViewById(R.id.linkman_item_edit);
        }
    }
}
