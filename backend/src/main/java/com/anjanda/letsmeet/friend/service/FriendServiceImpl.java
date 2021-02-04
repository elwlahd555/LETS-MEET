package com.anjanda.letsmeet.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.Friend;
import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.repository.mapper.FriendMapper;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendMapper friendMapper;
	
	/* C :: 사용자의 친구 추가 */
	@Override
	public int createFriend(Friend friend) throws Exception {
		return friendMapper.insertFriend(friend);
	}
	
	/* R :: 사용자의 친구 조회 */
	@Override
	public List<User> reviewFriend(Friend friend) throws Exception {
		return friendMapper.selectFriend(friend);
	}
	
	/* D :: 사용자의 친구 삭제 */
	@Override
	public boolean deleteFriend(Friend friend) throws Exception {
		return friendMapper.deleteFriend(friend) == 1;
	}
}
