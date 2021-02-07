package com.anjanda.letsmeet.friend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.anjanda.letsmeet.repository.dto.User;
import com.anjanda.letsmeet.repository.mapper.FriendMapper;

/**
 * 
 * @Date : 2021. 2. 4.
 * @Team : AnJanDa
 * @author : 김지현
 * @deploy : 김동빈
 * @Project : 레쓰밋 :: backend
 * @Function : 친구 관련 서비스 클래스
 * @Description
 *
 */

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendMapper friendMapper;
	
	/* C :: 사용자의 친구 추가 */
	@Override
	public int createFriend(int me, User user) throws Exception {
		return friendMapper.insertFriend(me, user);
	}
	
	/* R :: 사용자의 친구 조회 */
	@Override
	public List<User> reviewFriend(User user) throws Exception {
		return friendMapper.selectFriend(user);
	}
	
	/* R :: 사용자가 검색한 친구 목록 */
	@Override
	public List<User> reviewSearchFriend(String uEmail) throws Exception {
		return friendMapper.selectSearchFriend(uEmail);
	}
	
	/* D :: 사용자의 친구 삭제 */
	@Override
	public boolean deleteFriend(int me, User user) throws Exception {
		return friendMapper.deleteFriend(me, user) == 1;
	}
}
