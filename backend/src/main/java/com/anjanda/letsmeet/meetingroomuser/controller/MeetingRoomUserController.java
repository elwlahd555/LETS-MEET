package com.anjanda.letsmeet.meetingroomuser.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.meetingroom.service.MeetingRoomService;
import com.anjanda.letsmeet.meetingroomuser.service.MeetingRoomUserService;
import com.anjanda.letsmeet.repository.dto.MeetingRoomUser;
import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.user.service.UserService;

/**
 * 
 * @Date : 2021. 2. 4.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 약속방에 구성된 멤버 관련 컨트롤러 클래스
 * @Description
 *	- 추가 수정 필요함
 */
@RestController
@RequestMapping("/meetingRoomUser")
public class MeetingRoomUserController {
	
	/* 약속방에 부를 유저를 위한 객체 불러오기 */
	@Autowired
	private static UserService userService;
	
	/* 약속방 객체 불러오기 (추후 계산을 위한?) */
	@Autowired
	private static MeetingRoomService meetingRoomService;
	
	/* 약속방 유저 객체 불러오기 */
	@Autowired
	private static MeetingRoomUserService meetingRoomUserService;
	
	/* C :: 약속방 내 멤버 추가 (일단 모두가 가능하도록..) */
	@PostMapping("/adduser")
	public ResponseEntity<String> createMeetingRoomUser(@RequestBody MeetingRoomUser user) throws Exception {
		if(meetingRoomUserService.createMeetingRoomUser(user) > 0) {	
			return new ResponseEntity<String>("약속방 내 멤버 추가 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("약속방 내 멤버 추가 실패", HttpStatus.NO_CONTENT);
	}
	
	/* R :: 약속방 내 멤버 조회 */
	@GetMapping("/userInfo")
	public ResponseEntity<List<User>> reviewMyMeetingRoomUser(int mrNo) throws Exception {
		return new ResponseEntity<List<User>>(meetingRoomUserService.reviewMyMeetingRoomUser(mrNo), HttpStatus.OK);
	}
	
	/* U :: 약속방에 속한 본인의 위치 설정 */
	@PutMapping("/settings/location")
	public ResponseEntity<String> updateMeetingRoomUserLocation(@RequestBody MeetingRoomUser meetingRoomUser){
		if(meetingRoomUserService.updateMeetingRoomUserLocation(meetingRoomUser)) {
			return new ResponseEntity<String>("약속방의 본인 위치 설정 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("약속방의 본인 위치 설정 실패", HttpStatus.NO_CONTENT);
	}
	
	/* U :: 약속방에 속 한 본인의 일정 설정 */
	@PutMapping("/user/settings/date")
	public ResponseEntity<String> updateMeetingRoomUserDate(@RequestBody MeetingRoomUser meetingRoomUser){
		if(meetingRoomUserService.updateMeetingRoomUserDate(meetingRoomUser)) {
			return new ResponseEntity<String>("약속방의 본인 일정 설정 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("약속방의 본인 일정 설정 실 패", HttpStatus.NO_CONTENT);
	}
}
