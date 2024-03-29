package com.ha.qna;

import lombok.Getter;

@Getter
public abstract class Question {
	private String text;
	private String[] answerChoices;
	private int id;

	public Question(int id, String text, String[] answerChoices) {
		this.id = id;
		this.text = text;
		this.answerChoices = answerChoices;
	}

	public boolean match(Answer answer) {
		return false;
	}

	public String getAnswerChoice(int i) {
		return answerChoices[i];
	}

	abstract public boolean match(int expected, int actual);

	public int indexOf(String matchingAnswerChoice) {
		for (int i = 0; i < answerChoices.length; i++)
			if (answerChoices[i].equals(matchingAnswerChoice))
				return i;
		return -1;
	}
}
