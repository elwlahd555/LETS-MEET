package com.anjanda.letsmeet.meetingroomuser.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.MeetingRoomUser;
import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.repository.mapper.MeetingRoomUserMapper;

@Service
public class MeetingRoomUserServiceImpl implements MeetingRoomUserService {

	/* 미팅룸 매퍼 객체 불러오기 */
	@Autowired
	private static MeetingRoomUserMapper meetingRoomUserMapper;
	
	/* C :: 약속방 내 멤버 추가 (일단 모두가 가능하도록..) */
	@Override
	public int createMeetingRoomUser(MeetingRoomUser meetingRoomUser) throws Exception {
		return meetingRoomUserMapper.insertMeetingRoomUser(meetingRoomUserMapper);
	}
	
	/* R :: 약속방 내 멤버 조회 */
	@Override
	public List<User> reviewMyMeetingRoomUser() {
		return meetingRoomUserMapper.selectMyMeetingRoomUser();
	}
	
	/* U :: 약속방에 속한 본인의 위치 설정 */
	@Override
	public boolean updateMeetingRoomUserLocation(MeetingRoomUser meetingRoomUser) {
		return meetingRoomUserMapper.updateMeetingRoomUserLocation(meetingRoomUser) == 1;
	}
	
	/* U :: 약속방에 속 한 본인의 일정 설정 */
	@Override
	public boolean updateMeetingRoomUserDate(MeetingRoomUser meetingRoomUser) {
		return meetingRoomUserMapper.updateMeetingRoomUserDate(meetingRoomUser) == 1;
	}
}
