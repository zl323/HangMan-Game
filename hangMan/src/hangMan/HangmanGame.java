/**
 * 
 */
package hangMan;

import java.util.*;

/**
 * @author zhiyuanli
 *
 */
public class HangmanGame {

	private boolean runGame = true;
	
	public Hangman hangmanSetting(ArrayList<String> cleanList) {
		Random random = new Random();
		int choice = random.nextInt(1);
		//if(choice == 1) {
			//return new TraditionalHangman(cleanList);
		//}else {
			return new EvilHangman(cleanList);
		//}
	}
	// solve duplicate input
	public void initializeGame() {
		FileReader file = new FileReader("words.txt");
		ArrayList<String> cleanWordList = new ArrayList<>();
		cleanWordList = file.getCleanContent();
		
		Scanner scanner = new Scanner(System.in);
		while(this.runGame) {
			
			System.out.println("Welcome to Hangman Game!");
			System.out.print("Press 'q' and Enter to quit. Else, please press Enter to start: ");
			String input = scanner.nextLine();
			if(input.equals("q") || input.equals("Q")) {
				this.runGame = false;
			}else {
				Hangman gameMode = hangmanSetting(cleanWordList);
				System.out.println("You are going to have " + gameMode.getGuessRemaining()+" times of guessing");
				while(!gameMode.isGameOver()) {
					System.out.println("Guess Remaining: "+ gameMode.getGuessRemaining());
					gameMode.print();
					System.out.print("Guess a Letter :");
					String guess = scanner.nextLine().toLowerCase();
					while(guess.isEmpty()) {
						System.out.print("Please re-Enter. Guess a Letter :");
						guess = scanner.nextLine().toLowerCase();
					}
					gameMode.makeGuess(guess.charAt(0));
					//System.out.println("Here: "+gameMode.getGuessRemaining());
				}
				gameMode.print();
				gameMode.winOrLose();
				System.out.print("Do you want to play the game again?(y for yes, n for no) Please answer:");
				String answer = scanner.nextLine();
				System.out.println();
				if(answer.equals("n") || answer.equals("N")) {
					this.runGame = false;
					System.out.print("Thank you for playing!");
				}
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HangmanGame newGame = new HangmanGame();
		newGame.initializeGame();
	}

}
