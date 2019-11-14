package com.ha.qna;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Profile {
	private Map<String, Answer> answers = new HashMap<>();
	private int score;
	private String name;

	public Profile(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void add(Answer answer) {
		answers.put(answer.getQuestionText(), answer);
	}

	public boolean matches(Criteria criteria) {
		score = new MatchSet(answers, criteria).getScore();
		if(doesNotMeetAnyMustMatchCriterion(criteria)) {
			return false;
		}
		return anyMatches(criteria);
	}

	private boolean doesNotMeetAnyMustMatchCriterion(Criteria criteria) {
		for (Criterion criterion : criteria) {
			boolean match = criterion.matches(answerMatching(criterion));
			if (!match && criterion.getWeight() == Weight.MustMatch)
				return true;
		}
		return false;
	}

	private boolean anyMatches(Criteria criteria) {
		boolean anyMatches = false;
		for (Criterion criterion : criteria) {
			anyMatches |= criterion.matches(answerMatching(criterion));
		}
		return anyMatches;
	}

	private Answer answerMatching(Criterion criterion) {
		return answers.get(criterion.getAnswer().getQuestionText());
	}

	public int score() {
		return score;
	}

	public List<Answer> find(Predicate<Answer> pred) {
		return answers.values().stream().filter(pred).collect(Collectors.toList());
	}
}
