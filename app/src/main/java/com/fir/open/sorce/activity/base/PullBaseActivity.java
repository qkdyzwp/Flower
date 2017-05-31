package com.fir.open.sorce.activity.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.fir.open.sorce.R;
import com.fir.open.sorce.http.HttpLoadEnum;
import com.fir.open.sorce.inter.PullData;
import java.util.ArrayList;
import java.util.List;
/**
 * 下拉刷新基类
 */
public abstract class PullBaseActivity<T> extends BaseActivity {

    private SwipeRefreshLayout baseSwipeLayout;

    private RecyclerView basePullListView;

    public List<T> objectList = new ArrayList<>();

    private int page = 1;

    private boolean isHaveMore = true;

    private RecyclerView.Adapter myAdapter;

    private ScrollView emptyView;

    private LinearLayout headView;

    public LayoutInflater inflater;

    private ImageView emptyImg;

    private TextView isHaveCoupon;

    protected PullBaseActivity() {
    }

    @Override
    public int getLyout() {
        return R.layout.activity_pull_base;
    }

    @Override
    public void init() {
        emptyImg= (ImageView) findViewById(R.id.emptyImg);
        isHaveCoupon= (TextView) findViewById(R.id.isHaveCoupon);
        inflater=LayoutInflater.from(PullBaseActivity.this);
        headView= (LinearLayout) findViewById(R.id.headView);
        emptyView= (ScrollView) findViewById(R.id.emptyView);
        baseSwipeLayout = (SwipeRefreshLayout) findViewById(R.id.base_swipe_layout);
        basePullListView = (RecyclerView) findViewById(R.id.base_pull_list_view);
        baseSwipeLayout.setColorSchemeResources(android.R.color.holo_blue_light,
                android.R.color.holo_red_light,
                android.R.color.holo_orange_light,
                android.R.color.holo_green_light);
        baseSwipeLayout.setEnabled(true);
        baseSwipeLayout.setOnRefreshListener(mOnRefreshListener);
        basePullListView.setLayoutManager(new LinearLayoutManager(this));
        myAdapter = getAdapter();
        basePullListView.setAdapter(myAdapter);
        initData();
        getData(HttpLoadEnum.LOADFIRST);
        basePullListView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if(isSlideToBottom(recyclerView)){
                if (isHaveMore) {
                    page++;
                    getData(HttpLoadEnum.LOADMORE);
                } else {
                    Toast.makeText(PullBaseActivity.this, "没有更多数据", Toast.LENGTH_SHORT).show();
                }
                super.onScrolled(recyclerView, dx, dy);
            }
            }
        });
    }
    /**
     * 获取适配器
     *
     * @return
     */
    public abstract RecyclerView.Adapter getAdapter();
    /**
     * 加载数据
     *
     * @param page
     * @return
     */
    public abstract void loadData(int page, PullData<T> pull);
    /**
     * 设置头布局
     * @param view
     */
    public void setHeadView(View view){
        headView.addView(view);
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
     * 下拉刷新监听
     */
    private SwipeRefreshLayout.OnRefreshListener mOnRefreshListener = new SwipeRefreshLayout.OnRefreshListener() {
        @Override
        public void onRefresh() {
            page = 1;
            getData(HttpLoadEnum.LOADFIRST);
        }
    };
    /**
     * 加载数据业务处理
     * @param httpload
     */
    public void getData(final HttpLoadEnum httpload) {
        loadData(page, new PullData<T>() {
            @Override
            public void getObject(List<T> data) {
                baseSwipeLayout.setRefreshing(false);
                /**
                 * 如果是第一次就判断一下如果数据为空就显示空
                 */
                if (httpload == HttpLoadEnum.LOADFIRST) {
                    objectList.clear();
                    if(data.size()==0){
                        setEmpty();
                    }else{
                        setData();
                    }
                }
                if (data.size() < 20) {
                    isHaveMore = false;
                } else {
                    isHaveMore = true;
                }
                objectList.addAll(data);
                myAdapter.notifyDataSetChanged();
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

    public abstract  void initData();
    protected boolean isSlideToBottom(RecyclerView recyclerView) {
        if (recyclerView == null) return false;
        if (recyclerView.computeVerticalScrollExtent() + recyclerView.computeVerticalScrollOffset() >= recyclerView.computeVerticalScrollRange())
            return true;
        return false;
    }
}
