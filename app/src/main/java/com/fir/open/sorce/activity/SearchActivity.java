package com.fir.open.sorce.activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;

import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.PullBaseActivity;
import com.fir.open.sorce.adapter.HomeAdapter;
import com.fir.open.sorce.inter.PullData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by modata_fir on 2017/5/31.
 */

public class SearchActivity extends PullBaseActivity<String> {
    private LinearLayoutManager manager;
    private String searchStr;
    private EditText search_et;
    @Override
    public RecyclerView.LayoutManager getManager() {
        manager=new GridLayoutManager(SearchActivity.this,2);
        return manager;
    }

    @Override
    public RecyclerView.Adapter getAdapter() {
        HomeAdapter adapter=new HomeAdapter(objectList,SearchActivity.this);
        return adapter;
    }

    @Override
    public void loadData(int page, PullData pull) {
        List<String> strList=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strList.add(page+"--"+i);
        }
        pull.getObject(strList);
    }

    @Override
    public void initData() {
        searchStr=getIntent().getStringExtra("searchStr");
        View headViewForMain=inflater.inflate(R.layout.layout_search_head,null);
        search_et= (EditText) headViewForMain.findViewById(R.id.search_et);
        search_et.setText(searchStr);
        setHeadView(headViewForMain,0);
        setEmptyImg(R.mipmap.ic_launcher);
        setEmptyText("该测试数据为空");
    }
}
