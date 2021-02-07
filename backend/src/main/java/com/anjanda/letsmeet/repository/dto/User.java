package com.anjanda.letsmeet.repository.dto;

/**
 * 
 * @Date : 2021. 2. 5.
 * @Team : AnJanDa
 * @author : 김동빈, 김지현, 임호빈
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 데이터 VO 클래스
 * @Description
 *	- 롬복 사용해서 getter, setter 사용함 (그래서 아래 메소드들 필요없음)
 */

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class User {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY) 
	private int uNo; 
	private String uEmail;
	private String uPassword;
	private String uName;
	private int uImageId;
	private String uJoinDate;
	private String uProvider;
	private String uAuthority;
	private String uSalt;
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
	public String getuAuthority() {
		return uAuthority;
	}
	public void setuAuthority(String uAuthority) {
		this.uAuthority = uAuthority;
	}
	public String getuSalt() {
		return uSalt;
	}
	public void setuSalt(String uSalt) {
		this.uSalt = uSalt;
	}
	
}
