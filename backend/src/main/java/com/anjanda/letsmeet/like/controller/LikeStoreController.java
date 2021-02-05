package com.anjanda.letsmeet.like.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.like.service.LikeStoreService;
import com.anjanda.letsmeet.repository.dto.LikeStore;
import com.anjanda.letsmeet.repository.dto.Store;
import com.anjanda.letsmeet.repository.dto.User;

/**
 * 
 * @Date : 2021. 2. 5.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 사용자의 가게 찜 관련 컨트롤러 클래스
 * @Description
 *
 */

@RestController
@RequestMapping("")
public class LikeStoreController {

	/* 찜 서비스 객체 불러오기 */
	@Autowired
	private LikeStoreService likeStoreService;
	
	/* C :: 유저의 가게 찜 추가 */
	@PostMapping("/add")
	public ResponseEntity<String> createLikeStore(@RequestBody Store store, String comment) throws Exception {
		System.out.println("입력 받은 가게 : " + store.getsName() + ", 위도 : " + store.getsLat() + ", 경도 : " + store.getsLng());
		System.out.println("찜가게에 대한 본인 코멘트 : " + comment);
		if(likeStoreService.insertLikeStore(store, comment) > 0) {
			return new ResponseEntity<String>("가게 찜 추가 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("가게 찜 추가 실패", HttpStatus.NO_CONTENT);
	}
	
	/* R :: 유저의 가게 찜 목록 조회 */
	@GetMapping("")
	public ResponseEntity<List<LikeStore>> reviewLikeStore(int uNo) throws Exception {
		return new ResponseEntity<List<LikeStore>> (likeStoreService.selectLikeStore(uNo), HttpStatus.OK);
	}
	
	/* U :: 유저의 가게 찜 코멘트 수정 */
	@PutMapping("/edit")
	public ResponseEntity<String> updateLikeStore(@RequestBody LikeStore likeStore) throws Exception {
		System.out.println("찜가게에 대한 본인 코멘트 수정 전 : " + likeStore.getLsComment());
		if(likeStoreService.updateLikeStore(likeStore)) {
			return new ResponseEntity<String>("찜 가게 코멘트 수정 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("찜 가게 코멘트 수정 실패", HttpStatus.NO_CONTENT);
	}
	
	/* D :: 유저의 가게 찜 삭제 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteLikeStore(@RequestBody LikeStore likeStore) throws Exception {
		System.out.println("삭제할 찜가게 정보 : " + likeStore.getLsSNo() + ", " + likeStore.getLsComment());
		if(likeStoreService.deleteLikeStore(likeStore)) {
			return new ResponseEntity<String>("찜 목록에서 가게 삭제 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("찜 목록에서 가게 삭제 실패", HttpStatus.NO_CONTENT);
	}
}
