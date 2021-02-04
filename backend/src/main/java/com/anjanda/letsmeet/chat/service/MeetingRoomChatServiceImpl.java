package com.anjanda.letsmeet.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;
import com.anjanda.letsmeet.repository.mapper.MeetingRoomChatMapper;

@Service
public class MeetingRoomChatServiceImpl implements MeetingRoomChatService {

	@Autowired
	private MeetingRoomChatMapper mapper;
	
	
	@Override
	public List<MeetingRoomChat> selectChatByRno(int mrcMrNo) throws Exception {
		return mapper.selectChatByRno(mrcMrNo);
	}


	@Override
	public int createMeetingRoomChat(MeetingRoomChat meetingRoomChat) throws Exception {
		return mapper.createMeetingRoomChat(meetingRoomChat);
	}

}
