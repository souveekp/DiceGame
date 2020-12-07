import java.util.Random;
import java.util.Scanner;

public class DiceGame{
	Player p1,p2;
	Dice dice;
	static DiceGame game;
	void displayGameOption(){
		System.out.println("Please choose one of the below options.");
		System.out.println("1:Play New Game");
		System.out.println("2:Exit");
	}
	void selectGameOption(){
		int optionSelected = 0;
		Scanner sc = new Scanner(System.in);
		try{
			optionSelected = sc.nextInt();
			while(true){
			if(optionSelected < 1 || optionSelected > 2){
				System.out.println("Invalid Input.");
				this.displayGameOption();
				optionSelected = sc.nextInt();
			}
			else
				break;
			}
		}
		catch(Exception e){
			System.out.println("Invalid Input.");
			this.displayGameOption();
			this.selectGameOption();
		}
		switch(optionSelected){
			case 1:
				this.startNewGame();
				this.playOneRound(p1);
				this.playOneRound(p2);
				this.checkWinner(p1,p2);
				break;
			case 2:
				System.out.println("Exiting from Game");
				break;
		}
	}

	void startNewGame(){
		p1 = new Player();
		p1.setName("Player 1");
		p2 = new Player();
		p2.setName("Player 2");
		dice = new Dice();
	}

	void playOneRound(Player p){
		Scanner sc = new Scanner(System.in);
		System.out.println(p.getName()+" please press Enter key to roll first die");
		sc.nextLine();
		int firstRoll = dice.roll();
		System.out.println("Rolled Value: "+firstRoll);
		System.out.println(p.getName()+" please press Enter key to roll second die");
		sc.nextLine();
		int secondRoll = dice.roll();
		System.out.println("Rolled Value: "+secondRoll);
		int total = firstRoll+secondRoll;
		p.setScore(total);
		System.out.println("Total is: "+total);
	}

	void checkWinner(Player p1, Player p2){
		if(p1.getScore() == 7 && p2.getScore() == 7)
			System.out.println("Its A DRAW. Both got 7");
		else if(p1.getScore() == 7)
			System.out.println(p1.getName()+" WINS. "+p2.getName()+" LOSES");
		else if(p2.getScore() == 7)
			System.out.println(p2.getName()+" WINS. "+p1.getName()+" LOSES");
		else
			System.out.println("NO WINNER. Its a tie as none got 7");
		game.displayGameOption();
		game.selectGameOption();
	}
	
	public static void main(String[] args) {
		System.out.println("Welcome to 2 Player Dice Game");
		game = new DiceGame();
		game.displayGameOption();
		game.selectGameOption();
	}
}