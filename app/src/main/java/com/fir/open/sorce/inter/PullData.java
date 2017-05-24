package com.fir.open.sorce.inter;

import java.util.List;


/**
 * Created by mododata-android on 2017/5/24.
 */

public interface PullData<T> {

     void getObject(List<T> data);

     void error();
}
