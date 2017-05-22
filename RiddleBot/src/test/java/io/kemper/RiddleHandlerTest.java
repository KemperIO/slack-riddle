package io.kemper;

import static org.junit.Assert.*;

import org.junit.Test;

public class RiddleHandlerTest {

	@Test
	public void test() {
		RiddleHandler rh = new RiddleHandler();
		String input = "ALLO WORLD";
		assertEquals(input, rh.handleRequest(input, new TestContext()));
	}

}
