package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MeetingRoomUser {
	private int mruMrNo;
	private int mruUNo;
	private String mruUserLat;
	private String mruUserLng;
	private String mruUserDates;
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
	public String getMruUserDates() {
		return mruUserDates;
	}
	public void setMruUserDates(String mruUserDates) {
		this.mruUserDates = mruUserDates;
	}
	@Override
	public String toString() {
		return "MeetingRoomUser [mruMrNo=" + mruMrNo + ", mruUNo=" + mruUNo + ", mruUserLat=" + mruUserLat
				+ ", mruUserLng=" + mruUserLng + ", mruUserDates=" + mruUserDates + "]";
	}

	
}
