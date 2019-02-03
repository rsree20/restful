package com;

public class Testing {

	public static void main(String[] args) {
		final String s1 = new String("java");
		final String s2 = s1 + " test";
		String s3 = s1 + s2;
		String s4 = "java test";
		System.out.println(s4 == s2);
	}
}
