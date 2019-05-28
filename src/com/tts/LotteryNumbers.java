package com.tts;

public class LotteryNumbers {
	public static void generate(String favoritePet, int petAge, int luckyNumber ,int carYear, String actorName, int chosenNumber) {
		final int MAX_RANDOM_NUMBER = 65;
		final int MAX_MAGIC_BALL = 75;

		// Magic Ball
		// Generate number by multiplying lucky number by random number with range of 1 - 12;
		int magicBall = luckyNumber * (int)(Math.random() * 12);
		if(magicBall > MAX_MAGIC_BALL) {
			magicBall -= MAX_MAGIC_BALL;
		}
		
		// Lottery Number 1
		// Find the 3rd letter of their favorite pet. Convert that character value to an integer value.		
		int lotteryNumOne = (int)favoritePet.charAt(2);
		
		// Lottery Number 2
		// Use the two digit model year of their car and add their lucky number to it.
		int lotteryNumTwo = carYear + luckyNumber;
		
		// Lottery Number 3
		// Use the random number between 1 and 50, subtracting by a random number with a range of 1 - 15.
		int lotteryNumThree = chosenNumber - (int)(Math.random() * 15);
		
		// Lottery Number 4
		// Convert the last letter of their favorite actor/actress to an integer and use that value
		int lotteryNumFour = (int)actorName.charAt(actorName.length() - 1);
		
		// Lottery Number 5
		// Pet age + lucky number minus a random number with a range of 1 - 18.
		int lotteryNumFive = petAge + luckyNumber - (int)(Math.random() * 18);
		
		System.out.println("Lottery numbers: " + lotteryNumOne + ", " + lotteryNumTwo + ", " + lotteryNumThree + ", " + lotteryNumFour + ", " + lotteryNumFive + " Magic Ball: " + magicBall);
	}
}
