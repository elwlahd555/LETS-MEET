package com.anjanda.letsmeet.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.Store;
import com.anjanda.letsmeet.repository.mapper.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService {
	
	/* 가게 매퍼 객체 불러오기 */
	@Autowired
	private StoreMapper mapper;

	/* '동 이름'으로 가게 전체 조회 */
	@Override
	public List<Store> StoreByDong(String dong) throws Exception {
		return mapper.selectStoreByDong(dong);
	}

	/* '좌표 값' 으로 해당 가게 조회 */
	@Override
	public Store StoreByPoint(String lat, String lng) throws Exception {
		// TODO Auto-generated method stub
		return mapper.selectStoreByPoint(lat, lng);
	}

	/* '중간 좌표 값'으로 일정 반경 내 가게들 조회 */
	@Override
	public List<Store> StoreByMidPoint(String lat, String lng) {
		// TODO Auto-generated method stub
		return mapper.selectStoreByMidPoint(lat,lng);
	}
	
	// 가게 등록
	@Override
	public int createStore(Store store) throws Exception {
		// TODO Auto-generated method stub
		return mapper.createStore(store);
	}

}
