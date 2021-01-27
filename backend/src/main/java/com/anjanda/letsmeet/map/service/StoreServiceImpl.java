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
	public List<Store> getStore(String dong) throws Exception {
		return mapper.getStore(dong);
	}

}
