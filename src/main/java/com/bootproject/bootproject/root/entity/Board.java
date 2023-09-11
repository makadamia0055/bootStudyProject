package com.bootproject.bootproject.root.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="bo_board")
@Data
@NoArgsConstructor
public class Board {
	@Id
	@GeneratedValue
	private int bo_num;
	private String bo_title;
	private String bo_content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date bo_date;
	private int bo_state;
	private int bo_view;
	
	
	
	@ManyToOne
	@JoinColumn(name="bo_us_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name="bo_ct_num")
	private Category category;
	
	@OneToMany(mappedBy = "board")
	private List<BoardFiles> boardFilesList;
	
	@OneToMany(mappedBy = "board")
	private List<BoardVote> boardVoteList;
	
	@OneToMany(mappedBy = "board")
	private List<BoardTags> boardTagsList;
	
	@OneToMany(mappedBy = "board")
	private List<Comment> commentList;
	
	public void setUser(User user) {
		this.user = user;
		user.getBoardList().add(this);
		
	}
	
	public void setCategory(Category category) {
		if(this.category!=null)
			this.category.getBoardList().remove(this);
		this.category = category;
		category.getBoardList().add(this);
		
	}
	public int getBoardVote() {
		int sum = 0;
		for(BoardVote tmp : this.boardVoteList) {
			sum+=tmp.getBv_state();
		}
		return sum;
	}
	
}
