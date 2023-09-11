package com.bootproject.bootproject.root.common;

import com.bootproject.bootproject.root.dto.JwtDTO;
import io.jsonwebtoken.Claims;

import java.util.Date;

public interface JWTProvider {

	Claims setClaims(String us_id);

	String createToken(Claims claims, Date expireDate);

	Claims getClaims(String token);

	Date getExpireDateAccessToken();

	Date getExpireDateRefreshToken();

	JwtDTO createJwt(Claims claims);


}
