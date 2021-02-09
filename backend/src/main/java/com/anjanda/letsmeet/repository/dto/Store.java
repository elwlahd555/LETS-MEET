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

public class Store {
	private int sNo;
	private String sName;
	private String sCategory;
	private String sDong;
	private String sRoad;
	private String sBunjiMain;
	private String sBunjiSub;
	private String sBuildingName;
	private String sRoadAddress;
	private String sLat;
	private String sLng;
	private String sImage;
	private double sScore;
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
	public String getsImage() {
		return sImage;
	}
	public void setsImage(String sImage) {
		this.sImage = sImage;
	}
	public double getsScore() {
		return sScore;
	}
	public void setsScore(double sScore) {
		this.sScore = sScore;
	}
}