package com.woolbro.model;

import java.util.List;

public class AjaxResponseBody {

	String msg;
	List<User> result;

	//getter, setter 
	
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public List<User> getResult() {
		return result;
	}
	public void setResult(List<User> result) {
		this.result = result;
	}
	
	
}
