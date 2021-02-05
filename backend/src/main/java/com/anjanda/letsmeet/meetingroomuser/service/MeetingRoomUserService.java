package com.anjanda.letsmeet.meetingroomuser.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.MeetingRoomUser;
import com.anjanda.letsmeet.repository.dto.User;

/**
 * 
 * @Date : 2021. 2. 5.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 약속방 구성 멤버 서비스 인터페이스 클래스
 * @Description
 *
 */

public interface MeetingRoomUserService {

	/* C :: 약속방 내 멤버 추가 (일단 모두가 가능하도록..) */
	int createMeetingRoomUser(MeetingRoomUser meetingRoomUser) throws Exception;

	/* R :: 약속방 내 멤버 조회 */
	List<User> reviewMyMeetingRoomUser();

	/* U :: 약속방에 속한 본인의 위치 설정 */
	boolean updateMeetingRoomUserLocation(MeetingRoomUser meetingRoomUser);

	/* U :: 약속방에 속 한 본인의 일정 설정 */
	boolean updateMeetingRoomUserDate(MeetingRoomUser meetingRoomUser);

}