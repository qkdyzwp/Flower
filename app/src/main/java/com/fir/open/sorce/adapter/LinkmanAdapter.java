package com.fir.open.sorce.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fir.open.sorce.R;
import com.fir.open.sorce.entity.Linkman;
import com.fir.open.sorce.util.ImageUtil;

import java.util.List;

/**
 * Created by mododata-android on 2017/5/24.
 */

public class LinkmanAdapter extends RecyclerView.Adapter<LinkmanAdapter.ViewHolder>{
    private List<Linkman> strList;
    private LayoutInflater inflater;
    private Context context;
    public LinkmanAdapter(List<Linkman> strList, Context context){
        this.strList=strList;
        this.inflater=LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.linkman_item, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.linkman_item_name.setText(strList.get(position).getName());
    }
    @Override
    public int getItemCount() {
        return strList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView linkman_item_name;
        public ViewHolder(View itemView) {
            super(itemView);
            linkman_item_name= (TextView) itemView.findViewById(R.id.linkman_item_name);
        }
    }
}
