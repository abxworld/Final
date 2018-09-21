package com.bsworld.spi.result;
/*
*author: xieziyang
*date: 2018/6/26
*time: 12:16
*description:
*/

public class StaticResult<T> {
    private String resCode;
    private String resMsg;
    private T data;

    public StaticResult() {
    }

    public StaticResult(String resCode, String resMsg, T data) {
        this.resCode = resCode;
        this.resMsg = resMsg;
        this.data = data;
    }

    public static <V> StaticResult<V> success() {
        return (new ResultBuilder()).resCode("0000").resMsg("SUCCESS").data("").build();
    }

    @Override
    public String toString() {
        return "StaticResult{" +
                "resCode='" + resCode + '\'' +
                ", resMsg='" + resMsg + '\'' +
                ", data=" + data +
                '}';
    }

    public static class ResultBuilder<T> {
        private String resCode;
        private String resMsg;
        private T data;

        public ResultBuilder() {

        }

        public ResultBuilder<T> resCode(String resCode) {
            this.resCode = resCode;
            return this;
        }

        public ResultBuilder<T> resMsg(String resMsg) {
            this.resMsg = resMsg;
            return this;
        }

        public ResultBuilder data(T data) {
            this.data = data;
            return this;
        }

        public StaticResult<T> build() {
            return new StaticResult<>(resCode, resMsg, data);
        }

    }
}
