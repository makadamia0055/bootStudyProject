package com.bootproject.bootproject.root.filter;

import com.bootproject.bootproject.root.common.AuthHandler;
import com.bootproject.bootproject.root.common.JWTProvider;
import com.bootproject.bootproject.root.dto.AuthenticateUser;
import com.bootproject.bootproject.root.dto.JwtDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.jsonwebtoken.Claims;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component
@RequiredArgsConstructor
public class JwtFilter implements Filter {
	//RequriedArgsConstructor만 있어도 빈으로 등록되고 DI를 처리한다고 함...
	private JWTProvider jwtProvider;
	private AuthHandler authHandler;
	private ObjectMapper objectMapper;
	
	
	
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		Object attribute = request.getAttribute(VerifyUserFilter.AUTHENTICATE_USER);
		if(attribute instanceof AuthenticateUser) {
			// 레퍼런스에서는 패턴매칭 이용했으나 자바 버전이 16이 아니므로 캐스팅으로
			AuthenticateUser authenticateUser = (AuthenticateUser) attribute;
			
			Claims claims =jwtProvider.setClaims(authenticateUser.getUs_id());
			String authenticateUserJson = objectMapper.writeValueAsString(authenticateUser);
			claims.put(VerifyUserFilter.AUTHENTICATE_USER, authenticateUserJson);
			JwtDTO jwtDto = jwtProvider.createJwt(claims);
			// Refresh토큰 등록해주는 과정
			authHandler.registerRefreshTokenID(authenticateUser.getUs_id(), jwtDto.getRefreshToken());
			String json = objectMapper.writeValueAsString(jwtDto);
			response.setContentType("application/json");
			response.setCharacterEncoding("UTF-8");
			response.getWriter().write(json);
					
		}
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
		//httpServletResponse.sendError(HttpStatus.BAD_REQUEST.value());
		chain.doFilter(request, response);

	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

}
