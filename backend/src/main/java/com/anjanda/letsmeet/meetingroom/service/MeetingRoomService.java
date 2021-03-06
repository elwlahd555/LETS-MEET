package com.anjanda.letsmeet.meetingroom.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.MeetingRoom;

public interface MeetingRoomService {

	/* C :: 약속방 생성 메소드 */
	int createMeetingRoom(MeetingRoom meetingRoom) throws Exception;

	/* R :: 약속방 전체 조회 */
	List<MeetingRoom> reviewMyMeetingRoom(int uNo) throws Exception;

	/* R :: 약속방 상세 조회 */
	MeetingRoom reviewDetailMeetingRoom(int mrNo) throws Exception;

	/* R :: 캘린더에 표시될 확정된 약속 조회 */
	List<MeetingRoom> reviewCertainMeetingRoom(int uNo) throws Exception;

	/* U :: 약속방 수정 */
	boolean updateMeetingRoom(MeetingRoom meetingRoom) throws Exception;

	/* D :: 약속방 삭제 */
	boolean deleteMeetingRoom(int mrNo) throws Exception;

	//미팅룸에 사람 추가 하기
	int createMeetingRoomUser(int mrNo, int uNo) throws Exception;

	int selectMeetingRoomBySuper(MeetingRoom meetingRoom) throws Exception;

}