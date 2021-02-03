package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.MeetingRoomChat;

@Mapper
public interface MeetingRoomChatMapper {
	
	List<MeetingRoomChat> selectChatByRno(int mrcMrNo);

}
