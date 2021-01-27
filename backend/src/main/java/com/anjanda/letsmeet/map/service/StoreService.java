package com.anjanda.letsmeet.map.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.Store;

public interface StoreService {
	
	List<Store> getStoreInDong(String dong) throws Exception;

	Store getStoreInPoint(double lat, double lng) throws Exception;

	List<Store> getStoreInMidpoint(double lat, double lng);
}
