package com.fir.open.sorce.http;


import com.fir.open.sorce.util.StringUtils;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by wp on 2016/1/14.
 * about
 */
public class Params {
    private Map<String, String> strParam;//字符串
    private Map<String, File> fileParam;//文件

    public Params() {
        strParam = new LinkedHashMap<>();
        fileParam = new LinkedHashMap<>();
    }

    public boolean put(String key, String value) {
        if (StringUtils.isEmpty(key) || StringUtils.isEmpty(value)) {
            return false;
        } else {
            strParam.put(key, value);
            return true;
        }
    }

    public boolean put(String key, File file) {
        if (StringUtils.isEmpty(key) || file == null) {
            return false;
        } else {
            fileParam.put(key, file);
            return true;
        }
    }

    public void clear() {
        strParam.clear();
        fileParam.clear();
        System.gc();
    }

    public Map<String, String> getStrParam() {
        return strParam;
    }

    public Map<String, File> getFileParam() {
        return fileParam;
    }

    public boolean hasParams() {
        return strParam.size() > 0;
    }

    public boolean hasFileParams() {
        return fileParam.size() > 0;
    }
}
