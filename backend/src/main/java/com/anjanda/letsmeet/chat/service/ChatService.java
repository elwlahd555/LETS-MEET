package com.anjanda.letsmeet.chat.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;

public interface ChatService {
	List<MeetingRoomChat> selectChatByRno(int mrcMrNo);
}
