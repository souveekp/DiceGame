import java.util.Random;
import java.util.Scanner;

class Dice{
	private final int SIDES = 6;
	Random randomDiceValue = new Random();
	int roll(){
		int diceValue = randomDiceValue.nextInt(SIDES) + 1;
		return diceValue;
	}
}