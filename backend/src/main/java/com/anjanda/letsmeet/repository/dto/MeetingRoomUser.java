package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MeetingRoomUser {
	int mruMrNo;
	int mruUNo;
	String mruUserLat;
	String mruUserLng;
	public MeetingRoomUser(int mruMrNo, int mruUNo, String mruUserLat, String mruUserLng) {
		super();
		this.mruMrNo = mruMrNo;
		this.mruUNo = mruUNo;
		this.mruUserLat = mruUserLat;
		this.mruUserLng = mruUserLng;
	}
	public MeetingRoomUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getMruMrNo() {
		return mruMrNo;
	}
	public void setMruMrNo(int mruMrNo) {
		this.mruMrNo = mruMrNo;
	}
	public int getMruUNo() {
		return mruUNo;
	}
	public void setMruUNo(int mruUNo) {
		this.mruUNo = mruUNo;
	}
	public String getMruUserLat() {
		return mruUserLat;
	}
	public void setMruUserLat(String mruUserLat) {
		this.mruUserLat = mruUserLat;
	}
	public String getMruUserLng() {
		return mruUserLng;
	}
	public void setMruUserLng(String mruUserLng) {
		this.mruUserLng = mruUserLng;
	}
	@Override
	public String toString() {
		return "MeetingRoomUser [mruMrNo=" + mruMrNo + ", mruUNo=" + mruUNo + ", mruUserLat=" + mruUserLat
				+ ", mruUserLng=" + mruUserLng + "]";
	}
	
	
}
