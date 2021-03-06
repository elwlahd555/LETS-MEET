package com.anjanda.letsmeet.meetingroom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.meetingroom.service.MeetingRoomService;
import com.anjanda.letsmeet.repository.dto.MeetingRoom;

@RestController
@RequestMapping("")
public class MeetingRoomController {
	
	/* 약속방서비스 객체 불러오기 */
	@Autowired
	private MeetingRoomService meetingRoomService;
	
	/* C :: 미팅룽 추가 */
	@PostMapping("/meetingRoom/create")
	public ResponseEntity<String> createMeetingRoom(@RequestBody MeetingRoom meetingRoom) throws Exception{
		System.out.println(meetingRoom.getMrName()+"이 생성되었습니다");
		System.out.println(meetingRoom.getMrCategory() + meetingRoom.getMrName());
		if(meetingRoomService.createMeetingRoom(meetingRoom) > 0) {
			
			int mrNo=meetingRoomService.selectMeetingRoomBySuper(meetingRoom);
			System.out.println(mrNo+"미팅룸넘버");
			meetingRoomService.createMeetingRoomUser(mrNo,meetingRoom.getMrSuperUNo());
			return new ResponseEntity<String>("약속방 생성 성공", HttpStatus.OK);
		}
			return new ResponseEntity<String>("약속방 생성 실패", HttpStatus.NO_CONTENT);

	}
	
	/* R :: 사용자의 모든 약속방 조회 => 약속 기간 지난 것만 걸러서 따로 리스트 뽑아낼수 있겠지? */
	@GetMapping("/main")
	public ResponseEntity<List<MeetingRoom>> reviewMyMeetingRoom(int uNo) throws Exception {
		return new ResponseEntity<List<MeetingRoom>>(meetingRoomService.reviewMyMeetingRoom(uNo), HttpStatus.OK);
	}
	
	/* R :: 약속방 상세조회 */
	@GetMapping("/meetingRoom/detail")
	public ResponseEntity<MeetingRoom> reviewDetailMeetingRoom(int mrNo) throws Exception {
		return new ResponseEntity<MeetingRoom>(meetingRoomService.reviewDetailMeetingRoom(mrNo), HttpStatus.OK);
	}
	
	/* R :: 캘린더에 표시 될 사용자의 확정된 약속방 조회 */
	@GetMapping("/calendar")
	public ResponseEntity<List<MeetingRoom>> reviewCertainMeetingRoom(int uNo) throws Exception {
		return new ResponseEntity<List<MeetingRoom>>(meetingRoomService.reviewCertainMeetingRoom(uNo), HttpStatus.OK);
	}
	
	/* U :: 약속방 수정 */
	@PutMapping("/meetingRoom/edit")
	public ResponseEntity<String> updateMeetingRoom(@RequestBody MeetingRoom meetingRoom) throws Exception {
		if(meetingRoomService.updateMeetingRoom(meetingRoom)) {
			return new ResponseEntity<String>("약속방 수정 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("약속방 수정 실패", HttpStatus.NO_CONTENT);
	}
	
	/* D :: 약속방 삭제 */
	@DeleteMapping("/meetingRoom/delete")
	public ResponseEntity<String> deleteMeetingRoom(@PathVariable int mrNo) throws Exception {
		if(meetingRoomService.deleteMeetingRoom(mrNo)) {
			return new ResponseEntity<String>("약속방 삭제 성공", HttpStatus.OK);
		}
		return new ResponseEntity<String>("약속방 삭제 실패", HttpStatus.NO_CONTENT);
	}
}