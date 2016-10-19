package com.realdolmen.cdiTest;

import javax.inject.Inject;

public class Comment {
	
	private String text;
	private User user;

	public Comment(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public String toString(){
		String temp = "Comment created by:";
		temp += "\n\t" + text;
		return temp;
	}
	
	

}
