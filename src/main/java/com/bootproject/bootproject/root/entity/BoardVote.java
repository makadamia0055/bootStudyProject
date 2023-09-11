package com.bootproject.bootproject.root.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="bv_boardvote")
@Data
@NoArgsConstructor
public class BoardVote {
	@Id
	@GeneratedValue
	private int bv_num;
	private int bv_state;
	
	@ManyToOne
	@JoinColumn(name="bv_bo_num")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="bv_us_id")
	private User user;
	
	public void setBoard(Board board) {
		this.board = board;
		board.getBoardVoteList().add(this);
	}
	
	public void setUser(User user) {
		this.user = user;
		user.getBoardVoteList().add(this);
	}
}
