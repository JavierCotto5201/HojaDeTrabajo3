package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class quick {

	@Test
	void test() {
		JUnit test = new JUnit();
		int[] actual = { 5, 1, 6, 2, 3, 4 };
	    int[] expected = { 1, 2, 3, 4, 5, 6 };
		int[] num_list = test.quickSort(actual, 0, actual.length-1);
		assertArrayEquals(expected, actual);
	}
}
