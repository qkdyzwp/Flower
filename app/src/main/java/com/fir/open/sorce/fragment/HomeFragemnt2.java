package com.fir.open.sorce.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.fir.open.sorce.R;
import com.fir.open.sorce.adapter.PullBaseAdapter;
import com.fir.open.sorce.fragment.base.ScrPullBaseFragment;
import com.fir.open.sorce.inter.ScrPullData;
import com.fir.open.sorce.manager.FullyLinearLayoutManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mododata-android on 2017/5/25.
 */

public class HomeFragemnt2 extends ScrPullBaseFragment {
    private View view;
    private RecyclerView base_pull_list_view;

    @Override
    public View setView() {
        view=inflater.inflate(R.layout.home_fragment_layout,null);
        return view;
    }

    @Override
    public void loadData(ScrPullData pull) {
        List<String> strList=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strList.add("--"+i);
        }
        PullBaseAdapter adapter=new PullBaseAdapter(strList,getActivity());
        base_pull_list_view.setAdapter(adapter);
        base_pull_list_view.setLayoutManager(new FullyLinearLayoutManager(getActivity()));

        pull.getObject();
    }

    @Override
    public void inidData() {
        base_pull_list_view= (RecyclerView) view.findViewById(R.id.base_pull_list_view);
        List<String> strList=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strList.add("--"+i);
        }
        PullBaseAdapter adapter=new PullBaseAdapter(strList,getActivity());
        base_pull_list_view.setAdapter(adapter);
        setHeadView(inflater.inflate(R.layout.head_layout_for_search,null));
        setEmptyImg(R.mipmap.ic_launcher);
        setEmptyText("该测试数据为空");

    }
}
