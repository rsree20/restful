package com.rest;

public class Test2 {

	public static void main(String[] args) {
		final String s1 = "rakul";
		final String s2 = new String(" preet");
		String s3 = s1 + s2;
		String s4 = "rakul preet";
		String s5 = "rakul";
		String s6 = new String("rakul");
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		System.out.println(s5 == s1);
		System.out.println(s6.intern() == s1);
	}
}
