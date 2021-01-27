package com.anjanda.letsmeet.repository.dto;

public class Store {

	private int sNo;
	private String sName;
	private String sCategory;
	private String sDong;
	private String sRoad;
	private int sBungeeMain;
	private int sBungeeSub;
	private String sBuilding;
	private String sRoadAddress;
	private int sLat;
	private int sLng;
	private String sImg;
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
	public int getsBungeeMain() {
		return sBungeeMain;
	}
	public void setsBungeeMain(int sBungeeMain) {
		this.sBungeeMain = sBungeeMain;
	}
	public int getsBungeeSub() {
		return sBungeeSub;
	}
	public void setsBungeeSub(int sBungeeSub) {
		this.sBungeeSub = sBungeeSub;
	}
	public String getsBuilding() {
		return sBuilding;
	}
	public void setsBuilding(String sBuilding) {
		this.sBuilding = sBuilding;
	}
	public String getsRoadAddress() {
		return sRoadAddress;
	}
	public void setsRoadAddress(String sRoadAddress) {
		this.sRoadAddress = sRoadAddress;
	}
	public int getsLat() {
		return sLat;
	}
	public void setsLat(int sLat) {
		this.sLat = sLat;
	}
	public int getsLng() {
		return sLng;
	}
	public void setsLng(int sLng) {
		this.sLng = sLng;
	}
	public String getsImg() {
		return sImg;
	}
	public void setsImg(String sImg) {
		this.sImg = sImg;
	}
	public int getsScore() {
		return sScore;
	}
	public void setsScore(int sScore) {
		this.sScore = sScore;
	}
	@Override
	public String toString() {
		return "Store [sNo=" + sNo + ", sName=" + sName + ", sCategory=" + sCategory + ", sDong=" + sDong + ", sRoad="
				+ sRoad + ", sBungeeMain=" + sBungeeMain + ", sBungeeSub=" + sBungeeSub + ", sBuilding=" + sBuilding
				+ ", sRoadAddress=" + sRoadAddress + ", sLat=" + sLat + ", sLng=" + sLng + ", sImg=" + sImg
				+ ", sScore=" + sScore + "]";
	}
	
	
	
}
