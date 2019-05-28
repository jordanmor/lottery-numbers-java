package com.tts;

// Create a separate class that will print valid characters to the user
public class AsciiChars {
	public static void printNumbers() {
		char[] numberChars = {'0','1','2','3','4','5','6','7','8','9'};
		printChars(numberChars);
	}
	
	public static void printUpperCase() {
		char[] lowerCaseChars = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		printChars(lowerCaseChars);
	}
	
	public static void printLowerCase() {
		char[] lowerCaseChars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z'};
		printChars(lowerCaseChars);
	}
	
	private static void printChars(char arr[]) {
		for(int x = 0; x < arr.length; x++) {
			System.out.println("The character " + arr[x] + " has an ascii value of " + (int) arr[x]);
		}
	}
}