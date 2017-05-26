package com.fir.open.sorce.activity;

import android.support.v7.widget.RecyclerView;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.PullBaseActivity;
import com.fir.open.sorce.adapter.PullBaseAdapter;
import com.fir.open.sorce.inter.PullData;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by mododata-android on 2017/5/24.
 */
public class TestActivityForPull extends PullBaseActivity<String> {
    @Override
    public RecyclerView.Adapter getAdapter() {
        PullBaseAdapter adapter=new PullBaseAdapter(objectList,TestActivityForPull.this);
        return adapter;
    }
    @Override
    public void loadData(int page, PullData<String> pull) {
        List<String> strList=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strList.add(page+"--"+i);
        }
        //数据请求成功调用 pull.getObject(strList);
        pull.getObject(strList);
        //数据请求失败调用  pull.error();
    }

    @Override
    public void initData() {
        setHeadView(inflater.inflate(R.layout.head_layout,null));
        setEmptyImg(R.mipmap.ic_launcher);
        setEmptyText("该测试数据为空");
    }
}
