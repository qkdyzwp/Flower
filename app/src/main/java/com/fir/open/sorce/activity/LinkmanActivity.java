package com.fir.open.sorce.activity;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.fir.open.sorce.FlowerApplication;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.PullBaseActivity;
import com.fir.open.sorce.adapter.LinkmanAdapter;
import com.fir.open.sorce.entity.Banner;
import com.fir.open.sorce.entity.Linkman;
import com.fir.open.sorce.http.BaseCallBack;
import com.fir.open.sorce.http.HttpUtils;
import com.fir.open.sorce.http.Params;
import com.fir.open.sorce.inter.PullData;
import com.fir.open.sorce.response.BaseResponse;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;

/**
 * Created by modata_fir on 2017/6/3.
 */

public class LinkmanActivity extends PullBaseActivity<Linkman> {
    @Override
    public RecyclerView.LayoutManager getManager() {
        return new LinearLayoutManager(this);
    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        LinkmanAdapter adapter=new LinkmanAdapter(objectList,this);
        return adapter;
    }
    @Override
    public void loadData(final int page, final PullData pull) {
        HttpUtils http = new HttpUtils();
        Params params = new Params();
        params.put("buyer.buyerId",FlowerApplication.getUserInfo().getBuyerId());
        http.post(FlowerApplication.url + "queryLinkman", params, new BaseCallBack() {
            @Override
            public void onResponse(String result) {
                Type objectType = new TypeToken<BaseResponse<Linkman>>() {}.getType();
                BaseResponse<Linkman> response=new Gson().fromJson(result,objectType);
                if(response.isSuccess()){
                    pull.getObject(response.getData().getList());
                }else{
                    Toast.makeText(LinkmanActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
                }
            }
            @Override
            public void onFail(String result) {
                Log.e("onFail", result);
                Toast.makeText(LinkmanActivity.this, "加载失败", Toast.LENGTH_SHORT).show();
            }
    });}
    @Override
    public void initData() {
        View headViewForMain = inflater.inflate(R.layout.head_layout_for_search, null);
        setHeadView(headViewForMain, 0);
        setEmptyImg(R.mipmap.ic_launcher);
        setEmptyText("该测试数据为空");
    }
}
