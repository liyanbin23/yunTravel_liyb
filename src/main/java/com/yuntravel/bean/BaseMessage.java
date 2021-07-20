package com.yuntravel.bean;

public class BaseMessage<T> {
    private	int code=0;
    private T data;
    private String message;

    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }

    public BaseMessage() {
        super();

    }
    public BaseMessage(int code, T data) {
        super();
        this.code = code;
        this.data = data;
    }
    public BaseMessage(int code, T data,String message) {
        super();
        this.code = code;
        this.data = data;
        this.message=message;
    }

}
