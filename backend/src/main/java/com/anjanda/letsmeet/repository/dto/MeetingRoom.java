package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MeetingRoom {
	private int mrNo;
	private int mrSuperUNo;
	private String mrName;
	private String mrCategory;
	private int mrImageId;
	private String mrDateStart;	 
	private String mrDateEnd;
	private String mrCenterLat;
	private String mrCenterLng;
	private String mrDate;
	private int mrPlace;
	public MeetingRoom() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MeetingRoom(int mrNo, int mrSuperUNo, String mrName, String mrCategory, int mrImageId, String mrDateStart,
			String mrDateEnd, String mrCenterLat, String mrCenterLng, String mrDate, int mrPlace) {
		super();
		this.mrNo = mrNo;
		this.mrSuperUNo = mrSuperUNo;
		this.mrName = mrName;
		this.mrCategory = mrCategory;
		this.mrImageId = mrImageId;
		this.mrDateStart = mrDateStart;
		this.mrDateEnd = mrDateEnd;
		this.mrCenterLat = mrCenterLat;
		this.mrCenterLng = mrCenterLng;
		this.mrDate = mrDate;
		this.mrPlace = mrPlace;
	}
	public int getMrNo() {
		return mrNo;
	}
	public void setMrNo(int mrNo) {
		this.mrNo = mrNo;
	}
	public int getMrSuperUNo() {
		return mrSuperUNo;
	}
	public void setMrSuperUNo(int mrSuperUNo) {
		this.mrSuperUNo = mrSuperUNo;
	}
	public String getMrName() {
		return mrName;
	}
	public void setMrName(String mrName) {
		this.mrName = mrName;
	}
	public String getMrCategory() {
		return mrCategory;
	}
	public void setMrCategory(String mrCategory) {
		this.mrCategory = mrCategory;
	}
	public int getMrImageId() {
		return mrImageId;
	}
	public void setMrImageId(int mrImageId) {
		this.mrImageId = mrImageId;
	}
	public String getMrDateStart() {
		return mrDateStart;
	}
	public void setMrDateStart(String mrDateStart) {
		this.mrDateStart = mrDateStart;
	}
	public String getMrDateEnd() {
		return mrDateEnd;
	}
	public void setMrDateEnd(String mrDateEnd) {
		this.mrDateEnd = mrDateEnd;
	}
	public String getMrCenterLat() {
		return mrCenterLat;
	}
	public void setMrCenterLat(String mrCenterLat) {
		this.mrCenterLat = mrCenterLat;
	}
	public String getMrCenterLng() {
		return mrCenterLng;
	}
	public void setMrCenterLng(String mrCenterLng) {
		this.mrCenterLng = mrCenterLng;
	}
	public String getMrDate() {
		return mrDate;
	}
	public void setMrDate(String mrDate) {
		this.mrDate = mrDate;
	}
	public int getMrPlace() {
		return mrPlace;
	}
	public void setMrPlace(int mrPlace) {
		this.mrPlace = mrPlace;
	}
	@Override
	public String toString() {
		return "MeetingRoom [mrNo=" + mrNo + ", mrSuperUNo=" + mrSuperUNo + ", mrName=" + mrName + ", mrCategory="
				+ mrCategory + ", mrImageId=" + mrImageId + ", mrDateStart=" + mrDateStart + ", mrDateEnd=" + mrDateEnd
				+ ", mrCenterLat=" + mrCenterLat + ", mrCenterLng=" + mrCenterLng + ", mrDate=" + mrDate + ", mrPlace="
				+ mrPlace + "]";
	}
	
	
}
