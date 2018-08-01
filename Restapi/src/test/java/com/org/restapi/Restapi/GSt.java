package com.org.restapi.Restapi;

public class GSt {

	private String cName;
	private String status;
	public GSt(){
		
	}
public GSt(String cN, String y){
	
	this.cName=cN;
	this.status=y;
		
	}
	public String isStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	
}
