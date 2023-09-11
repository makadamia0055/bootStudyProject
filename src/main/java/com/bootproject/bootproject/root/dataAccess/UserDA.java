package com.bootproject.bootproject.root.dataAccess;


import com.bootproject.bootproject.root.entity.User;

import java.util.List;

public interface UserDA {

	User getUser(String user);
	
	void insertUser(User user);

	List<User> getAllUser();
	
	void deleteAllUser();

	int countAllUser();

	boolean isNickNameDuplicated(String us_nickname);


}
