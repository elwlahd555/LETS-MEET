package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anjanda.letsmeet.repository.dto.Store;

public interface StoreMapper {

	public List<Store> getStoreInDong(String dong) throws Exception;

	public Store getStoreInPoint(double lat, double lng) throws Exception;

	public List<Store> getStoreInMidpoint(double lat, double lng);

}
