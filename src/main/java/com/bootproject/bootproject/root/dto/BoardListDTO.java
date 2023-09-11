package com.bootproject.bootproject.root.dto;

import com.bootproject.bootproject.root.vo.BoardVO;
import lombok.Data;

import java.util.List;

@Data
public class BoardListDTO {
	List<BoardVO> boardList;
}
