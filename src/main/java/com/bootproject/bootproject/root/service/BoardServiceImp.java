package com.bootproject.bootproject.root.service;


import com.bootproject.bootproject.root.dataAccess.BoardDA;
import com.bootproject.bootproject.root.dto.BoardListDTO;
import com.bootproject.bootproject.root.dto.InsertBoardDTO;
import com.bootproject.bootproject.root.entity.Board;
import com.bootproject.bootproject.root.mapStruct.BoardMapper;
import com.bootproject.bootproject.root.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BoardServiceImp implements BoardService {
	
	BoardDA boardDa;
	
	@Autowired
	public BoardServiceImp(BoardDA boardDa) {
		this.boardDa = boardDa;
	}
	@Override
	public void insertBoard(InsertBoardDTO boardDto) {
		//validation 나중에 추가
		boardDa.insertBoard(boardDto);
        
	}
	@Override
	public BoardListDTO getBoardList(){
		List<Board> entityList = boardDa.getBoardList();
		
		List<BoardVO> boardList = new ArrayList<BoardVO>();
		for(Board tmp: entityList) {
			boardList.add(BoardMapper.INSTANCE.toVO(tmp));
		}
		
		BoardListDTO blDto = new BoardListDTO();
		blDto.setBoardList(boardList);
		return blDto;
        
       
	}
}
