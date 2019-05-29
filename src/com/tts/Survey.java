package com.tts;

public class Survey {
	
	public static void start() {	
		Questions.askName();
		
		// Initialize repeat variable with default false boolean value
		boolean repeat = false;
		
		// Check whether user wishes to continue to the interactive portion of the survey
		boolean interactive = Questions.interactive();
		
		if(interactive) {
			do {
				// Ask user six questions and use user input to generate lottery numbers 
				Questions.askMainQuestions();
				// Check whether user wants to answer the questions again and generate
				//  a new set of lottery numbers. If so, repeat the process. If not, the program will exit.
				repeat = Questions.repeat();
			} while(repeat);
		} else {
			// If the user does not want to continue with interactive portion 
			// of the survey, quit the program with a message
			System.out.println("Please return later to complete the survey.");
		}
	}
}
