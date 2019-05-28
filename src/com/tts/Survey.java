package com.tts;

import java.util.Objects;
import java.util.Scanner;

public class Survey {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void begin() {
		Questions.askName();
		interactivePortion();
	}
	
	public static void interactivePortion() {
		boolean repeat = false;
		
		System.out.print("Do you wish to continue to the interactive portion? (yes,no):");
		String response = scanner.next().toLowerCase();
		if(!Objects.equals(response, "yes") && !Objects.equals(response, "y")) {
			System.out.println("Please return later to complete the survey.");
			scanner.close();
		} else {
			do {
				Questions.askMainQuestions();
				Questions.repeat(response, repeat);
			} while(repeat);
		}
	}	
}
