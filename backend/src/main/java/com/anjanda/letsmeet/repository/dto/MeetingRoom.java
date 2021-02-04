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
}
