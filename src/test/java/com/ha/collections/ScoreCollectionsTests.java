package com.ha.collections;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ScoreCollectionsTests {

	@BeforeEach
	public void create() {
		
	}
	
	@Test
	public void answersArithmeticMeanOfTwoNumbers() {
		ScoreCollection collection = new ScoreCollection();
		collection.add(() -> 5);
		collection.add(() -> 7);
		
		int actualResult = collection.arithmeticMean();
		assertThat(actualResult)
			.describedAs("평균 구하기")
			.isEqualTo(6);
	}
}
