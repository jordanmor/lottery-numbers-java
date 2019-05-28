package com.tts;

public class LotteryNumbers {
	public static void generate(String favoritePet, int petAge, int luckyNumber ,int carYear, String actorName, int chosenNumber) {

		System.out.println("Chosen numbers: " + favoritePet + ", " + petAge + ", " + luckyNumber + ", " + carYear + ", " + actorName + ", " + chosenNumber);
		// Magic Ball
		// Generate number by multiplying lucky number by random number with range of 1 - 12;
		int magicBall = luckyNumber * (int)(Math.random() * 12);
		
		int lotteryArray[] = new int[5];
		
		// Lottery Number 1
		// Find the 3rd letter of their favorite pet. Convert that character value to an integer value.		
		lotteryArray[0] = (int)favoritePet.charAt(2);
		
		// Lottery Number 2
		// Use the two digit model year of their car and add their lucky number to it.
		lotteryArray[1] = carYear + luckyNumber;
		
		// Lottery Number 3
		// Use the random number between 1 and 50, subtracting by a random number with a range of 1 - 15.
		lotteryArray[2] = chosenNumber - (int)(Math.random() * 15);
		
		// Lottery Number 4
		// Convert the last letter of their favorite actor/actress to an integer and use that value
		lotteryArray[3] = (int)actorName.charAt(actorName.length() - 1);
		
		// Lottery Number 5
		// Pet age + lucky number minus a random number with a range of 1 - 18.
		lotteryArray[4] = petAge + luckyNumber - (int)(Math.random() * 18);
		
		System.out.println("Lottery numbers: " + lotteryArray[0] + ", " + lotteryArray[1] + ", " + lotteryArray[2] + ", " + lotteryArray[3] + ", " + lotteryArray[4] + " Magic Ball: " + magicBall);
		
		for(int x = 0; x < lotteryArray.length; x++) {
			lotteryArray[x] = validateNumberValue(lotteryArray[x], 65);
		}
		
		magicBall = validateNumberValue(magicBall, 75);
		
		System.out.println("Lottery numbers: " + lotteryArray[0] + ", " + lotteryArray[1] + ", " + lotteryArray[2] + ", " + lotteryArray[3] + ", " + lotteryArray[4] + " Magic Ball: " + magicBall);
	}
	
	private static int validateNumberValue(int input, int maxValue) {
		while(input > maxValue) {
			input -= maxValue;
		}
		return input;
	}
}
