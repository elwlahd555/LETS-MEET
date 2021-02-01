package com.anjanda.letsmeet.map.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.map.service.StoreService;
import com.anjanda.letsmeet.repository.dto.Store;

import io.swagger.annotations.ApiOperation;

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

@RestController
@RequestMapping(value="/map")
public class StoreController {

	/* 가게 객체 불러오기 */
	@Autowired
	private StoreService storeService;
	
	/* '동 이름'으로 가게 조회하기 */
	@ApiOperation(value="전체 동 조회", notes="동을 이용해서 조회")
	@GetMapping("/dong")
	public List<Store> reviewStoreByDong(String dong) {
		try {
			System.out.println("dong값 받아오기");
			System.out.println("data size : " + storeService.reviewStoreByDong(dong).size());
			System.out.println("data size : " + storeService.reviewStoreByDong(dong).get(0).getsDong());
			
			return storeService.reviewStoreByDong(dong);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/* '좌표 값'으로 가게 조회하기 */
	@ApiOperation(value="좌표로 조회", notes="좌표를 이용해서 조회")
	@GetMapping("/point")
	public Store reviewStoreByPoint(String lat, String lng) {
		try {
			System.out.println("좌표값 받아오기");
			System.out.println("data name : " + storeService.reviewStoreByPoint(lat,lng).getsName());
			
			return storeService.reviewStoreByPoint(lat,lng);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/* '중간 좌표 값' 으로 반경 내 가게 조회하기 */ // 나중에 알고리즘 이부분 추가해서 강,바다 걸러준다거나 일정 알고리즘 적용하면 될듯??
	@ApiOperation(value="중간 좌표로 조회", notes="중간 좌표를 이용해서 조회")
	@GetMapping("/midpoint")
	public List<Store> reviewStoreByMidPoint(String lat, String lng) {
		try {
			System.out.println("중간 좌표값 받아오기");
			System.out.println("data size : " + storeService.reviewStoreByMidPoint(lat,lng).size());
			System.out.println("data size : " + storeService.reviewStoreByMidPoint(lat,lng).get(0).getsName());

			return storeService.reviewStoreByMidPoint(lat,lng);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
