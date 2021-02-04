package com.anjanda.letsmeet.repository.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.anjanda.letsmeet.repository.dto.Friend;
import com.anjanda.letsmeet.repository.dto.User;

@Mapper
public interface FriendMapper {
	

	/* C :: 사용자의 친구 추가 */
	public int insertFriend(Friend friend) throws Exception;
	
	/* R :: 사용자의 친구 조회 */
	public List<User> selectFriend(Friend friend) throws Exception;
	
	/* D :: 사용자의 친구 삭제 */
	public int deleteFriend(Friend friend) throws Exception;
}
