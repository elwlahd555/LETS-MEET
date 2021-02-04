package com.anjanda.letsmeet.meetingroom.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.MeetingRoom;

public interface MeetingRoomService {

	/* C :: 약속방 생성 메소드 */
	void createMeetingRoom(MeetingRoom meetingRoom) throws Exception;

	/* R :: 약속방 전체 조회 */
	List<MeetingRoom> reviewMyMeetingRoom();

	/* R :: 약속방 상세 조회 */
	MeetingRoom reviewDetailMeetingRoom(int mrNo);

	/* U :: 약속방 수정 */ // @Transcational ???
	boolean updateMeetingRoom(MeetingRoom meetingRoom);

	/* D :: 약속방 삭제 */
	boolean deleteMeetingRoom(int mrNo);

}