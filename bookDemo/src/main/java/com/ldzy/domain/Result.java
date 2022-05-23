package com.ldzy.domain;
import java.io.Serializable;
/**
 * JSON数据封装类
 */
public class Result<T> implements Serializable{
	private boolean success; //是否成功操作成功
	private Integer code;
	private String message; //需要传递的信息
	private T data;         //需要传递的数据
	public Result(boolean success, String message,Integer code) {
		super();
		this.success=success;
		this.message = message;
		this.code=code;
	}
	public Result(boolean success, String message,Integer code, T data) {
		this.success = success;
		this.message = message;
		this.code=code;
		this.data = data;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
}
