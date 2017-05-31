package com.fir.open.sorce.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.SearchActivity;
import com.fir.open.sorce.util.ImageUtil;

import java.util.List;

/**
 * Created by mododata-android on 2017/5/24.
 */

public class ClassifyMaterialAdapter extends RecyclerView.Adapter<ClassifyMaterialAdapter.ViewHolder>{
    private List<String> strList;

    private LayoutInflater inflater;
    private Context context;
    public ClassifyMaterialAdapter(List<String> strList, Context context){
        this.strList=strList;
        this.inflater=LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(inflater.inflate(R.layout.fragment_main_sort_material_item, parent,
                false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        ImageUtil.initImg(context,R.mipmap.main_sort_material_0,holder.img);
        holder.img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, SearchActivity.class);
                intent.putExtra("searchStr","玫瑰");
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return strList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img= (ImageView) itemView.findViewById(R.id.main_sort_item_iv);
        }
    }
}
