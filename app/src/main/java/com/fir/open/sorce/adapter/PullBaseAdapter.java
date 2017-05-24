package com.fir.open.sorce.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fir.open.sorce.R;

import java.util.List;

/**
 * Created by mododata-android on 2017/5/24.
 */

public class PullBaseAdapter extends RecyclerView.Adapter<PullBaseAdapter.ViewHolder>{
    private List<String> strList;

    private LayoutInflater inflater;
    public PullBaseAdapter(List<String> strList, Context context){
        this.strList=strList;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.pull_item_test, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.testView.setText(strList.get(position));
    }

    @Override
    public int getItemCount() {
        return strList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView testView;
        public ViewHolder(View itemView) {
            super(itemView);
            testView= (TextView) itemView.findViewById(R.id.test);
        }
    }
}
