package com.ha.qna;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ProfileTests {
	private Profile profile;
	private BooleanQuestion question;
	private Criteria criteria;

	@BeforeEach
	public void create() {
		profile = new Profile("Bull Hockey, Inc.");
		question = new BooleanQuestion(1, "Got bonuses?");
		criteria = new Criteria();

//		log.info("profile: " + profile.toString() + ", question: " + question.toString() + ", criteria: "
//				+ criteria.toString());
	}

	@Test
	public void matchAnswersFalseWhenMustMatchCriteriaNotMet() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

		boolean matches = profile.matches(criteria);

		assertThat(matches).isEqualTo(false);
	}

	@Test
	public void matchAnswersTrueForAnyDontCareCriteria() {
		profile.add(new Answer(question, Bool.FALSE));
		criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

		boolean matches = profile.matches(criteria);

		assertThat(matches).isEqualTo(true);
	}
}
