package com.bootproject.bootproject.root.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tg_tag")
@Data
@NoArgsConstructor
public class Tag {
	@Id
	@GeneratedValue
	private int tg_tagnum;
	private String tg_tagname;
	@OneToMany(mappedBy = "tag")
	private List<BoardTags> boardTagsList;
}
