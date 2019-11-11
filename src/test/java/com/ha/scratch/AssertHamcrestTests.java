package com.ha.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertHamcrestTests {

	@Disabled("dddd")
	@DisplayName(value = "first")
	@Test
	public void assertDoublesEqual() {
		assertThat(2.32 * 3).isEqualTo(6.96);
	}

	@Test
	public void assertWithTolerance() {
		assertTrue(Math.abs((2.32 * 3) - 6.96) < 0.0005);
	}

	@Test
	public void assertDoublesCloseTo() {
		assertThat(2.32 * 3).isCloseTo(6.96, Offset.offset(0.0005));
	}
	
	@Test
	public void assertDoublesCloseTo3() {
		assertThat(2.32 * 3).isCloseTo(6.96, Offset.offset(0.0005));
	}
}
