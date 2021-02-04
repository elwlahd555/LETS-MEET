package com.anjanda.letsmeet.meetingroom.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.MeetingRoom;

public interface MeetingRoomService {

	/* C :: 약속방 생성 메소드 */
	public int createMeetingRoom(MeetingRoom meetingRoom) throws Exception;

	/* R :: 약속방 전체 조회 */
	public List<MeetingRoom> reviewMyMeetingRoom(int uNo);

	/* R :: 약속방 상세 조회 */
	public MeetingRoom reviewDetailMeetingRoom(int mrNo);

	/* U :: 약속방 수정 */ // @Transcational ???
	public boolean updateMeetingRoom(MeetingRoom meetingRoom);

	/* D :: 약속방 삭제 */
	public boolean deleteMeetingRoom(int mrNo);
	
	//미팅방유저추가
	public int createMeetingRoomUser(int uNo);

}