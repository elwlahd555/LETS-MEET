package com.anjanda.letsmeet.chat.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;
import com.anjanda.letsmeet.repository.mapper.MeetingRoomChatMapper;

@Service
public class ChatServiceImpl implements ChatService {

	@Autowired
	private static MeetingRoomChatMapper mapper;
	
	
	@Override
	public List<MeetingRoomChat> selectChatByRno(int mrcMrNo) {
		// TODO Auto-generated method stub
		return mapper.selectChatByRno(mrcMrNo);
	}

}
