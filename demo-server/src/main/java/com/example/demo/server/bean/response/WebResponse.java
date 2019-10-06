package com.example.demo.server.bean.response;

/**
 * Author: Leo
 * Email: haojun02@meituan.com
 * Date:2019-10-06
 * Time:16:25
 * ------------------------------------
 * Desc:
 */
public class WebResponse <T> {
    public static class STATUS {
        // 正常
        public static final int STATUS_OK = 0;
        // 系统异常
        public static final int SYSTEM_ERROR = 1;
    }

    public static class MESSAGE {
        public static final String SYSTEM_ERROR_MESSAGE = "System Error";
        public static final String SUCCESS_MESSAGE = "Success";
    }

    //请求状态
    private int status = STATUS.STATUS_OK;
    //请求数据
    private T data;
    //错误码信息
    private String message;

    public WebResponse(int status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public WebResponse() {

    }

    public <E extends WebResponse<T>> E status(int status) {
        setStatus(status);
        return (E) this;
    }

    public <E extends WebResponse<T>> E message(String message) {
        setMessage(message);
        return (E) this;
    }

    public <E extends WebResponse<T>> E data(T data) {
        setData(data);
        return (E) this;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public T getData() {
        return data;
    }

    public WebResponse setData(T data) {
        this.data = data;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    public static WebResponse getErrorWebResponse() {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(STATUS.SYSTEM_ERROR);
        webResponse.setMessage(MESSAGE.SYSTEM_ERROR_MESSAGE);
        return webResponse;
    }

    public static WebResponse getErrorWebResponse(String message) {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(STATUS.SYSTEM_ERROR);
        webResponse.setMessage(message);
        return webResponse;
    }

    public static WebResponse getSuccessWebResponse() {
        WebResponse<Object> webResponse = new WebResponse<Object>();
        webResponse.setStatus(STATUS.STATUS_OK);
        webResponse.setMessage(MESSAGE.SUCCESS_MESSAGE);
        return webResponse;
    }

}
