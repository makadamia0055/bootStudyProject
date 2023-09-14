package com.bootproject.bootproject.root.mapStruct;


import com.bootproject.bootproject.root.dto.LoginUserDTO;
import com.bootproject.bootproject.root.dto.RegisterUserDTO;
import com.bootproject.bootproject.root.entity.User;
import com.bootproject.bootproject.root.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface UserMapper {
	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User toEntity(LoginUserDTO userDTO);
	
	User toEntity(RegisterUserDTO userDTO);
	  
	User toEntity(UserVO userVO);

	UserVO toVO(User user);
	
}
