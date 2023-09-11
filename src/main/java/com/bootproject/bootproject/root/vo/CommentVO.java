package com.bootproject.bootproject.root.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class CommentVO {
	
	private int cm_num;
	private Date cm_date;
	private String cm_content;
	private int cm_state;
	
	
	private BoardVO board;
	private UserVO user;
	
	
}
