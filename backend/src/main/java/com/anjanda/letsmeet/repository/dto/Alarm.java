package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Alarm {
	private int aNo;
	private int aUNo;
	private String aTitle;
	private String aContent;
	private String aTime;
	public int getaNo() {
		return aNo;
	}
	public void setaNo(int aNo) {
		this.aNo = aNo;
	}
	public int getaUNo() {
		return aUNo;
	}
	public void setaUNo(int aUNo) {
		this.aUNo = aUNo;
	}
	public String getaTitle() {
		return aTitle;
	}
	public void setaTitle(String aTitle) {
		this.aTitle = aTitle;
	}
	public String getaContent() {
		return aContent;
	}
	public void setaContent(String aContent) {
		this.aContent = aContent;
	}
	public String getaTime() {
		return aTime;
	}
	public void setaTime(String aTime) {
		this.aTime = aTime;
	}
	public Alarm() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Alarm(int aNo, int aUNo, String aTitle, String aContent, String aTime) {
		super();
		this.aNo = aNo;
		this.aUNo = aUNo;
		this.aTitle = aTitle;
		this.aContent = aContent;
		this.aTime = aTime;
	}
	
}
