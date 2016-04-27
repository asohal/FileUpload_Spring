package com.ga.common;

/**
 * The Response class will contain data which will be sent to the front end
 * processor in terms of JSON object. Controller will convert this object to the
 * JASON.
 * 
 */
public class Response {

	private Integer serverCode;
	private Integer clientCode;
	private String message;
	private Object data;

	public Integer getServerCode() {
		return serverCode;
	}

	public void setServerCode(Integer serverCode) {
		this.serverCode = serverCode;
	}

	public Integer getClientCode() {
		return clientCode;
	}

	public void setClientCode(Integer clientCode) {
		this.clientCode = clientCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}