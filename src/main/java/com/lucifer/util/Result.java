package com.lucifer.util;

public class Result {
	
	private boolean ok;
	
	private Object message;
	
	private Object data;

	public boolean isOk() {
		return ok;
	}

	public void setOk(boolean ok) {
		this.ok = ok;
	}

	public Object getMessage() {
		return message;
	}

	public void setMessage(Object message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	public static Result result(boolean ok, Object message, Object data) {
	    Result result = new Result();
	    result.setOk(ok);
	    result.setMessage(message);
	    result.setData(data);
	    return result;
	}
	
	public static Result ok() {
	    return Result.result(true, null, null);
	}
	
	public static Result ok(Object data) {
	    return Result.result(true, null, data);
	}
	
	public static Result fail() {
	    return Result.result(false, null, null);
	}
	
	public static Result fail(Object msg) {
	    return Result.result(false, msg, null);
	}
}
