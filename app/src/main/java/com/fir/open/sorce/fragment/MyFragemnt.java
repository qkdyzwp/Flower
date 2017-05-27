package com.fir.open.sorce.fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.fir.open.sorce.R;
import com.fir.open.sorce.fragment.base.BaseFragment;

/**
 * Created by mododata-android on 2017/5/25.
 */

public class MyFragemnt extends BaseFragment {
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.home_fragment_layout, null);
        TextView test= (TextView) view.findViewById(R.id.test);
        test.setText(TAG);
        return view;
    }

    @Override
    protected void init(View view) {

    }
}
