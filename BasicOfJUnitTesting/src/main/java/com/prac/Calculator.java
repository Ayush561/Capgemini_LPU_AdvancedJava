package com.prac;

import java.util.*;
public class Calculator {
	public static int add(int a,int b) {
		return a+b;
	}
	
	public static String reserseString(String data) throws NullPointerException {
		if(data==null) {
			throw new NullPointerException("Can't be reversed...");
		}
		
		String rev="";
		for(int i=data.length()-1;i>=0;i--) {
			rev+=data.charAt(i);
		}
		
		return rev;
	}
	
	public static int div(int a,int b) {
		return a/b;
	}

}
