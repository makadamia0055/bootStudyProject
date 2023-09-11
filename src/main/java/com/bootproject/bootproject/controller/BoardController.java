package com.bootproject.bootproject.controller;

import com.bootproject.bootproject.root.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/board")
@Controller
public class BoardController {
	private final BoardService boardService;
	
	@Autowired
	public BoardController(BoardService boardService) {
		this.boardService = boardService;
	}
	
	@GetMapping("/list")
	public String getBoardList(Model md) {
		md.addAttribute("boardList", boardService.getBoardList());
		return "board/boardList.html";
	}
	
	@GetMapping("/write")
	public String getBoardInsert(Model md) {
		return "board/boardInsert.html";
	}
	
	
}
