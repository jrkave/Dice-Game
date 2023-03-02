package mypack;
import java.util.ArrayList;

public class DiceCup {
	private ArrayList<MyDie> dice;
	private int creditBalance;
	
	public DiceCup(int num) {
		creditBalance = 10;
		dice = new ArrayList<MyDie>();
		if (num == 6) {
			while (dice.size() != 3) {
				dice.add(new SixDie());
			}
		}
		else if (num == 8) {
			while(dice.size() != 3) {
				dice.add(new EightDie());
			}
		}
	}
	
	// Accessor Methods
	public int getCredits() {
		return creditBalance;
	}
	
	public ArrayList<MyDie> getDice() {
		return dice;
	}
	
	public void roll() {
		for (int i = 0; i < dice.size(); i++) {
			dice.get(i).roll();
		}
	}
	
	public int getTotal() {
		int sum = 0;
		for (int i = 0; i < dice.size(); i++) {
			sum += dice.get(i).getValue();
		}
		return sum;
	}
	
	public void checkTriplets() {
		int sameNum = 0;
		for (int i = 0; i < dice.size(); i++) {
			if (dice.get(0).getValue() == dice.get(i).getValue()) {
				sameNum += 1;
			}
		}
		if (sameNum == 3) {
			creditBalance += 1;
		}
	}
	
	public void checkDoubles() {
		int val0 = dice.get(0).getValue();
		int val1 = dice.get(1).getValue();
		int val2 = dice.get(2).getValue();
	
		if (val0 == val1 || val0 == val2 || val1 == val2) {
			creditBalance += 1;
		}
	}	
	
	public void checkLarge() {
		if (getTotal() >= 10) {
			creditBalance += 1;
		}
	}
	
	public void updateCredits() {
		if (creditBalance >= 1) {
			checkTriplets();
			checkDoubles();
			checkLarge();
			creditBalance -= 1;
		}
	}
	
	public boolean enoughCredits() {
		if (creditBalance >= 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public void testRoll(int [] values) {
		if (creditBalance >= 1) {
			creditBalance -= 1;
			boolean notSame = true;
			while (notSame) {
				if ((dice.get(0).getValue() == values[0]) && (dice.get(1).getValue() == values[1]) && (dice.get(2).getValue() == values[2])) {
					notSame = false;
				}
				else {
					roll();
				}
			}
		}
	}
}

