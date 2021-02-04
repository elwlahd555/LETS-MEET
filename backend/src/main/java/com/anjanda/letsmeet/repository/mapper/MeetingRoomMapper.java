package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.MeetingRoom;

/**
 * 
 * @Date : 2021. 2. 1.
 * @Team : AnJanDa
 * @author : 개발자명
 * @Project : 레쓰밋 :: backend
 * @Function : 약속방 매퍼 인터페이스 클래스
 * @Description
 *	
 */
@Mapper
public interface MeetingRoomMapper {

	/* C :: 약속방 생성 메소드 */
	public int insertMeetingRoom(MeetingRoom meetingRoom) throws Exception;
	
	/* R :: 사용자의 약속방 전체 조회 메소드 */
	public List<MeetingRoom> selectMeetingRoom(int uNo) throws Exception;
	
	/* R :: 약속방 상세 조회 메소드 */
	public MeetingRoom selectMeetingRoomByMrNo(int mrNo) throws Exception;
	
	/* R :: 캘린더에 표시될 날짜 확정된 약속방 조회 메소드 */
	public List<MeetingRoom> selectCertainMeetingRoom(int uNo) throws Exception;
	
	/* U :: 약속방 수정 메소드 */
	public int updateMeetingRoom(MeetingRoom meetingRoom) throws Exception;
	
	/* D :: 약속방 탈퇴 메소드 */
	public int deleteMeetingRoom(int mrNo) throws Exception;

	public int createMeetingRoomUser(int mrNo, int uNo) throws Exception;

	public int selectMeetingRoomBySuper(MeetingRoom meetingRoom) throws Exception;
}
