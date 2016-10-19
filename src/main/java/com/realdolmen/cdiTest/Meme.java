package com.realdolmen.cdiTest;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Dank(rating = 2)
public class Meme {
	
	private String title;
	@Inject
	private Long id;
	@Inject
	private Comment comment;
	
	
	public Meme(String title) {
		super();
		this.title = title;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	
	

}
