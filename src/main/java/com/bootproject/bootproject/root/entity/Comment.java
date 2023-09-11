package com.bootproject.bootproject.root.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="cm_comment")
@Data
@NoArgsConstructor
public class Comment {
	@Id
	@GeneratedValue
	private int cm_num;
	@Temporal(TemporalType.TIMESTAMP)
	private Date cm_date;
	private String cm_content;
	private int cm_state;
	
	@ManyToOne
	@JoinColumn(name="cm_bo_num")
	private Board board;
	
	@ManyToOne
	@JoinColumn(name="cm_us_id")
	private User user;
	
	public void setBoard(Board board) {
		this.board = board;
		board.getCommentList().add(this);
	}
	
	public void setUser(User user) {
		this.user = user;
		user.getCommentList().add(this);
	}
}
