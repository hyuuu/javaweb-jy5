package com.itdr.common;

import com.itdr.utils.GetPropertiesUtil;

/**
 * @ClassName: ResponseCode
 * @author: heyuu
 * @create: 2019-07-31 14:45:39
 * @version: JDK 1.8
 * @description:
 */
public class ResponseCode<T> {
    private String status;
    private T data;
    private String msg;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String toString() {
        return "{" +
                "status:'" + status + '\'' +
                ", data:" + data +
                ", msg:'" + msg + '\'' +
                '}';
    }

    public static <T> ResponseCode success(String status, T data){
        ResponseCode rc = new ResponseCode();
        rc.setStatus(status);
        rc.setData(data);
        return rc;
    }
    public static <T> ResponseCode success(T data){
        ResponseCode rc = new ResponseCode();
        rc.setStatus(GetPropertiesUtil.getValue("ResponseCode_SUCCESS"));
        rc.setData(data);
        return rc;
    }
    public static <T> ResponseCode fail(String status, String msg){
        ResponseCode rc = new ResponseCode();
        rc.setStatus(status);
        rc.setMsg(msg);
        return rc;
    }
}
