package com.oris.exception;

public class UploadException extends Exception{
	private static final long serialVersionUID = 619272949612169914L;
	
	private Object errObj;
	private String errorMessage;
	
	public UploadException() {
		//TODO: rubyanne : Auto-generated constructor stub
	}
	
	public UploadException(Object errObj, String errorMessage) {
		super();
		this.errObj = errObj;
		this.errorMessage = errorMessage;
	}

	public Object getErrObj() {
		return errObj;
	}
	public void setErrObj(Object errObj) {
		this.errObj = errObj;
	}
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
