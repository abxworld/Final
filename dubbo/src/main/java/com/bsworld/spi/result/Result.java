package com.bsworld.spi.result;
/*
*author: xieziyang
*date: 2018/6/26
*time: 12:46
*description:
*/

public class Result<T> {
    private String resCode;
    private String resMsg;
    private T data;

    public Result(String resCode, String resMsg, T data) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.data = data;
    }

    public Result() {
    }

    public static Result newInstance() {
        Result result = new Result();
        return result;
    }

    public Result<T> resCode(String resCode) {
        this.resCode = resCode;
        return this;
    }

    public Result<T> resMsg(String resMsg) {
        this.resMsg = resMsg;
        return this;
    }

    public Result data(T data) {
        this.data = data;
        return this;
    }

    public static <V> Result<V> success() {
        return Result.newInstance().resCode("0000").resMsg("SUCCESS").data("");
    }

    @Override
    public String toString() {
        return "Result{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", data=" + data +
                '}';
    }
}
