package com.fir.open.sorce.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.fir.open.sorce.R;
import com.fir.open.sorce.util.ImageUtil;

import java.util.List;

/**
 * Created by mododata-android on 2017/5/24.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder>{
    private List<String> strList;

    private LayoutInflater inflater;

    private Context context;
    public HomeAdapter(List<String> strList, Context context){
        this.strList=strList;
        this.inflater=LayoutInflater.from(context);
        this.context=context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.fragment_product_item, parent,
                false));
        return holder;
    }
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        String url="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496798186&di=bd7530213ac78cf370ba8432570d3b72&imgtype=jpg&er=1&src=http%3A%2F%2Ftupian.enterdesk.com%2F2015%2Fxu%2F04%2F07%2F1%2F8.jpg";
        ImageUtil.initImg(context,url,holder.img);
    }
    @Override
    public int getItemCount() {
        return strList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.main_pager_product_icon);
        }
    }
}
