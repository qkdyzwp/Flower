package com.fir.open.sorce.response;

/**
 * Created by modata_fir on 2017/6/2.
 */

public class BaseResponse<T> {
    private boolean success;
    private String resCode;
    private String resMsg;
    private DataResponse<T> data;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getResCode() {
        return resCode;
    }

    public void setResCode(String resCode) {
        this.resCode = resCode;
    }

    public String getResMsg() {
        return resMsg;
    }

    public void setResMsg(String resMsg) {
        this.resMsg = resMsg;
    }

    public DataResponse<T> getData() {
        return data;
    }

    public void setData(DataResponse<T> data) {
        this.data = data;
    }
}
