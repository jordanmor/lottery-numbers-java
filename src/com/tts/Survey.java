package com.tts;

public class Survey {
	
	public static void begin() {
		Questions.askName();
		
		boolean interactive = Questions.interactive();
		boolean repeat = false;
		
		if(interactive) {
			do {
				Questions.askMainQuestions();
				repeat = Questions.repeat();
			} while(repeat);
		} else {
			System.out.println("Please return later to complete the survey.");
		}
	}
}
