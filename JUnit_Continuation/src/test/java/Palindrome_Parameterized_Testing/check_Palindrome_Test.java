package Palindrome_Parameterized_Testing;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import Parameterized_Testing.Check_Palindrome;

public class check_Palindrome_Test {
	
	
	@ParameterizedTest
	@ValueSource(strings= {"tenet","radar","abba","abcd"})
	public void isPalindromeTest(String str) {
		Check_Palindrome p = new Check_Palindrome();
		assertTrue(p.isPalindrome(str));
	}

	
	@ParameterizedTest
	@ValueSource(ints= {45,65,-2})
	public void isPositiveTest(int a) {
		Check_Palindrome p = new Check_Palindrome();
		assertTrue(p.isPositive(a));
	}
	
	
	@ParameterizedTest
	@CsvSource({
		"1,2,3",
		"5,5,10",
		"5,3,7"
	})
	public void testAdd(int a,int b,int expectedRes) {
		Check_Palindrome p = new Check_Palindrome();
		int actualRes = p.add(a, b);
		assertEquals(expectedRes,actualRes);
	}
}
