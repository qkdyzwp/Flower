package com.fir.open.sorce.fragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.fir.open.sorce.R;
import com.fir.open.sorce.adapter.ClassifyAdapter;
import com.fir.open.sorce.adapter.ClassifyColorAdapter;
import com.fir.open.sorce.adapter.ClassifyMaterialAdapter;
import com.fir.open.sorce.adapter.ClassifyPriceAdapter;
import com.fir.open.sorce.fragment.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mododata-android on 2017/5/25.
 */

public class ClassifyFragemnt extends BaseFragment {
    private RadioGroup main_sort_select_rg;
    private RecyclerView fragment_list_rv;
    private List<String> itemStr=new ArrayList<>();//
    private List<String> materialStr=new ArrayList<>();//
    private List<String> colorStr=new ArrayList<>();//
    private List<String> priceStr=new ArrayList<>();//
    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        View view = inflater.inflate(R.layout.fragment_main_sort, null);
        return view;
    }
    @Override
    protected void init(View view) {
        getData();
        main_sort_select_rg= (RadioGroup) view.findViewById(R.id.main_sort_select_rg);
        fragment_list_rv= (RecyclerView) view.findViewById(R.id.fragment_list_rv);
        fragment_list_rv.setLayoutManager(new GridLayoutManager(getActivity(),4));
        fragment_list_rv.setAdapter(new ClassifyAdapter(itemStr,getActivity()));
        main_sort_select_rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId){
                    case R.id.main_sort_select_object_rb:
                        fragment_list_rv.setLayoutManager(new GridLayoutManager(getActivity(),4));
                        fragment_list_rv.setAdapter(new ClassifyAdapter(itemStr,getActivity()));
                        break;
                    case R.id.main_sort_select_material_rb:
                        fragment_list_rv.setLayoutManager(new GridLayoutManager(getActivity(),3));
                        fragment_list_rv.setAdapter(new ClassifyMaterialAdapter(materialStr,getActivity()));
                        break;
                    case R.id.main_sort_select_color_rb:
                        fragment_list_rv.setLayoutManager(new GridLayoutManager(getActivity(),3));
                        fragment_list_rv.setAdapter(new ClassifyColorAdapter(colorStr,getActivity()));
                        break;
                    case R.id.main_sort_select_price_rb:
                        fragment_list_rv.setLayoutManager(new LinearLayoutManager(getActivity()));
                        fragment_list_rv.setAdapter(new ClassifyPriceAdapter(priceStr,getActivity()));
                        break;

                }
            }
        });


    }
    public void getData(){
        for (int i = 0; i < 8; i++) {
            itemStr.add("磷肥"+i);
        }
        for (int i = 0; i < 20; i++) {
            materialStr.add("大豆"+95+i);
        }
        for (int i = 0; i < 7; i++) {
            colorStr.add("拖拉机"+12+i+"马力");
        }
        for (int i = 0; i < 7; i++) {
            priceStr.add("22"+(i*10)+i);
        }
    }
}
