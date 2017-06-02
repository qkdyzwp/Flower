package com.fir.open.sorce.http;

import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.http.body.RequestBody;
import org.xutils.x;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Created by mododata-android on 2017/4/5.
 */

public class HttpUtils {

    /**
     * 异步post请求
     *
     * @param url
     * @param maps
     * @param callback
     */
    public void post(String url, Params maps, final BaseCallBack callback) {
        RequestParams params = new RequestParams(url);
        //文字上传
        if (null != maps.getStrParam() && !maps.getStrParam().isEmpty()) {
            for (Map.Entry<String, String> entry : maps.getStrParam().entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue());
            }
        }
        //文件上传
        if (null != maps.getFileParam() && !maps.getFileParam().isEmpty()) {
            // 有上传文件时使用multipart表单, 否则上传原始文件流.
            params.setMultipart(true);
            for (Map.Entry<String, File> entry : maps.getFileParam().entrySet()) {
                params.addBodyParameter(entry.getKey(), entry.getValue().getAbsoluteFile());
            }
        }
        x.http().post(params, new Callback.CommonCallback<String>() {
            private boolean hasError = false;
            private String result = null;

            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    this.result = result;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                hasError = true;
                callback.onFail(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                if (!hasError && result != null) {
                    callback.onResponse(result);
                }
            }
        });
    }

    /**
     * 异步post请求
     *
     * @param url
     * @param maps
     * @param callback
     */
    public void postForBody(String url, String maps, final BaseCallBack callback) {
        RequestParams params = new RequestParams(url);
        params.setBodyContent(maps);

        x.http().post(params, new Callback.CommonCallback<String>() {
            private boolean hasError = false;
            private String result = null;

            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    this.result = result;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                hasError = true;
                callback.onFail(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                if (!hasError && result != null) {
                    callback.onResponse(result);
                }
            }
        });
    }

    /**
     * 异步post请求
     *
     * @param url
     * @param maps
     */
    public void postForBodyWithFile(String url, String maps, Params param, final BaseCallBack callback) {
        RequestParams params = new RequestParams(url);
        params.setBodyContent(maps);
        params.addBodyParameter("param", maps);
//        params.addHeader("Content-Type","multipart/form-data");
//        params.addQueryStringParameter("Content-Type","multipart/form-data");
        try {
            RequestBody body = params.getRequestBody();
            body.setContentType("multipart/form-data;boundary=" + "-----------------------------276443266232757");
            params.setRequestBody(body);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //文件上传
        if (null != param.getFileParam() && !param.getFileParam().isEmpty()) {
            params.setMultipart(true);
            // 有上传文件时使用multipart表单, 否则上传原始文件流.
//            params.setMultipart(true);
//            params.addQueryStringParameter("wd", "xUtils");
            for (Map.Entry<String, File> entry : param.getFileParam().entrySet()) {
//
//                params.addBodyParameter(entry.getKey(),entry.getValue().getAbsoluteFile(),"video/mp4");
                params.addBodyParameter(entry.getKey(), entry.getValue().getAbsoluteFile(), "video/mpeg4");
            }
        }
        x.http().post(params, new Callback.CommonCallback<String>() {
            private boolean hasError = false;
            private String result = null;

            @Override
            public void onSuccess(String result) {
                if (result != null) {
                    this.result = result;
                }
            }

            @Override
            public void onError(Throwable ex, boolean isOnCallback) {
                hasError = true;
                callback.onFail(ex.getMessage());
            }

            @Override
            public void onCancelled(CancelledException cex) {

            }

            @Override
            public void onFinished() {
                if (!hasError && result != null) {
                    callback.onResponse(result);
                }
            }
        });
    }
}
