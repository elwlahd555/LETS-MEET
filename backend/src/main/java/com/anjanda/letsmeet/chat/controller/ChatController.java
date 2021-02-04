package com.anjanda.letsmeet.chat.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.anjanda.letsmeet.chat.service.ChatService;
import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;

@Controller
@RequestMapping("/chat")
public class ChatController {

	@Autowired
	private ChatService chatservice;
	
	@GetMapping("/open")
	public List<MeetingRoomChat> selectChatByRno(HttpSession session){
		int mrNo=(int)session.getAttribute("mrNo");
		System.out.println(mrNo);
		return chatservice.selectChatByRno(mrNo);
	}
	
}
