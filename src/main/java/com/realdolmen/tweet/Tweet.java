package com.realdolmen.tweet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.realdolmen.course.domain.Person;
import com.realdolmen.demo.Status;

@Entity
public class Tweet {

	public static final String GET_AVG = "Tweet.getAvg";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(cascade = {CascadeType.PERSIST}, fetch=FetchType.EAGER)
	private Person user;

	private String message;

	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name = "jnd_tweet_tag",  joinColumns = @JoinColumn(name = "tweet_fk"),  
	inverseJoinColumns = @JoinColumn(name = "tag_fk")) 
	private List<Tag> tags = new ArrayList<Tag>();

	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();

	@Enumerated(EnumType.STRING)
	private Status status = Status.INACTIVE;

	public Tweet() {
	}

	public Tweet(Person user, String message, Tag... tags) {
		super();
		this.user = user;
		this.message = message;
		this.tags = new LinkedList<>(Arrays.asList(tags));
	}

	public String getMessage() {
		return message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	public Person getUser() {
		return user;
	}

	public List<Tag> getTags() {
		return tags;
	}
	
	public void addTag(Tag tag){
		this.tags.add(tag);
		tag.addTweet(this);
	}

	public void removeTag(Tag tag) {
		tags.remove(tag);
	}

	@Override
	public String toString() {
		return "Tweet [id=" + id + ", user=" + user + ", message=" + message + ", tags=" + tags + "]";
	}
	
	
	

}
