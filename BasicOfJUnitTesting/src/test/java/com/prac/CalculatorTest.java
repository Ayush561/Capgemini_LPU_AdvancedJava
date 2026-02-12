package com.prac;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
	
	public void addTest() {
		int res=Calculator.add(20,30);
		
	}

	
	public void reverseTest() {
		String actualres=Calculator.reserseString("Data");
		//Expected Output: ataD 
		//Actual Output :taD because of the error in the
		//reverse string code 
		
		assertEquals("ataD",actualres);
	}
	
	@Test
	public void reverseTestNull() {
		String actualres = Calculator.reserseString(null);
		assertEquals("Can't be reversed...",actualres);
	}
	
	@Test
	public void testAEException() {
		assertThrows(ArithmeticException.class,()->{Calculator.div(10, 0);});
	}

	
}
