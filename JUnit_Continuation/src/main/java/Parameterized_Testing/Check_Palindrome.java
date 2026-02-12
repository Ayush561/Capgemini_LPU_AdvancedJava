package Parameterized_Testing;

public class Check_Palindrome {
	
	public static boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		sb.reverse();
		
		if(s.equals(sb.toString())) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
	public static boolean isPositive(int a) {
		if(a>0 || a==0) {
			return true;
		}
		return false;
		
	}
	
	public static int add(int a,int b) {
		return a+b;
	}
	
	public static void main(String[] args) {
		
		System.out.println(isPalindrome("tenet"));
		
	}

}
