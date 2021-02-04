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
	public List<MeetingRoom> selectMeetingRoom(int uNo);
	
	/* R :: 약속방 상세 조회 메소드 */
	public MeetingRoom selectMeetingRoomByMrNo(int mrNo);
	
	/* U :: 약속방 수정 메소드 */
	public int updateMeetingRoom(MeetingRoom meetingRoom);
	
	/* D :: 약속방 탈퇴 메소드 */
	public int deleteMeetingRoom(int mrNo);

	public int createMeetingRoomUser(int mrNo, int uNo);

	public int selectMeetingRoomBySuper(MeetingRoom meetingRoom);
}
