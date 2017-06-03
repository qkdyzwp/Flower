package com.fir.open.sorce.fragment;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.fir.open.sorce.R;
import com.fir.open.sorce.activity.LinkmanActivity;
import com.fir.open.sorce.activity.SetActivity;
import com.fir.open.sorce.fragment.base.BaseFragment;

/**
 * Created by mododata-android on 2017/5/25.
 */

public class MyFragemnt extends BaseFragment {
    private ImageView set;
    private RelativeLayout linkman;
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main_user, null);

        return view;
    }
    @Override
    protected void init(View view) {
        linkman= (RelativeLayout) view.findViewById(R.id.linkman);
        set= (ImageView) view.findViewById(R.id.set);
        set.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SetActivity.class);
                startActivity(intent);
            }
        });
        linkman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LinkmanActivity.class);
                startActivity(intent);
            }
        });
    }
}
