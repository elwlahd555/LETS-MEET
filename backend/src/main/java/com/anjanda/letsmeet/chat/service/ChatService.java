package com.anjanda.letsmeet.chat.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;

public interface ChatService {
	List<MeetingRoomChat> selectChatByRno(int mrcMrNo);
	
	/* C :: 약속방 채팅 추가 생성 메소드 */
	int createMeetingRoomChat(MeetingRoomChat meetingRoomChat);
}
