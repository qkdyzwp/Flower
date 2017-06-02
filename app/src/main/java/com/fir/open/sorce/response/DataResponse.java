package com.fir.open.sorce.response;

import com.fir.open.sorce.entity.Banner;

import java.util.List;

/**
 * Created by modata_fir on 2017/6/2.
 */

public class DataResponse<T> {
    private int count;
    private List<T> list;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
