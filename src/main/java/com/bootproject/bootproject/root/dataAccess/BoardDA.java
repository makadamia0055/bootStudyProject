package com.bootproject.bootproject.root.dataAccess;

import com.bootproject.bootproject.root.dto.InsertBoardDTO;
import com.bootproject.bootproject.root.entity.Board;

import java.util.List;

public interface BoardDA {

	void insertBoard(InsertBoardDTO boardDto);

	List<Board> getBoardList();

}
