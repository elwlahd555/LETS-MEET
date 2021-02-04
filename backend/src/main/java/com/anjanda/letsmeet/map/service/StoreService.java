package com.anjanda.letsmeet.map.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.Store;

public interface StoreService {

	/* '동 이름'으로 가게 전체 조회 */
	List<Store> StoreByDong(String dong) throws Exception;

	/* '좌표 값' 으로 해당 가게 조회 */
	Store StoreByPoint(String lat, String lng) throws Exception;

	/* '중간 좌표 값'으로 일정 반경 내 가게들 조회 */
	List<Store> StoreByMidPoint(String lat, String lng);
	
	/* C :: 가게 등록 메소드 */
	int createStore(Store store) throws Exception;

}