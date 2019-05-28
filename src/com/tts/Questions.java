package com.tts;

import java.util.Objects;
import java.util.Scanner;

public class Questions {
	
	static Scanner scanner = new Scanner(System.in);
	
	public static void askName() {
		System.out.println("Please enter your name: ");
		while(!scanner.hasNext("[A-Za-z]+")) {
			scanner.next();
			System.out.println("Please enter a valid name.");
		}
		System.out.println("Hello " + scanner.next());
	}
	
	public static void askMainQuestions() {
		String favoritePet = questionStringOutput("What is your favorite pet?");
		
		int petAge = questionIntegerOutput("What is the age of your pet?");
		
		int luckyNumber = questionIntegerOutput("What is your lucky number? (Please choose a number between 1 and 100)");
		while(luckyNumber < 1 || luckyNumber > 99) {
			luckyNumber = questionIntegerOutput("That number was outside the permitted range. Please enter your lucky number (between 1 and 100)");
		}
		
		int carYear = questionIntegerOutput("What is the two-digit model year of your car?");
		while(carYear < 0 || carYear > 99) {
			carYear = questionIntegerOutput("Please enter a valid two-digit model year of your car");
		}
		
		String actorName = questionStringOutput("What is the first name of the your favorite actor or actress?");
		
		int chosenNumber = questionIntegerOutput("Enter a random number between 1 and 50");
		while(chosenNumber < 1 || chosenNumber > 50) {
			chosenNumber = questionIntegerOutput("That number was outside the permitted range. Please enter a random number between 1 and 50");
		}
		
		LotteryNumbers.generate(favoritePet, petAge, luckyNumber, carYear, actorName, chosenNumber);
	}
		
	public static boolean interactive() {		
		System.out.print("Do you wish to continue to the interactive portion? (yes,no):");
		return createBooleanResponse(scanner.next());
	}	
	
	public static boolean repeat() {
		System.out.println("Would you like to answer questions to generate another set of numbers? (yes,no):");
		boolean response = createBooleanResponse(scanner.next());
		if(response == false) {
			System.out.println("Thank you for participating in this survey.");
			scanner.close();
		}
		return response;
	}
	
	private static boolean createBooleanResponse(String response) {
		response = response.toLowerCase();
		if(Objects.equals(response, "yes") || Objects.equals(response, "y")) {
			return true;
		}
		return false;
	}
	
	private static String questionStringOutput(String question) {
		System.out.print(question + ":");
		while(!scanner.hasNext("[A-Za-z]+")) {
			System.out.println("Please enter a valid string input.");
			scanner.next();
			System.out.print(question + ":");
		}
		return scanner.next();
	}
	
	private static int questionIntegerOutput(String question) {
		System.out.print(question + ":");
		while(!scanner.hasNextInt()) {
			System.out.println("Please enter a number.");
			scanner.next();
			System.out.print(question + ":");
		}
		return scanner.nextInt();
	}
}
