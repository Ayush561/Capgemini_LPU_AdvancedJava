package com.prac;

import java.util.*;

public class Emp_Assignment_Driver {
	public static void main(String[] args) {
		ArrayList<Emp_Assignment> al = new ArrayList<>();
		
        al.add(new Emp_Assignment(101, "Amit", 55000.0, 25, "2022-01-15", "CSE"));
        al.add(new Emp_Assignment(102, "Neha", 62000.0, 27, "2021-07-10", "IT"));
        al.add(new Emp_Assignment(103, "Rahul", 48000.0, 24, "2023-03-05", "ECE"));
        al.add(new Emp_Assignment(104, "Priya", 75000.0, 29, "2020-11-20", "CSE"));
        al.add(new Emp_Assignment(105, "Karan", 51000.0, 26, "2022-08-01", "MECH"));
        
        
        for(Emp_Assignment e:al) {
        	System.out.println(e);
        }
        
        for(Emp_Assignment e:al) {
        	System.out.println(e.isValidAge());
        }
        
        Emp_Assignment emp = new Emp_Assignment();
        System.out.println("Is List of emp empty:"+emp.listIsEmplty(al));
        
        
        System.out.println("Valid size:"+emp.validSize(al));
        
	}
	
}
