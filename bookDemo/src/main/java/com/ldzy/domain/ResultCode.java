package com.ldzy.domain;

public enum  ResultCode {
    SUCCESS(10,"操作成功！"),
    SUCCESS_LOGIN(11,"登录成功！！"),
    SUCCESS_ACTIVE(12,"激活成功！"),

    ERROR(20,"操作失败！"),
    ERROR_DB(21,"数据库发生异常"),
    NOT_ACTIVE(22,"未激活"),
    ERROR_NAME_PASSWORD(23,"用户名或密码错误"),
    NOT_PARAM(24,"请求中没有携带参数"),
    ERROR_ACTIVE(25,"激活用户失败"),
    NOT_LOGIN(26,"未登录"),
    ERROR_EXPIRE(27,"激活码过期"),
    ERROR_QUERY_GOODS(28,"查询商品失败"),
    ERROR_ADD_GOODS(29,"添加商品失败"),
    ERROR_PARAM(30,"请求的参数项缺失或参数格式不对或类型不对");

    private int code;
    private String desc;

    ResultCode(int code,String desc){
        this.code = code;
        this.desc = desc;
    }

    public int getCode(){
        return code;
    }

    public String getDesc(){
        return desc;
    }
}
