package com.example.fsw.beans;

public class Response {
	String result;
	Integer code;

	public Response() {
	}

	public Response(String result, Integer code) {
		this.result = result;
		this.code = code;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

}
