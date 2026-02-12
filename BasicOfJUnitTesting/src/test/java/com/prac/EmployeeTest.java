package com.prac;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class EmployeeTest {
	
	@Test
	public void testValidAge() {
		Employee e = new Employee(10,"Allen",20,"CSE");
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void testValidName() {
		Employee e = new Employee(10,"Allen",20,"CSE");
		assertTrue(e.isValidName());
	}

}
