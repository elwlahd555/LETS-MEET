package com.anjanda.letsmeet.map.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.Store;

public interface StoreService {
	
	List<Store> getStore(String dong);
}
