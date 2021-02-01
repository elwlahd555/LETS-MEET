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
	private String sRoad;
	private String sBungeeMain;
	private String sBungeeSub;
	private String sBuilding;
	private String sRoadAddress;
	private String sLat;
	private String sLng;
	private int sImg;
	private int sScore;
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
	public String getsRoad() {
		return sRoad;
	}
	public void setsRoad(String sRoad) {
		this.sRoad = sRoad;
	}
	public String getsBungeeMain() {
		return sBungeeMain;
	}
	public void setsBungeeMain(String sBungeeMain) {
		this.sBungeeMain = sBungeeMain;
	}
	public String getsBungeeSub() {
		return sBungeeSub;
	}
	public void setsBungeeSub(String sBungeeSub) {
		this.sBungeeSub = sBungeeSub;
	}
	public String getsBunjiSub() {
		return sBunjiSub;
	}
	public void setsBunjiSub(String sBunjiSub) {
		this.sBunjiSub = sBunjiSub;
	}
	public String getsRoadAddress() {
		return sRoadAddress;
	}
	public void setsRoadAddress(String sRoadAddress) {
		this.sRoadAddress = sRoadAddress;
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
	public int getsImg() {
		return sImg;
	}
	public void setsImg(int sImg) {
		this.sImg = sImg;
	}
	public int getsScore() {
		return sScore;
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
	
	
	
	
}