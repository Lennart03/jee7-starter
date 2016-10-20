package com.realdolmen.course.domain;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.dbunit.util.concurrent.SynchronousChannel;
import org.hibernate.validator.constraints.Email;
import org.junit.Before;
import org.junit.Test;

import com.realdolmen.course.utilities.persistence.JpaPersistenceTest;
import com.realdolmen.demo.Status;
import com.realdolmen.tweet.Tag;
import com.realdolmen.tweet.Tweet;

public class TweetPersistenceTest extends JpaPersistenceTest{
	
	private RegularPerson testPerson;
	
	@Before
	public void initPerson() {
		testPerson = new RegularPerson("Test", "Person");
		testPerson.setEmail("person@derp.com");
		testPerson.setPassword("derp");
	}
	
	@Test
	public void tweetCanBeRetrieved() throws Exception{
		EntityManager em = entityManager();
		Tweet tweet = em.find(Tweet.class, 1000L);
		assertEquals("I see purple haze.", tweet.getMessage());
	}
	
	@Test
	public void tweetCanBePersisted() {
		EntityManager em = entityManager();
		Tweet tweet = new Tweet(testPerson, "Test message");
		System.out.println("Persisting");
		em.persist(tweet);
	}
	
	@Test
	public void statusPersistedAndRetrieved() {
		EntityManager em = entityManager();
		Tweet tweet = new Tweet(testPerson, "PersistMessage");
		tweet.setStatus(Status.DRAFT);
		em.persist(tweet);
		assertNotNull(tweet.getId());
		Tweet tweetRetrieved = em.find(Tweet.class, tweet.getId());
		assertNotNull(tweetRetrieved);
		assertEquals(tweetRetrieved.getStatus(), Status.DRAFT);
		System.out.println(tweetRetrieved);
	}
	
	@Test
	public void statusPersistTagsAndRetrieve() {
		EntityManager em = entityManager();
		Tweet tweet = new Tweet(testPerson, "Test is created", new Tag("RD"), new Tag("Fun"), new Tag("Much tag"), new Tag("Such persist"));
		em.persist(tweet);
		assertNotNull(tweet.getId());
	}
	
	@Test
	public void adjustUserName(){
		EntityManager em = entityManager();
		Tweet tweet = em.find(Tweet.class, 1000L);
		tweet.getUser().setFirstName("ADJUSTED");
		em.persist(tweet);
		
	}
	
	@Test
	public void addTagToTweet() {
		EntityManager em = entityManager();
		Tweet tweet = em.find(Tweet.class, 1000L);
		tweet.addTag(new Tag("Much Test"));
		assertEquals(1, tweet.getTags().size());
		System.out.println(tweet.getTags());
		em.merge(tweet);
		Tweet retrieved = em.find(Tweet.class, 1000L);
		assertEquals(1, retrieved.getTags().size());
		System.out.println(retrieved.getTags());
	}
	
	@Test
	public void removeTweet(){
		EntityManager em = entityManager();
		Tweet entity = em.find(Tweet.class, 1000L);
		em.remove(entity);
	}
	
	@Test
	public void removeTagFromTweet() {
		EntityManager em = entityManager();
		Tag tag = em.find(Tag.class, 1000L);
		Tweet tweetRetrieved;
		for(Tweet tweet : tag.getTweets()){
			tweetRetrieved = em.find(Tweet.class, tweet.getId());
			tweetRetrieved.removeTag(tag);
			em.merge(tweetRetrieved);
		}
		em.remove(tag);
	}
	
	@Test
	public void queryAllTweets(){
		EntityManager em = entityManager();
		Query query = em.createQuery("SELECT t FROM Tweet t");
		List<Tweet> tweets = query.getResultList();
		for(Tweet tweet : tweets){
			System.out.println(tweet);
		}
		assertEquals(9, tweets.size());
	}
	
	@Test
	public void queryTweetsFromPerson(){
		EntityManager em =entityManager();
		Query query = em.createQuery("SELECT t FROM Tweet t WHERE (t.user.firstName = 'John' AND t.user.lastName = 'Doe')");
		List<Tweet> tweets = query.getResultList();
		for(Tweet tweet : tweets){
			System.out.println(tweet);
		}
		assertEquals(2, tweets.size());
	}
	
	@Test
	public void queryAverageNumberOfTagsPerTweet() {
		EntityManager em = entityManager();
		double d = em.createQuery("select avg (t.tags.size) from Tweet t", Double.class).getSingleResult();
		System.out.println(d);
	}
	
	@Test
	public void queryShizzle() {
		EntityManager em = entityManager();
		List<Map<Person, Double>> r = em.createQuery("select new com.realdom").getResultList();
	}

}
