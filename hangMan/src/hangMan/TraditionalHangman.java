/**
 * 
 */
package hangMan;

import java.util.ArrayList;

/**
 * @author zhiyuanli
 *
 */
public class TraditionalHangman extends Hangman {

	/**
	 * constructor of Traditional Hangman
	 * @param wordList
	 */
	public TraditionalHangman(ArrayList<String> wordList) {
		super(wordList);
	}

	/* check if the guessed letter has already been guessed before, if it has, return void
	 * Otherwise, check if used make the right guess. If the guess is correct, update displayWord array
	 * else, number of remaining guess - 1, add incorrect guess to the incorrect list
	 * @see hangMan.Hangman#makeGuess(char)
	 */
	@Override
	public void makeGuess(char guess) {
		if(this.alreadyGuessed(guess)) {
			System.out.println("You already guessed this letter. Please take another one");
			return;
		}else {
			int numGuess = this.getGuessRemaining();
			this.setGuessRemaining(numGuess);
			this.GuessesMade(guess);
			char[] wordArray = this.getWord().toCharArray();
			if(this.getWord().indexOf(guess) != -1) {
				for(int i = 0; i < this.getDisplayWord().length; i++) {
					if(wordArray[i] == guess) {
						this.getDisplayWord()[i] = guess;
					}
				}
			}else {
				this.getIncorrectGuess().add(guess);
				numGuess--;
				this.setGuessRemaining(numGuess);
			}

		}
	}

}
