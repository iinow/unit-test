package com.ha.qna;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

public class MatchSet {
	private Map<String, Answer> answers;
	private int score = 0;
	
	public MatchSet(Map<String, Answer> answers, Criteria criteria){
		this.answers = answers;
		
	}
	
	private void calculateScore(Criteria criteria) {
		for(Criterion criterion: criteria) {
			if(criterion.matches(answerMatching(criterion))){
				score += criterion.getWeight().getValue();
			}
		}
	}
	
	private Answer answerMatching(Criterion criterion) {
		return answers.get(criterion.getAnswer().getQuestionText());
	}
	
	public int getScore() {
		return this.score;
	}
}
