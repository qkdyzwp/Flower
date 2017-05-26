package com.fir.open.sorce.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.base.BaseActivity;
import com.fir.open.sorce.fragment.CartFragemnt;
import com.fir.open.sorce.fragment.ClassifyFragemnt;
import com.fir.open.sorce.fragment.HomeFragemnt;
import com.fir.open.sorce.fragment.MyFragemnt;
import com.yinglan.alphatabs.AlphaTabsIndicator;
import java.util.ArrayList;
import java.util.List;
public class MainActivity extends BaseActivity {
    private AlphaTabsIndicator alphaTabsIndicator;
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
//            if (0 == position) {
//                alphaTabsIndicator.getTabView(0).showNumber(alphaTabsIndicator.getTabView(0).getBadgeNumber() - 1);
//            } else if (2 == position) {
//                alphaTabsIndicator.getCurrentItemView().removeShow();
//            } else if (3 == position) {
//                alphaTabsIndicator.removeAllBadge();
//            }
        }
        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }
}
