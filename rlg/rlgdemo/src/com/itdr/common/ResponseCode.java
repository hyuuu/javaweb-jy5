package com.itdr.common;

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
        return "ResponseCode{" +
                "status='" + status + '\'' +
                ", data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }
}
