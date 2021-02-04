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
public class StoreReview {
	int srNo;
	int srSNo;
	int srUNo;
	String srContent;
	public StoreReview() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StoreReview(int srNo, int srSNo, int srUNo, String srContent) {
		super();
		this.srNo = srNo;
		this.srSNo = srSNo;
		this.srUNo = srUNo;
		this.srContent = srContent;
	}
	public int getSrNo() {
		return srNo;
	}
	public void setSrNo(int srNo) {
		this.srNo = srNo;
	}
	public int getSrSNo() {
		return srSNo;
	}
	public void setSrSNo(int srSNo) {
		this.srSNo = srSNo;
	}
	public int getSrUNo() {
		return srUNo;
	}
	public void setSrUNo(int srUNo) {
		this.srUNo = srUNo;
	}
	public String getSrContent() {
		return srContent;
	}
	public void setSrContent(String srContent) {
		this.srContent = srContent;
	}
	@Override
	public String toString() {
		return "StoreReview [srNo=" + srNo + ", srSNo=" + srSNo + ", srUNo=" + srUNo + ", srContent=" + srContent + "]";
	}
	
	
}
