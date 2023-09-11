package com.bootproject.bootproject.root.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="bf_boardfiles")
@Data
@NoArgsConstructor
public class BoardFiles {
	@Id
	@GeneratedValue
	private int bf_num;
	private String bf_fileurl;
	private String bf_ori_filename;
	
	@ManyToOne
	@JoinColumn(name="bf_bo_num")
	private Board board;
	
	public void setBoard(Board board) {
		// �ϴ� ���� ������ ��� ©�� ���� �ϴ� ����� �⺻���� �ڵ常
		this.board = board;
		board.getBoardFilesList().add(this);
	}
}
