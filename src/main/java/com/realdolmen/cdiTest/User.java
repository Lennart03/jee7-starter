package com.realdolmen.cdiTest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;

public class User {

	private String name;
	private int age;
	private List<Comment> createdComments;
	@Inject
	private CommentFactory commentFactory;
	
	public User(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Comment> getCreatedComments() {
		return createdComments;
	}

	public void setCreatedComments(List<Comment> createdComments) {
		this.createdComments = createdComments;
	}
	
	
	
}
