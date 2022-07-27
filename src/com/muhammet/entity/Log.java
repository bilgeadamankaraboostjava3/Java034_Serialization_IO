package com.muhammet.entity;

import java.io.Serializable;
import java.util.UUID;

public class Log implements Serializable{
	
	String id;
	String errormessage;
	String classname;
	String methodname;
	Long timestamp;
	String detail;
	
	
	
	@Override
	public String toString() {
		return "Log [id=" + id + ", errormessage=" + errormessage + ", classname=" + classname + ", methodname="
				+ methodname + ", timestamp=" + timestamp + ", detail=" + detail + "]";
	}
	public Log() {
		super();
	}
	public Log(String errormessage, String classname, String methodname, Long timestamp, String detail) {
		super();
		id = UUID.randomUUID().toString();
		this.errormessage = errormessage;
		this.classname = classname;
		this.methodname = methodname;
		this.timestamp = timestamp;
		this.detail = detail;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getErrormessage() {
		return errormessage;
	}
	public void setErrormessage(String errormessage) {
		this.errormessage = errormessage;
	}
	public String getClassname() {
		return classname;
	}
	public void setClassname(String classname) {
		this.classname = classname;
	}
	public String getMethodname() {
		return methodname;
	}
	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}
	public Long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	

}
