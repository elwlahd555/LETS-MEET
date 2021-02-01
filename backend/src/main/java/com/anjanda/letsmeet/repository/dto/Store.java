package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Store {
	private int sNo;
	private String sName;
	private String sCategory;
	private String sDong;
	private String sRoadNmae;
	private String sBunjiMain;
	private String sBunjiSub;
	private String sBuildingName;
	private String sLat;
	private String sLng;
	private int sImageId;
	private int sReview;
	public Store() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Store(int sNo, String sName, String sCategory, String sDong, String sRoadNmae, String sBunjiMain,
			String sBunjiSub, String sBuildingName, String sLat, String sLng, int sImageId, int sReview) {
		super();
		this.sNo = sNo;
		this.sName = sName;
		this.sCategory = sCategory;
		this.sDong = sDong;
		this.sRoadNmae = sRoadNmae;
		this.sBunjiMain = sBunjiMain;
		this.sBunjiSub = sBunjiSub;
		this.sBuildingName = sBuildingName;
		this.sLat = sLat;
		this.sLng = sLng;
		this.sImageId = sImageId;
		this.sReview = sReview;
	}
	public int getsNo() {
		return sNo;
	}
	public void setsNo(int sNo) {
		this.sNo = sNo;
	}
	public String getsName() {
		return sName;
	}
	public void setsName(String sName) {
		this.sName = sName;
	}
	public String getsCategory() {
		return sCategory;
	}
	public void setsCategory(String sCategory) {
		this.sCategory = sCategory;
	}
	public String getsDong() {
		return sDong;
	}
	public void setsDong(String sDong) {
		this.sDong = sDong;
	}
	public String getsRoadNmae() {
		return sRoadNmae;
	}
	public void setsRoadNmae(String sRoadNmae) {
		this.sRoadNmae = sRoadNmae;
	}
	public String getsBunjiMain() {
		return sBunjiMain;
	}
	public void setsBunjiMain(String sBunjiMain) {
		this.sBunjiMain = sBunjiMain;
	}
	public String getsBunjiSub() {
		return sBunjiSub;
	}
	public void setsBunjiSub(String sBunjiSub) {
		this.sBunjiSub = sBunjiSub;
	}
	public String getsBuildingName() {
		return sBuildingName;
	}
	public void setsBuildingName(String sBuildingName) {
		this.sBuildingName = sBuildingName;
	}
	public String getsLat() {
		return sLat;
	}
	public void setsLat(String sLat) {
		this.sLat = sLat;
	}
	public String getsLng() {
		return sLng;
	}
	public void setsLng(String sLng) {
		this.sLng = sLng;
	}
	public int getsImageId() {
		return sImageId;
	}
	public void setsImageId(int sImageId) {
		this.sImageId = sImageId;
	}
	public int getsReview() {
		return sReview;
	}
	public void setsReview(int sReview) {
		this.sReview = sReview;
	}
	@Override
	public String toString() {
		return "Store [sNo=" + sNo + ", sName=" + sName + ", sCategory=" + sCategory + ", sDong=" + sDong
				+ ", sRoadNmae=" + sRoadNmae + ", sBunjiMain=" + sBunjiMain + ", sBunjiSub=" + sBunjiSub
				+ ", sBuildingName=" + sBuildingName + ", sLat=" + sLat + ", sLng=" + sLng + ", sImageId=" + sImageId
				+ ", sReview=" + sReview + "]";
	}
	
	
}