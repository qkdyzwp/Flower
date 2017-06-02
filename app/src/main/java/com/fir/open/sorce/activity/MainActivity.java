package com.fir.open.sorce.activity;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.fir.open.sorce.FlowerApplication;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.BaseActivity;
import com.fir.open.sorce.fragment.CartFragemnt;
import com.fir.open.sorce.fragment.ClassifyFragemnt;
import com.fir.open.sorce.fragment.HomeFragemnt;
import com.fir.open.sorce.fragment.MyFragemnt;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import com.yinglan.alphatabs.OnTabChangedListner;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {
    private AlphaTabsIndicator alphaTabsIndicator;
    private int selectLocation=0;
    @Override
    public int getLyout() {
        return R.layout.activity_main;
    }
    @Override
    public void init() {
        ViewPager mViewPger = (ViewPager) findViewById(R.id.mViewPager);
        MainAdapter mainAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPger.setAdapter(mainAdapter);
        mViewPger.addOnPageChangeListener(mainAdapter);
        alphaTabsIndicator = (AlphaTabsIndicator) findViewById(R.id.alphaIndicator);
        alphaTabsIndicator.setViewPager(mViewPger);
        alphaTabsIndicator.setOnTabChangedListner(new OnTabChangedListner() {
            @Override
            public void onTabSelected(int tabNum) {
                if(FlowerApplication.isLogin()){
                    selectLocation=tabNum;
                }else{
                    if(tabNum==2||tabNum==3){
                        Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                        startActivityForResult(intent,1000);
                    }else{
                        selectLocation=tabNum;
                    }
                }
            }
        });
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1000){
            alphaTabsIndicator.setTabCurrenItem(selectLocation);
        }
    }
    private class MainAdapter extends FragmentPagerAdapter implements ViewPager.OnPageChangeListener {
        private List<Fragment> fragments = new ArrayList<>();
        private String[] titles = {"首页", "分类", "购物车", "我的"};
        public MainAdapter(FragmentManager fm) {
            super(fm);
            fragments.add(new HomeFragemnt ());
            fragments.add(new ClassifyFragemnt());
            fragments.add(new CartFragemnt());
            fragments.add(new MyFragemnt());
        }
        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }
        @Override
        public void onPageSelected(int position) {

        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
