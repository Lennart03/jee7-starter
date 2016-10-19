package com.realdolmen.tweet;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.realdolmen.demo.Prude;

public class TweetValidator implements ConstraintValidator<Prude, Tweet>{

	@Override
	public void initialize(Prude constraintAnnotation) {
		// TODO Auto-generated method stub
	}

	@Override
	public boolean isValid(Tweet tweet, ConstraintValidatorContext context) {
		return !tweet.getMessage().toLowerCase().contains("shit") && !tweet.getMessage().toLowerCase().contains("fuck");
	}

	

}
