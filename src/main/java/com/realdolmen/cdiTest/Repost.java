package com.realdolmen.cdiTest;

import java.util.List;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;


public class Repost {
	
	private Meme meme;
	
	@Inject
	private List<Comment> comments;
	
	public Repost() {
		super();
	}
	
	public Meme getMeme() {
		return meme;
	}
	public void setMeme(Meme meme) {
		this.meme = meme;
	}
	public List<Comment> getCommentes() {
		return comments;
	}
	public void setCommentes(List<Comment> commentes) {
		this.comments = commentes;
	}
	
	@Override
	public String toString() {
		String temp = new String();
		for (Comment comment : comments) {
			temp += comment +"\n";
		}
		return temp;
	}
	
	
	
	
	

}
