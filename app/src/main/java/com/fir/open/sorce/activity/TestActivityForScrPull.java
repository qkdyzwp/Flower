package com.fir.open.sorce.activity;

import android.view.View;
import android.widget.TextView;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.ScrPullBaseActivity;
import com.fir.open.sorce.inter.ScrPullData;
public class TestActivityForScrPull extends ScrPullBaseActivity {
    private View view;
    private TextView test;
    @Override
    public View setView() {
        view=inflater.inflate(R.layout.activity_test_for_scr_pull,null);
        return view;
    }
    @Override
    public void loadData(ScrPullData pull) {
        //获取网络数据然后解析赋值等
        test.setText("11111");
        pull.error();
        //如果解析失败就调用 pull.error();
    }
    @Override
    public void inidData() {
        setHeadView(inflater.inflate(R.layout.head_layout,null));
        setEmptyImg(R.mipmap.ic_launcher);
        setEmptyText("该测试数据为空");
        setBomView(inflater.inflate(R.layout.bom_layout,null));
        test= (TextView) view.findViewById(R.id.test);
    }
}
