package com.tts;

public class LotteryNumbers {
	// Generate 5 lottery numbers and one magic ball using valid user input from the 6 questions
	public static void generate(String favoritePet, int petAge, int luckyNumber ,int carYear, String actorName, int chosenNumber) {

		// Magic Ball
		// Generate number by multiplying lucky number by random number with range of 1 - 12;
		int magicBall = luckyNumber * (int)(Math.random() * 12) + 1; 
		
		// Initialize array with a length of six for lottery numbers
		int lotteryArray[] = new int[5];
		
		// Lottery Number 1
		// Find the 3rd letter of their favorite pet. Convert that character value to an integer value.		
		lotteryArray[0] = (int)favoritePet.charAt(2);
		
		// Lottery Number 2
		// Use the two digit model year of their car and add their lucky number to it.
		lotteryArray[1] = carYear + luckyNumber;
		
		// Lottery Number 3
		// Use the random number between 1 and 50, subtracting by a random number with a range of 1 - 15.
		lotteryArray[2] = chosenNumber - (int)(Math.random() * 15) + 1;
		
		// Lottery Number 4
		// Convert the last letter of their favorite actor/actress to an integer and use that value
		lotteryArray[3] = (int)actorName.charAt(actorName.length() - 1);
		
		// Lottery Number 5
		// Pet age + lucky number minus a random number with a range of 1 - 18.
		lotteryArray[4] = petAge + luckyNumber - (int)(Math.random() * 18) + 1;
				
		// Loop through lottery array and make sure each number is less than max value of 65
		for(int x = 0; x < lotteryArray.length; x++) {
			lotteryArray[x] = validateNumberValue(lotteryArray[x], 65);
		}
		
		// Make sure magic ball number is less than max value of 75
		magicBall = validateNumberValue(magicBall, 75);
		
		int lotteryArrayWithoutDuplicates[] = eliminateDuplicateNums(lotteryArray);
		
		// Print out lottery numbers and magic ball number to user
		printLotteryNumbers(lotteryArrayWithoutDuplicates, magicBall);
	}
	
	// Function checks whether number is above max value
	// If so, the max number is subtracted from the number until the number is below the max value
	// The number is returned when it is less than the max value
	private static int validateNumberValue(int input, int maxValue) {
		while(input > maxValue) {
			input -= maxValue;
		}
		return input;
	}
	
	// Function checks array of lottery numbers for duplicate numbers
	// Any duplicate number is changed to a random number from 1 - 65
	// Loop continues until all duplicate numbers are removed and replaced with unique numbers
	private static int[] eliminateDuplicateNums(int[] array) {

		boolean duplicates;
			
		for(int x = 0; x < array.length; x++) {
			array[x] = (int)(Math.random() * 65);
		}		

		do {
			duplicates = false;
			for(int x = 0; x < array.length; x++) {
				for(int y = x + 1; y < array.length; y++) {
					if(array[x] == array[y]) {
						array[x] = (int)(Math.random() * 65);
					}
				}
			}
		} while(duplicates);
				
		return array;
	}
	
	// Print out lottery numbers and magic ball number to user
	private static void printLotteryNumbers(int[] array, int magicBall) {
		System.out.println("Lottery numbers: " + array[0] + ", " + array[1] + ", " + array[2] + ", " + array[3] + ", " + array[4] + " Magic Ball: " + magicBall);
	}
}
