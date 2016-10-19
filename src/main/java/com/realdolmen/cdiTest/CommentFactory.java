package com.realdolmen.cdiTest;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.inject.Produces;

public class CommentFactory {
	
	@Produces
	public List<Comment> createComments(){
		List<Comment> comments = new ArrayList<>();
		comments.add(new Comment("Great post"));
		comments.add(new Comment("This post sucks"));
		return comments;
	}

}
