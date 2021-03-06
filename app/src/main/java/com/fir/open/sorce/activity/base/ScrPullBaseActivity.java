package com.fir.open.sorce.activity.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.fir.open.sorce.R;
import com.fir.open.sorce.inter.ScrPullData;
/**
 * Created by mododata-android on 2017/5/26.
 */
public abstract class ScrPullBaseActivity extends BaseActivity {
    private SwipeRefreshLayout baseSwipeLayout;

    private ScrollView basePullListView;

    private ScrollView emptyView;

    private LinearLayout headView;

    private ImageView emptyImg;

    private TextView isHaveCoupon;

    private LinearLayout scrLinearLayout;

    public LayoutInflater inflater;

    private LinearLayout bomView;
    @Override
    public int getLyout() {
        return R.layout.activity_scr_pull_base;
    }
    @Override
    public void init() {
        bomView= (LinearLayout) findViewById(R.id.bomView);
        inflater=LayoutInflater.from(ScrPullBaseActivity.this);
        scrLinearLayout= (LinearLayout) findViewById(R.id.scrLinearLayout);
        basePullListView= (ScrollView) findViewById(R.id.scrView);
        emptyImg= (ImageView) findViewById(R.id.emptyImg);
        isHaveCoupon= (TextView) findViewById(R.id.isHaveCoupon);
        headView= (LinearLayout) findViewById(R.id.headView);
        emptyView= (ScrollView) findViewById(R.id.emptyView);
        baseSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.base_swipe_layout);
        baseSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        baseSwipeLayout.setEnabled(true);
        baseSwipeLayout.setOnRefreshListener(mOnRefreshListener);
        scrLinearLayout.addView(setView());
        inidData();
        getData();
    }
    public void setBodyView(View view){
        scrLinearLayout.removeAllViews();
        scrLinearLayout.addView(setView());
    }
    /**
     * 设置数据显示区域的view
     */
    public abstract View setView();
    /**
     * 设置头布局
     * @param view
     */
    public void setHeadView(View view){
        headView.addView(view);
    }
    /**
     * 设置底部布局
     * @param view
     */
    public void setBomView(View view){
        bomView.addView(view);
    }
    /**
     * 设置数据空的时候布局用的文字
     */
    public void setEmptyText(String text){
        isHaveCoupon.setText(text);
    }
    public void setEmptyImg(int drawable){
        emptyImg.setBackgroundResource(drawable);
    }
    /**
     * 加载数据
     *
     * @return
     */
    public abstract void loadData(ScrPullData pull);
    /**
     * 下拉刷新监听
     */
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            getData();
        }
    };
    /**
     * 加载数据业务处理
     * @param
     */
    public void getData() {
        loadData(new ScrPullData() {
            @Override
            public void getObject() {
                baseSwipeLayout.setRefreshing(false);
                setData();
            }
            @Override
            public void error() {
                baseSwipeLayout.setRefreshing(false);
                setEmpty();
            }
        });
    }
    /**
     * 设置数据为空
     */
    public void setEmpty(){
        emptyView.setVisibility(View.VISIBLE);
        basePullListView.setVisibility(View.GONE);
    }
    /**
     * 设置有数据
     */
    public void setData(){
        emptyView.setVisibility(View.GONE);
        basePullListView.setVisibility(View.VISIBLE);
    }
    public abstract void inidData();
}
