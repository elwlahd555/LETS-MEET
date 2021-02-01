package com.anjanda.letsmeet.repository.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.springframework.data.annotation.Id;

/**
 * 
 * @Date 2021. 1. 25.
 * @Team AnJanDa
 * @author 개발자명
 * @Project : Test -
 * @Function : 유저 DB 테이블
 * @Description : - 이메일 인증 확인 => 수정 필요 - 사진 받기 호우...?
 */

@Entity
public class User {

	@Id // Primary key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 프로젝트에서 연결된 DB의 넘버링 전략을 따라간다.
	private int uNo; // 시퀀스, auto_increment

	@Column
	private String uEmail;
	@Column
	private char uConfirmEmail;
	@Column
	private String uPassword;
	@Column
	private String uName;
	@Column
	private String uBirth;
	@Column
	private String uJoinDate;
	@Column
	private String uImg;
	@Column
	private String uAddress;
	@Column
	private String uProvider;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(int uNo, String uEmail, char uConfirmEmail, String uPassword, String uName, String uBirth,
			String uJoinDate, String uImg, String uAddress, String uProvider) {
		super();
		this.uNo = uNo;
		this.uEmail = uEmail;
		this.uConfirmEmail = uConfirmEmail;
		this.uPassword = uPassword;
		this.uName = uName;
		this.uBirth = uBirth;
		this.uJoinDate = uJoinDate;
		this.uImg = uImg;
		this.uAddress = uAddress;
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

	public char getuConfirmEmail() {
		return uConfirmEmail;
	}

	public void setuConfirmEmail(char uConfirmEmail) {
		this.uConfirmEmail = uConfirmEmail;
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

	public String getuJoinDate() {
		return uJoinDate;
	}

	public void setuJoinDate(String uJoinDate) {
		this.uJoinDate = uJoinDate;
	}

	public String getuImg() {
		return uImg;
	}

	public void setuImg(String uImg) {
		this.uImg = uImg;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuProvider() {
		return uProvider;
	}

	public void setuProvider(String uProvider) {
		this.uProvider = uProvider;
	}

	@Override
	public String toString() {
		return "UserDTO [uNo=" + uNo + ", uEmail=" + uEmail + ", uConfirmEmail=" + uConfirmEmail + ", uPassword="
				+ uPassword + ", uName=" + uName + ", uBirth=" + uBirth + ", uJoinDate=" + uJoinDate + ", uImg=" + uImg
				+ ", uAddress=" + uAddress + ", uProvider=" + uProvider + "]";
	}
}
