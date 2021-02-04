package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;


public interface MeetingRoomChatMapper {
	
	List<MeetingRoomChat> selectChatByRno(int mrcMrNo) throws Exception;

	int createMeetingRoomChat(MeetingRoomChat meetingRoomChat) throws Exception;

}
