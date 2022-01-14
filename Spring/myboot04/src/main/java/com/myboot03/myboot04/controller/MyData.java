package com.myboot03.myboot04.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

@Entity
@Table(name = "mydata")
public class MyData {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", length = 50, nullable = false)
	private Long id;

	@Column(name = "name", length = 50, nullable = false)
	private String name;

	@Column(name = "email", length = 200, nullable = false)
	@Email
	private String email;

	@Column(name = "age", length = 100, nullable = true)
	@Min(0)
	@Max(120)
	private Integer age;

	@Column(name = "memo", length = 500, nullable = true)
	private String memo;

	public MyData() {

	}

	public MyData(Long id, String name, String email, Integer age, String memo) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.memo = memo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

}
