package com.fir.open.sorce.fragment.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by mododata-android on 2017/5/25.
 */

public abstract class BaseFragment extends Fragment {
    public String TAG=this.getClass().getCanonicalName();
    public View rootView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView  = initView(inflater,container);
        return rootView;
    }
    @Override
    public void onActivityCreated( Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
    protected abstract View initView(LayoutInflater inflater,ViewGroup container);

}
