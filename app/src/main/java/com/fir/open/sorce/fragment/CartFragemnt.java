package com.fir.open.sorce.fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.fir.open.sorce.R;
import com.fir.open.sorce.adapter.CartAdapter;
import com.fir.open.sorce.fragment.base.PullBaseFragment;
import com.fir.open.sorce.inter.PullData;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by mododata-android on 2017/5/25.
 */
public class CartFragemnt extends PullBaseFragment<String> {
    @Override
    public RecyclerView.LayoutManager getManager() {
        LinearLayoutManager manager=new LinearLayoutManager(getActivity());
        return manager;
    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        CartAdapter cart=new CartAdapter(objectList,getActivity());
        return cart;
    }
    @Override
    public void loadData(int page, PullData<String> pull) {
        List<String> strList=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strList.add(page+"--"+i);
        }
        pull.getObject(strList);
    }
    @Override
    public int setHeadForListView() {
        return 0;
    }
    @Override
    public void initData() {
        View headViewForMain=inflater.inflate(R.layout.layout_cart_head,null);
        setHeadView(headViewForMain,0);
        setEmptyImg(R.mipmap.ic_launcher);
        setEmptyText("该测试数据为空");
    }
}
