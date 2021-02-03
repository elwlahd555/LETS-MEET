package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.MeetingRoomUser;
import com.anjanda.letsmeet.repository.dto.User;

@Mapper
public interface MeetingRoomUserMapper {
	/* C :: 약속방 내 멤버 추가 (일단 모두가 가능하도록..) */
	int insertMeetingRoomUser(MeetingRoomUserMapper meetingRoomUser) throws Exception;

	/* R :: 약속방 내 멤버 조회 */
	List<User> selectMyMeetingRoomUser();

	/* U :: 약속방에 속한 본인의 위치 설정 */
	int updateMeetingRoomUserLocation(MeetingRoomUser meetingRoomUser);

	/* U :: 약속방에 속 한 본인의 일정 설정 */
	int updateMeetingRoomUserDate(MeetingRoomUser meetingRoomUser);

}
