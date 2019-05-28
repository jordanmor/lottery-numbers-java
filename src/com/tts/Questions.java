package com.tts;

import java.util.Objects;
import java.util.Scanner;

public class Questions {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void askName() {
		System.out.println("Please enter your name: ");
		System.out.println("Hello " + scanner.next());
	}
	
	public static void askMainQuestions() {
		String favoritePet = askQuestionStringOutput("What is your favorite pet?");
		String actorName = askQuestionStringOutput("What is the first name of the your favorite actor or actress?");
		int petAge = askQuestionIntegerOutput("What is the age of your pet?");
		int luckyNumber = askQuestionIntegerOutput("What is your lucky number?");
		int carYear = askQuestionIntegerOutput("What is two-digit model year of their car?");
		int chosenNumber = askQuestionIntegerOutput("Enter a random number between 1 and 50.");
		
		LotteryNumbers.generate(favoritePet, petAge, luckyNumber, carYear, actorName, chosenNumber);
	}
		
	public static boolean interactive() {		
		System.out.print("Do you wish to continue to the interactive portion? (yes,no):");
		String response = scanner.next().toLowerCase();
		if(Objects.equals(response, "yes") || Objects.equals(response, "y")) {
			return true;
		} else {
			return false;
		}
	}	
	
	public static boolean repeat() {
		System.out.println("Would like to answer questions to generate another set of numbers? (yes,no):");
		String response = scanner.next().toLowerCase();
		if(Objects.equals(response, "yes") || Objects.equals(response, "y")) {
			return true;
		} else {
			System.out.println("Thank you for participating in this survey.");
			scanner.close();
			return false;
		}
	}
	
	private static String askQuestionStringOutput(String question) {
		System.out.print(question + ":");
		return scanner.next();
	}
	
	private static int askQuestionIntegerOutput(String question) {
		System.out.print(question + ":");
		return scanner.nextInt();
	}

}
