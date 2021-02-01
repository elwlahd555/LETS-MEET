package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.anjanda.letsmeet.repository.dto.Store;
/**
 * 
 * @Date 2021. 2. 1.
 * @Team AnJanDa
 * @author 개발자명
 * @Project : backend
 * @Function :
 * @Description : 
 *
 */
public interface StoreMapper {

	/* '동 이름'으로 가게 전체 조회 */
	public List<Store> selectStoreByDong(String dong) throws Exception;

	/* '좌표 값' 으로 해당 가게 조회 */
	public Store selectStoreByPoint(String lat, String lng) throws Exception;

	/* '중간 좌표 값'으로 일정 반경 내 가게들 조회 */
	public List<Store> selectStoreByMidPoint(String lat, String lng);

}
