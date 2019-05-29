package com.tts;

import java.util.Objects;
import java.util.Scanner;

public class Questions {
	
	static Scanner scanner = new Scanner(System.in);
	
	// Ask user's name and print welcome message to user with his/her name
	public static void askName() {
		System.out.print("Please enter your first name: ");
		while(!scanner.hasNext("[A-Za-z]+")) {
			scanner.next();
			System.out.println("Please enter a valid first name.");
		}
		System.out.println("Hello " + scanner.next());
	}
	
	// Ask the user six questions and use user input to generate lottery numbers
	// Validate user input to make sure answers are within defined range
	// If the user does not enter a valid entry, ask the question again until a valid entry is produced
	public static void askMainQuestions() {
		// Favorite pet (must be at least three characters long)
		String favoritePet = questionStringOutput("What is your favorite pet's name?");
		while(favoritePet.length() < 3) {
			favoritePet = questionStringOutput("Please enter a pet's name with a least three characters");
		}
		// Pet age (valid integer range from 1 - 100)
		int petAge = questionIntegerOutput("What is the age of your pet?");
		while(petAge < 1 || petAge > 100) {
			petAge = questionIntegerOutput("Please enter a valid number for the age of your pet");
		}
		// Lucky number (valid integer range from 1 - 100)
		int luckyNumber = questionIntegerOutput("What is your lucky number? (Please choose a number between 1 and 100)");
		while(luckyNumber < 1 || luckyNumber > 100) {
			luckyNumber = questionIntegerOutput("That number was outside the permitted range. Please enter your lucky number (between 1 and 100)");
		}
		// Car model year (valid integer range from 00 - 99)
		int carYear = questionIntegerOutput("What is the two-digit model year of your car?");
		while(carYear < 0 || carYear > 99) {
			carYear = questionIntegerOutput("Please enter a valid two-digit model year of your car");
		}
		// Favorite actor's or actress's first name (must be at least three characters long)
		String actorName = questionStringOutput("What is the first name of the your favorite actor or actress?");
		while(actorName.length() < 3) {
			actorName = questionStringOutput("Please enter an actor's or actress's name with a least three characters");
		}
		// User chooses random number from 1 - 50
		int chosenNumber = questionIntegerOutput("Enter a random number between 1 and 50");
		while(chosenNumber < 1 || chosenNumber > 50) {
			chosenNumber = questionIntegerOutput("That number was outside the permitted range. Please enter a random number between 1 and 50");
		}
		// Generate 5 lottery numbers and one magic ball using the saved valid user input from the 6 previous questions
		LotteryNumbers.generate(favoritePet, petAge, luckyNumber, carYear, actorName, chosenNumber);
	}
	
	// Function asks if user wants to continue with the interactive portion of the survey
	// Returns user's responses (boolean)
	public static boolean interactive() {		
		System.out.print("Do you wish to continue to the interactive portion? (yes,no):");
		return createBooleanResponse(scanner.next());
	}	
	
	// Function asks if user wants to answer survey questions again and generate a new set of lottery numbers
	// If user response answers no, a thank you message is printed.
	// Returns user's response (boolean)
	public static boolean repeat() {
		System.out.println("Would you like to answer questions to generate another set of numbers? (yes,no):");
		boolean response = createBooleanResponse(scanner.next());
		if(response == false) {
			System.out.println("Thank you for participating in this survey.");
			scanner.close();
		}
		return response;
	}
	
	// Function takes user's yes/no input and returns a boolean
	private static boolean createBooleanResponse(String response) {
		response = response.toLowerCase();
		if(Objects.equals(response, "yes") || Objects.equals(response, "y")) {
			return true;
		}
		return false;
	}
	
	// Function validates whether user input is a string
	// If the user does not enter a valid entry, the question is asked again until a valid entry is produced
	// If the user entry is valid, the user string input is returned
	private static String questionStringOutput(String question) {
		System.out.print(question + ":");
		while(!scanner.hasNext("[A-Za-z]+")) {
			System.out.println("Please enter a valid string input.");
			scanner.next();
			System.out.print(question + ":");
		}
		return scanner.next();
	}
	
	// Function validates whether user input is an integer
	// If the user does not enter a valid entry, the question is asked again until a valid entry is produced
	// If the user entry is valid, the user number input is returned
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
