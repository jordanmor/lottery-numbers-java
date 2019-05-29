package com.tts;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* =====-=====-=====-=====-=====
		   ********** STEP 1 **********
		   =====-=====-=====-=====-===== */
		
		System.out.println("The following are valid characters for input");
		// Print the valid ASCII number values for numbers, lower case letters and upper case letters
		AsciiChars.printNumbers();
		AsciiChars.printUpperCase();
		AsciiChars.printLowerCase();
		
		/* =====-=====-=====-=====-=====
		   ********** STEP 2 ***********
		   =====-=====-=====-=====-===== */
		
		// Start interactive command-line program
		Survey.start();
	}

}
