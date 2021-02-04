package com.anjanda.letsmeet.friend.service;

import java.util.List;

import com.anjanda.letsmeet.repository.dto.User;

public interface FriendService {

	/* C :: 사용자의 친구 추가 */
	int createFriend(int me, User user) throws Exception;

	/* R :: 사용자의 친구 조회 */
	List<User> reviewFriend(User user) throws Exception;

	/* D :: 사용자의 친구 삭제 */
	boolean deleteFriend(int me, User user) throws Exception;

}