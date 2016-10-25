package com.edocti.jintro.utils.test;

import static com.edocti.jintro.utils.Utils.*;
import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

public class UtilTest {
	
	@Test
	public void testStringIsEmpty() {
		assertEquals(new ArrayList<Integer>().size(), 0);
		
		String cucu = "cucu";
		assertFalse(stringIsEmpty(cucu));
		assertTrue(stringIsEmpty("   "));
		assertTrue(stringIsEmpty("  \n  "));
	}

	@Test
	public void testSort() {
		String[] arr = {"b", "c", "a"};
		sort(arr);
		String[] sorted = {"a", "b", "c"};
		assertArrayEquals(sorted, arr);
	}
}
