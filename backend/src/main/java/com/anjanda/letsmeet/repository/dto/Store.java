package com.anjanda.letsmeet.repository.dto;

public class Store {

	private int sNo;
	private String sName;
	private String sCategory;
	private String sDetailCategory;
	private String sDong;
	private String sRoad;
	private int sMainBungee;
	private int sSubBungee;
	private String sBuilding;
	private String sRoadadress;
	private int sLat;
	private int sLng;
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
	public String getsDetailCategory() {
		return sDetailCategory;
	}
	public void setsDetailCategory(String sDetailCategory) {
		this.sDetailCategory = sDetailCategory;
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
	public int getsMainBungee() {
		return sMainBungee;
	}
	public void setsMainBungee(int sMainBungee) {
		this.sMainBungee = sMainBungee;
	}
	public int getsSubBungee() {
		return sSubBungee;
	}
	public void setsSubBungee(int sSubBungee) {
		this.sSubBungee = sSubBungee;
	}
	public String getsBuilding() {
		return sBuilding;
	}
	public void setsBuilding(String sBuilding) {
		this.sBuilding = sBuilding;
	}
	public String getsRoadadress() {
		return sRoadadress;
	}
	public void setsRoadadress(String sRoadadress) {
		this.sRoadadress = sRoadadress;
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
	public int getsScore() {
		return sScore;
	}
	public void setsScore(int sScore) {
		this.sScore = sScore;
	}
	@Override
	public String toString() {
		return "Store [sNo=" + sNo + ", sName=" + sName + ", sCategory=" + sCategory + ", sDetailCategory="
				+ sDetailCategory + ", sDong=" + sDong + ", sRoad=" + sRoad + ", sMainBungee=" + sMainBungee
				+ ", sSubBungee=" + sSubBungee + ", sBuilding=" + sBuilding + ", sRoadadress=" + sRoadadress + ", sLat="
				+ sLat + ", sLng=" + sLng + ", sScore=" + sScore + "]";
	}
	
	
	
	
}
