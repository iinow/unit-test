package com.ha.qna;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

@org.springframework.context.annotation.Profile(value = "dev")
public class ProfileMatcherTest {

	private MatchListener listener;
	
	@BeforeEach
	public void createMatchListener() {
		listener = mock(MatchListener.class);
	}
	
//	@Test
//	public void processNotifiesListenerOnMatch() {
//		matcher.add(matchingProfile);
//		MatchSet set = matchingProfile.getMatchSet(criteria);
//		matcher.process(listener, set);
//		verify(listener).foundMatch(matchingProfile, set);
//	}
}
