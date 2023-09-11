package com.bootproject.bootproject.root.common;


import com.bootproject.bootproject.root.dto.JwtDTO;

public interface AuthHandler {

	void registerRefreshTokenID(String us_id, String refreshToken);

	JwtDTO checkRefreshToken(JwtDTO jwtDto);

	JwtDTO checkAccessToken(JwtDTO jwtDto);


	

}
