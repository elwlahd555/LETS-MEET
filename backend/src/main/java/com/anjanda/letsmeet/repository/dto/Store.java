package com.anjanda.letsmeet.repository.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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

@Getter
@Setter
@ToString
public class Store {
	private int sNo;
	private String sName;
	private String sCategory;
	private String sCategoryDetail;
	private String sRoadAddress;
	private String sNumber;
	private String sPrice;
	private String sTime;
	private String sLat;
	private String sLng;
	private String sImage;
	private double sScore;
	
}