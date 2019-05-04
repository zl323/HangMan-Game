/**
 * 
 */
package hangMan;

import java.util.*;

/**
 * @author zhiyuanli
 *
 */
public class EvilHangman extends Hangman {

	/**
	 * constructor of Evil Hangman
	 * @param wordList
	 */
	public EvilHangman(ArrayList<String> wordList) {
		super(wordList);
		int wordLength = this.getWord().length();
		ArrayList<String> newCleanList = new ArrayList<>();
		for(String e : wordList) {
			if(e.length() == wordLength) {
				newCleanList.add(e);
			}
		}
		this.setWordList(newCleanList);
		int guess = this.getGuessRemaining();
		this.setGuessRemaining(guess+2);
	}

	/* check if the guessed letter has already been guessed before, if it has, return void
	 * Otherwise, record the guessed letter and group the wordList with the guess
	 * Then find the largest set of the current guess family so that users have less chance to get the correct guess
	 * Update the largest set to wordList instance variable, update the chosen word in the set
	 * Next, check if used make the right guess. If the guess is correct, update displayWord array
	 * else, number of remaining guess - 1, add incorrect guess to the incorrect list
	 * 
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
			String currDisplay = new String(this.getDisplayWord());
			//char[] prevDisplay = currDisplay;
			HashMap<String,HashSet<String>> guessSet = new HashMap<>();
			//group the word with guesses
			for(String word:this.getWordList()) {
				char[] temp = currDisplay.toCharArray();
				for(int i = 0; i < word.length(); i++) {
					if(word.charAt(i) == guess) {
						temp[i] = guess;
					}
				}
				String tempDisplay = new String(temp);
				if(guessSet.containsKey(tempDisplay)) {
					guessSet.get(tempDisplay).add(word);
				}else {
					HashSet<String> wordSet = new HashSet<>();
					wordSet.add(word);
					guessSet.put(tempDisplay, wordSet);
				}
			}
			
			//find the largest set of guess family
			HashSet<String> maxSet = new HashSet<String>();
			for(String key:guessSet.keySet()) {
				HashSet<String> set= guessSet.get(key);
				if (set.size()>maxSet.size()){
					maxSet = set;
					this.setDisplayWord(key.toCharArray());
				}
			}
			
			// set the largest set to wordList instance variable
			this.setWordList(new ArrayList<String>(maxSet));
			this.setWord(randomWord());
			if(currDisplay.equals(new String(this.getDisplayWord()))) {
				numGuess--;
				this.setGuessRemaining(numGuess);
				this.getIncorrectGuess().add(guess);
			}
		}
	}

}
