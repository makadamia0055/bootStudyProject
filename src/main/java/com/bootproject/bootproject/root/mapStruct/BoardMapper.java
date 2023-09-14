package com.bootproject.bootproject.root.mapStruct;


import com.bootproject.bootproject.root.dto.InsertBoardDTO;
import com.bootproject.bootproject.root.entity.Board;
import com.bootproject.bootproject.root.vo.BoardVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", uses = {UserMapper.class, CategoryMapper.class})
public interface BoardMapper {
	BoardMapper INSTANCE = Mappers.getMapper(BoardMapper.class);
	
	Board toEntity(InsertBoardDTO insertBoardDto);
	
	BoardVO toVO(Board board);


}
