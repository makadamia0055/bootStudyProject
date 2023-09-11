package com.bootproject.bootproject.root.dataAccess;


import com.bootproject.bootproject.root.dto.InsertBoardDTO;
import com.bootproject.bootproject.root.entity.Board;
import com.bootproject.bootproject.root.mapStruct.BoardMapper;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Repository
public class BoardRepository implements BoardDA {
	@PersistenceContext
	EntityManager em;

	@Override
	public void insertBoard(InsertBoardDTO boardDto) {
		Board board = BoardMapper.INSTANCE.toEntity(boardDto);
        em.persist(board);

	}

	@Override
	public List<Board> getBoardList() {
		String jpql = "select b from Board b order by b.bo_num desc";
        List<Board> boardList = em.createQuery(jpql, Board.class).getResultList();
        return boardList;
	}
	
}
