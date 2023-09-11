package com.bootproject.bootproject.root.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ct_category")
@Data
@NoArgsConstructor
public class Category {
	@Id
	@GeneratedValue
	private int ct_num;
	private String ct_name;

	@OneToMany(mappedBy = "category")
	private List<Board> boardList;
}
