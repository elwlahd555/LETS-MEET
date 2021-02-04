package com.anjanda.letsmeet.chat.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.anjanda.letsmeet.chat.service.MeetingRoomChatService;
import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;

@RestController
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private MeetingRoomChatService chatservice;
	
	@GetMapping("/open")
	public List<MeetingRoomChat> selectChatByRno(int mrcMrNo) throws Exception{
		System.out.println(mrcMrNo);
		return chatservice.selectChatByRno(mrcMrNo);
	}
	
	@GetMapping("/create")
	public int createChat(MeetingRoomChat meetingRoomChat)throws Exception{
		
		return chatservice.createMeetingRoomChat(meetingRoomChat);
	}
	
}
