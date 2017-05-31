package com.fir.open.sorce.fragment;


import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.holder.CBViewHolderCreator;
import com.bigkoo.convenientbanner.listener.OnItemClickListener;
import com.fir.open.sorce.R;
import com.fir.open.sorce.adapter.HomeAdapter;
import com.fir.open.sorce.fragment.base.PullBaseFragment;
import com.fir.open.sorce.http.HttpLoadEnum;
import com.fir.open.sorce.inter.PullData;
import com.fir.open.sorce.util.DensityUtil;
import com.fir.open.sorce.view.LocalImageHolderView;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by mododata-android on 2017/5/25.
 */
public class HomeFragemnt extends PullBaseFragment {
    private HomeAdapter adapter;
    private ConvenientBanner homeFragmentSlider;//广告位
    private View headViewForList;
    private LinearLayoutManager manager;
    @Override
    public RecyclerView.LayoutManager getManager() {
        manager=new GridLayoutManager(getActivity(),2);
        return manager;
    }
    @Override
    public RecyclerView.Adapter getAdapter() {
        adapter=new HomeAdapter(objectList,getActivity());
        return adapter;
    }
    @Override
    public void loadData(int page, PullData pull) {
        List<String> strList=new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            strList.add(page+"--"+i);
        }
        List<String> imgs=new ArrayList<>();
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496206757045&di=f279417bb31dac14cb3a1aad48b70f46&imgtype=0&src=http%3A%2F%2Fpic.qiantucdn.com%2F58pic%2F18%2F28%2F61%2F91h58PICY5E_1024.jpg");
        imgs.add("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1496206780444&di=5d7b9bbd54c58965af2f95d03db25a3d&imgtype=0&src=http%3A%2F%2Fsem.g3img.com%2Fsite%2F34051500%2Fc2_20161009110909_45436.jpg");
        homeFragmentSlider.setPages(
                new CBViewHolderCreator<LocalImageHolderView>() {
                    @Override
                    public LocalImageHolderView createHolder() {
                        return new LocalImageHolderView();
                    }
                }, imgs)
                //设置两个点图片作为翻页指示器，不设置则没有指示器，可以根据自己需求自行配合自己的指示器,不需要圆点指示器可用不设
                .setPageIndicator(new int[]{R.drawable.gray_bg_shape, R.drawable.red_bg_shape})
                .setOnItemClickListener(new OnItemClickListener() {
                    @Override
                    public void onItemClick(int position) {
                        Toast.makeText(getActivity(), "你点击了农技广告", Toast.LENGTH_SHORT).show();
                    }
                });
        homeFragmentSlider.startTurning(3000);
        pull.getObject(strList);
    }
    @Override
    public int setHeadForListView() {
        headViewForList=inflater.inflate(R.layout.banner_layout,null);
        header.addView(headViewForList);
        header.attachTo(basePullListView, true);
        return 1;
    }
    @Override
    public void initData() {
        homeFragmentSlider= (ConvenientBanner) headViewForList.findViewById(R.id.home_fragment_slider);
        View headViewForMain=inflater.inflate(R.layout.head_layout_for_search,null);
        setHeadView(headViewForMain,0);
        setEmptyImg(R.mipmap.ic_launcher);
        setEmptyText("该测试数据为空");
    }
    public int getScollYDistance() {
        int position = manager.findFirstVisibleItemPosition();
        View firstVisiableChildView = manager.findViewByPosition(position);
        int itemHeight = firstVisiableChildView.getHeight();
        return (position) * itemHeight - firstVisiableChildView.getTop();
    }
}
