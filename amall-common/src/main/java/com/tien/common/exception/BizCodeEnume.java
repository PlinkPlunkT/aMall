package com.tien.common.exception;

/**
  *@ClassName: BizCodeEnume
  *@Author: Acme Tien
  *@Date: 2022/5/3 17:09
  *@Version: v1.0
  *@Description: 系统错误码的枚举类
**/
public enum BizCodeEnume {

    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    VALID_EXCEPTION(10001, "数据校验错误");

    private int code;
    private String msg;
    BizCodeEnume(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
