package com.bootproject.bootproject.root.service;


import com.bootproject.bootproject.root.dto.LoginUserDTO;
import com.bootproject.bootproject.root.dto.RegisterUserDTO;
import com.bootproject.bootproject.root.dto.UserVerifyResponseDTO;
import com.bootproject.bootproject.root.vo.UserVO;

public interface UserService {

	
	boolean insertUser(RegisterUserDTO user);

	UserVO getUser(UserVO user);

	void deleteAllUser();
	
	int countAllUser();

	UserVO getUserById(String us_id);

	UserVerifyResponseDTO checkUser(LoginUserDTO user);
}
