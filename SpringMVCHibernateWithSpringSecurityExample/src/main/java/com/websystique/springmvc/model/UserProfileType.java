package com.websystique.springmvc.model;

import java.io.Serializable;

public enum UserProfileType implements Serializable{
	USER("USER"),
	DBA("DBA"),
	ADMIN("ADMIN"),
	MANAGER("MANAGER");
	
	String userProfileType;
	
	private UserProfileType(String userProfileType){
		this.userProfileType = userProfileType;
	}
	
	public String getUserProfileType(){
		return userProfileType;
	}
	
}
