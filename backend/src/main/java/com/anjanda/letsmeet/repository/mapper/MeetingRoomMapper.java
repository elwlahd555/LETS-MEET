package com.anjanda.letsmeet.repository.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.MeetingRoom;

@Mapper
public interface MeetingRoomMapper {

	/* C :: 약속방 생성 메소드 */
	public int insertMeetingRoom(MeetingRoom meetingRoom) throws Exception;
	
}
