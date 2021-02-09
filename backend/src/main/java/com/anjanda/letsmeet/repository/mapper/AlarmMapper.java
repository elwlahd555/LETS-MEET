package com.anjanda.letsmeet.repository.mapper;

import java.util.List;
import com.anjanda.letsmeet.repository.dto.Alarm;

public interface AlarmMapper {
	/* C :: 알람 1줄 생성 */
	public int insertAlarm(String uEmail) throws Exception;
	
	/* R :: 사용자의 알람 전체 조회 */
	public List<Alarm> selectAlarm(String uEmail) throws Exception;
	
	/* D :: 사용자의 알람 삭제 */
	public boolean deleteAlarm(Alarm alarm) throws Exception;
}