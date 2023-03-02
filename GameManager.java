package mypack;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GameManager {
	private DiceCup diceCup;

	public GameManager(int num) {
		diceCup = new DiceCup(num);
	}
	
	public String toString() {
		return "Dice 1 = " + diceCup.getDice().get(0).getValue() + "\n" + 
			   "Dice 2 = " + diceCup.getDice().get(1).getValue() + "\n" + 
			   "Dice 3 = " + diceCup.getDice().get(2).getValue() + "\n" + 
			   "Total Sum of Dice: " + diceCup.getTotal() + "\n" + 
			   "Credits afer bet: " + diceCup.getCredits();
	}
	
	public DiceCup getDice() {
		return diceCup;
	}
	
	public static void main(String[] args) {
		Scanner scnr = new Scanner(System.in);
		int dieChoice = 0;

		// Get user input
		System.out.println("Would you like to play with a 6 or 8 die?");
		boolean validNum = false;
		boolean isNum = false;
		while (!isNum || !validNum) {
    		try {
        		dieChoice = scnr.nextInt();
        		isNum = true;
        		if (dieChoice == 8 || dieChoice == 6) {
            		validNum = true;
        		} else {
            		System.out.println("Invalid choice. Please enter 6 or 8.");
            		scnr.nextLine(); // consume the invalid input
            		isNum = false;
        		}
    		} catch (InputMismatchException e) {
        		System.out.println("Invalid input. Please enter a number.");
        		scnr.nextLine(); // consume the invalid input
    		}
		}

		// Instantiate object of GameManager class
		GameManager game = new GameManager(dieChoice);
		String playAgain = "roll";

		while (!playAgain.equals("stop")) {
			System.out.println("To play, enter any letter. To stop, type 'stop'.");
			playAgain = scnr.next();
			if (playAgain.equals("stop")) {
				break;
			}

			if (game.diceCup.enoughCredits() == false) {
				System.out.println("Not enough credits to play.");
			}
			else {
				game.diceCup.roll();
				game.diceCup.updateCredits();
				System.out.println(game.toString());
			}
		}
	}
}
	/* 
	// Test testRoll() function
	int[] newArray = new int[] {1, 2, 3};
	game.diceCup.testRoll(newArray); // check testRoll function
	System.out.println(game.toString());
	*/