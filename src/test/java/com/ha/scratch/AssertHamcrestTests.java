package com.ha.scratch;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.assertj.core.data.Offset;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

public class AssertHamcrestTests {
	
	private Account account;
	
//	@ExtendWith
	
	@BeforeEach
	public void create() {
		account = new Account("account Name");
	}

	@Disabled("테스트로 비활성화함")
	@DisplayName(value = "실행 간드아")
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
	public void assertGreaterThan() {
		assertThat(3).isGreaterThan(2);
	}
	
	@Test
	public void assertCreateObjectEqualToCreateObject() {
		assertThat(new String[] {}).isEqualTo(new String[] {});
	}
	
	@Test
	@DisplayName(value = "예외 발생 처리")
	public void throwsWhenWithdrawingTooMuch() {
		assertThrows(InsufficientFundsException.class, () -> account.withdraw(100));
	}
	
	@Test
	public void readsFromTestFile() throws IOException {
		String fileName = "test.txt";
		BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
		writer.write("test data");
		writer.close();
	}
}
