package com.anjanda.letsmeet.friend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.friend.service.FriendService;
import com.anjanda.letsmeet.repository.dto.Friend;
import com.anjanda.letsmeet.repository.dto.User;

@RestController
@RequestMapping("")
public class FriendController {

	/* Friend 서비스 객체 불러오기 */
	@Autowired
	private static FriendService friendService;
	
	/* C :: 사용자의 친구 추가 */
	@PostMapping("")
	public ResponseEntity<String> createFriend(@RequestBody Friend friend) throws Exception {
		System.out.println("친구 신청자 : " + friend.getfSendUNo() + ", 친구 받은자 : " + friend.getfRecvUNo());
		
		if(friendService.createFriend(friend) > 0) {
			return new ResponseEntity<String>("친구 추가 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("친구 추가 실패", HttpStatus.NO_CONTENT);
	}
	
	/* R :: 사용자의 친구 목록 조회*/
	@GetMapping("")
	public ResponseEntity<List<User>> reviewFriend(@RequestBody Friend friend) throws Exception {
		return new ResponseEntity<List<User>>(friendService.reviewFriend(friend), HttpStatus.OK);
	}
	
	/* D :: 사용자의 친구 삭제 */
	@DeleteMapping("")
	public ResponseEntity<String> deleteFriend(@RequestBody Friend friend) throws Exception{
		if(friendService.deleteFriend(friend)) {
			return new ResponseEntity<String>("친구 삭제 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("친구 삭제 실패", HttpStatus.NO_CONTENT);
	}
}
