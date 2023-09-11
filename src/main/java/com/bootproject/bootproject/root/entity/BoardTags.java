package com.bootproject.bootproject.root.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="bt_boardtaglist")
@Data
@NoArgsConstructor
public class BoardTags {
	@Id
	@GeneratedValue
	private int bt_num;
	@ManyToOne
	@JoinColumn(name="bt_bo_num")
	private Board board;
	@ManyToOne
	@JoinColumn(name="bt_tg_tagnum")	
	private Tag tag;
	
	public void setBoard(Board board) {
		this.board = board;
		board.getBoardTagsList().add(this);
	}
	public void setTag(Tag tag) {
		this.tag = tag;
		tag.getBoardTagsList().add(this);
	}
}
