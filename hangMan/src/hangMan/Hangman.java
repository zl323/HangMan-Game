/**
 * 
 */
package hangMan;

import java.util.*;

/**
 * @author zhiyuanli
 *
 */
public abstract class Hangman {
	/**
	 * number of guesses remaining
	 */
	private int guessesRemaining;
	
	/**
	 * the private word picked by computer
	 */
	private String word;
	
	/**
	 * Display the resultant word in array of Character
	 */
	private char[] displayWord;
	
	private ArrayList<String> wordList = new ArrayList<>();
	
	private ArrayList<Character> guessedLetter = new ArrayList<>();
	
	private ArrayList<Character> incorrectGuess = new ArrayList<>();
	
	public Hangman(ArrayList<String> wordList) {
		this.wordList = wordList;
		this.word = randomWord();
		displayWord = new char[this.word.length()];
		for(int i = 0; i < this.word.length(); i++) {
			displayWord[i] = '_';
		}
		this.guessesRemaining = this.word.length() + 3;
	}
	
	public String randomWord() {
		Random rand = new Random();
		int index = rand.nextInt(wordList.size());
		return this.wordList.get(index);
	}
	
	public int getGuessRemaining() {
		return this.guessesRemaining;
	}
	
	public void setGuessRemaining(int guessesRemaining) {
		this.guessesRemaining = guessesRemaining;
	}
	
	public ArrayList<String> getWordList() {
		return this.wordList;
	}
	
	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}
	
	public String getWord() {
		return this.word;
	}
	
	public void setWord(String word) {
		this.word = word;
	}
	
	public ArrayList<Character> getIncorrectGuess() {
		return this.incorrectGuess;
	}
	
	public abstract void makeGuess(char guess);
	
	public boolean alreadyGuessed(char guess) {
		return guessedLetter.contains(guess)? true:false;
	}
	
	public void GuessesMade(char guess) {
		if(!alreadyGuessed(guess)) {
			guessedLetter.add(guess);
		}
	}
	
	public char[] getDisplayWord() {
		return displayWord;
	}
	
	public void setDisplayWord(char[] displayWord) {
		this.displayWord = displayWord;
	}
	
	public boolean isGameOver() {
		boolean noDash = true;
		for(int i=0; i < displayWord.length; i++) {
			if(displayWord[i] == '_') {
				noDash = false;
			}
		}
		return (this.guessesRemaining == 0) || (noDash);
	}
	
	public void print() {
		
		for(int i = 0; i < this.displayWord.length; i++) {
			System.out.print(this.displayWord[i] + " ");
		}
		System.out.println();
		
		if( this.getIncorrectGuess().size() >= 1 ) {
			System.out.print("Incorrect Guesses : [");
			int i;
			for(i = 0;i < this.getIncorrectGuess().size()-1; i++ ) {
				System.out.print(this.getIncorrectGuess().get(i)+", ");
			}
			System.out.println(this.getIncorrectGuess().get(i)+"]");
		}
		
	}
	
	public void winOrLose() {
		boolean win = true;
		if(this.isGameOver()) {
			for(char e: this.displayWord){
				if(e == '_') {
					win = false;
				}
			}
		}
		if(win) {
			System.out.println("You WIN! " + this.word + " is the correct word.");
		}else {
			System.out.println("Sorry, used all the guesses, you LOSE the game!");
			System.out.println("The correct word is: " + this.word);
		}
	}
}
