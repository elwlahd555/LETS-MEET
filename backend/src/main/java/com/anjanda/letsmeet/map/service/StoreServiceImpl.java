package com.anjanda.letsmeet.map.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.Store;
import com.anjanda.letsmeet.repository.mapper.StoreMapper;

@Service
public class StoreServiceImpl implements StoreService {

	@Autowired
	private StoreMapper mapper;
	
	@Override
	public List<Store> getStoreInDong(String dong) throws Exception {
		return mapper.getStoreInDong(dong);
	}

	@Override
	public Store getStoreInPoint(double lat, double lng) throws Exception {
		// TODO Auto-generated method stub
		return mapper.getStoreInPoint(lat,lng);
	}

	@Override
	public List<Store> getStoreInMidpoint(double lat, double lng) {
		// TODO Auto-generated method stub
		return mapper.getStoreInMidpoint(lat,lng);
	}

}
