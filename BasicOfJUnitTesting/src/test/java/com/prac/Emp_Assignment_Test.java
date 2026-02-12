package com.prac;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.*;

import org.junit.jupiter.api.Test;
public class Emp_Assignment_Test {
	
	@Test
	public void testIsListEmpty() {
		ArrayList<Emp_Assignment> al = new ArrayList<>();
        al.add(new Emp_Assignment(101, "Amit", 55000.0, 25, "2022-01-15", "CSE"));
        al.add(new Emp_Assignment(102, "Neha", 62000.0, 27, "2021-07-10", "IT"));
        al.add(new Emp_Assignment(103, "Rahul", 48000.0, 24, "2023-03-05", "ECE"));
        al.add(new Emp_Assignment(104, "Priya", 75000.0, 29, "2020-11-20", "CSE"));
        al.add(new Emp_Assignment(105, "Karan", 51000.0, 26, "2022-08-01", "MECH"));
        
        Emp_Assignment emp = new Emp_Assignment();
        
        assertFalse(emp.listIsEmplty(al));		
	}
	
	@Test
	public void testValidAge() {
		Emp_Assignment emp = new Emp_Assignment(101, "Amit", 55000.0, 25, "2022-01-15", "CSE");
		
		assertTrue(emp.isValidAge());
	}
	
	@Test
	public void testValidSize() {
		ArrayList<Emp_Assignment> al = new ArrayList<>();
        al.add(new Emp_Assignment(101, "Amit", 55000.0, 25, "2022-01-15", "CSE"));
        al.add(new Emp_Assignment(102, "Neha", 62000.0, 27, "2021-07-10", "IT"));
        al.add(new Emp_Assignment(103, "Rahul", 48000.0, 24, "2023-03-05", "ECE"));
        al.add(new Emp_Assignment(104, "Priya", 75000.0, 29, "2020-11-20", "CSE"));
        al.add(new Emp_Assignment(105, "Karan", 51000.0, 26, "2022-08-01", "MECH"));
        
        Emp_Assignment emp = new Emp_Assignment();
        
        assertTrue(emp.validSize(al));
		
	}

}
