package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {
	private int uNo;
	private String uEmail;
	private String uPassword;
	private String uName;
	private String uBirth;
	private String uDefaultLat;
	private String uDefaultLng;
	private int uImageId;
	private String uJoinDate;
	private String uProvider;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(int uNo, String uEmail, String uPassword, String uName, String uBirth, String uDefaultLat,
			String uDefaultLng, int uImageId, String uJoinDate, String uProvider) {
		super();
		this.uNo = uNo;
		this.uEmail = uEmail;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uBirth = uBirth;
		this.uDefaultLat = uDefaultLat;
		this.uDefaultLng = uDefaultLng;
		this.uImageId = uImageId;
		this.uJoinDate = uJoinDate;
		this.uProvider = uProvider;
	}
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
	public String getuBirth() {
		return uBirth;
	}
	public void setuBirth(String uBirth) {
		this.uBirth = uBirth;
	}
	public String getuDefaultLat() {
		return uDefaultLat;
	}
	public void setuDefaultLat(String uDefaultLat) {
		this.uDefaultLat = uDefaultLat;
	}
	public String getuDefaultLng() {
		return uDefaultLng;
	}
	public void setuDefaultLng(String uDefaultLng) {
		this.uDefaultLng = uDefaultLng;
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
		return "User [uNo=" + uNo + ", uEmail=" + uEmail + ", uPassword=" + uPassword + ", uName=" + uName + ", uBirth="
				+ uBirth + ", uDefaultLat=" + uDefaultLat + ", uDefaultLng=" + uDefaultLng + ", uImageId=" + uImageId
				+ ", uJoinDate=" + uJoinDate + ", uProvider=" + uProvider + "]";
	}
}
