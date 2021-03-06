package com.anjanda.letsmeet.chat.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.anjanda.letsmeet.chat.service.MeetingRoomChatService;
import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;

@Controller
public class SocketController {
	@Autowired
	private MeetingRoomChatService chatservice;

    // /receive를 메시지를 받을 endpoint로 설정합니다.
    @MessageMapping("/receive")

    // /send로 메시지를 반환합니다.
    @SendTo("/send")
    

    // SocketHandler는 1) /receive에서 메시지를 받고, /send로 메시지를 보내줍니다.
    // 정의한 SocketVO를 1) 인자값, 2) 반환값으로 사용합니다.
    public MeetingRoomChat SocketHandler(MeetingRoomChat meetingRoomChat) throws Exception {
        // vo에서 getter로 userName을 가져옵니다.
        int userNo = meetingRoomChat.getMrcUNo();
        // vo에서 setter로 content를 가져옵니다.
        String content = meetingRoomChat.getMrcContent();
        int mrNo=meetingRoomChat.getMrcMrNo();
        //        int uNo=(int) session.getAttribute("uNo");
        // 생성자로 반환값을 생성합니다.
        MeetingRoomChat result = new MeetingRoomChat();
        
        System.out.println(userNo);
        System.out.println(content);
        System.out.println(mrNo);
        
        result.setMrcContent(content);
        result.setMrcUNo(userNo);
        result.setMrcMrNo(1);
        
        chatservice.createMeetingRoomChat(result);
        // 반환
        return result;
    }
}
