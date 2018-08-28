package com.bsworld.fd;
/*
*author: xieziyang
*date: 2018/7/5
*time: 9:44
*description:
*/

public class FastException extends Exception {
    private static final long serialVersionUID = -1848618491499044704L;
    private String code;
    private String description;

    public FastException(String code, String message) {
        super(message);
        this.code = code;
    }

    public FastException(String code, String message, String description) {
        super(message);
        this.code = code;
        this.description = description;
    }

    /**
     * 错误码
     *
     * @return
     */
    public String getCode() {
        return code;
    }

    /**
     * 用户可读描述信息
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getName());
        sb.append(": [");
        sb.append("] - ");
        sb.append(code);
        sb.append(" - ");
        sb.append(getMessage());
        if (getDescription() != null) {
            sb.append(" - ");
            sb.append(getDescription());
        }
        return sb.toString();
    }
}