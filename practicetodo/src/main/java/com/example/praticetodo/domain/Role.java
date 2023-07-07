package com.example.praticetodo.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Column(unique = true)
	private String rolename;
	
	@ManyToMany(mappedBy = "roles") // 연관된 테이블이 먼지 알려줘야댐
	private List<User> users;
}
