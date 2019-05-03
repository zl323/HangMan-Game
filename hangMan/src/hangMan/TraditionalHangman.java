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
	 * @param wordList
	 */
	public TraditionalHangman(ArrayList<String> wordList) {
		super(wordList);
	}

	/* (non-Javadoc)
	 * @see hangMan.Hangman#makeGuess(char)
	 */
	@Override
	public void makeGuess(char guess) {
		// TODO Auto-generated method stub 
		if(this.alreadyGuessed(guess)) {
			System.out.println("You already guessed this letter. Please take another one");
			return;
		}else {
			int numGuess = this.getGuessRemaining();
			this.setGuessRemaining(numGuess);
			char[] wordArray = this.getWord().toCharArray();
			if(this.getWord().indexOf(guess) != -1) {
				for(int i = 0; i < this.getDisplayWord().length; i++) {
					if(wordArray[i] == guess) {
						this.getDisplayWord()[i] = guess;
					}
				}
				this.GuessesMade(guess);
			}else {
				this.getIncorrectGuess().add(guess);
				numGuess--;
				this.setGuessRemaining(numGuess);
			}
		}
	}

}
