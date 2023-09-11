package com.bootproject.bootproject.root.service;


import com.bootproject.bootproject.root.dto.BoardListDTO;
import com.bootproject.bootproject.root.dto.InsertBoardDTO;

public interface BoardService {

	BoardListDTO getBoardList();

	void insertBoard(InsertBoardDTO boardDto);

}
