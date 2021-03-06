package com.anjanda.letsmeet.repository.dto;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class User {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int uNo; // 시퀀스, auto_increment
	private String uEmail;
	private String uPassword;
	private String uName;
	private int uImageId;
	private String uJoinDate;
	private String uProvider;
	
	public int getuNo() {
		return uNo;
	}
	public void setuNo(int uNo) {
		this.uNo = uNo;
	}
	public String getuEmail() {
		return uEmail;
	}
	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}
	public String getuPassword() {
		return uPassword;
	}
	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}
	public String getuName() {
		return uName;
	}
	public void setuName(String uName) {
		this.uName = uName;
	}
	public int getuImageId() {
		return uImageId;
	}
	public void setuImageId(int uImageId) {
		this.uImageId = uImageId;
	}
	public String getuJoinDate() {
		return uJoinDate;
	}
	public void setuJoinDate(String uJoinDate) {
		this.uJoinDate = uJoinDate;
	}
	public String getuProvider() {
		return uProvider;
	}
	public void setuProvider(String uProvider) {
		this.uProvider = uProvider;
	}
	@Override
	public String toString() {
		return "User [uNo=" + uNo + ", uEmail=" + uEmail + ", uPassword=" + uPassword + ", uName=" + uName
				+ ", uImageId=" + uImageId + ", uJoinDate=" + uJoinDate + ", uProvider=" + uProvider + "]";
	}
	
	
	
}
