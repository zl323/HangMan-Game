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
	 * Display the current word situation
	 */
	private char[] displayWord;
	
	/**
	 * range of words
	 */
	private ArrayList<String> wordList = new ArrayList<>();
	
	/**
	 * store guessed letter as an Arraylist
	 */
	private ArrayList<Character> guessedLetter = new ArrayList<>();
	
	/**
	 * store guessed incorrect letter as an Arraylist
	 */
	private ArrayList<Character> incorrectGuess = new ArrayList<>();
	
	/**
	 * @param wordList
	 */
	public Hangman(ArrayList<String> wordList) {
		this.wordList = wordList;
		this.word = randomWord();
		displayWord = new char[this.word.length()];
		for(int i = 0; i < this.word.length(); i++) {
			displayWord[i] = '_';
		}
		this.guessesRemaining = this.word.length() + 3;
	}
	
	/**
	 * @return a random word from the wordList
	 */
	public String randomWord() {
		Random rand = new Random();
		int index = rand.nextInt(wordList.size());
		return this.wordList.get(index);
	}
	
	/**
	 * @return remaining number of guess for user
	 */
	public int getGuessRemaining() {
		return this.guessesRemaining;
	}
	
	/**
	 * @param guessesRemaining
	 */
	public void setGuessRemaining(int guessesRemaining) {
		this.guessesRemaining = guessesRemaining;
	}
	
	/**
	 * @return wordList
	 */
	public ArrayList<String> getWordList() {
		return this.wordList;
	}
	
	/**
	 * @param wordList
	 */
	public void setWordList(ArrayList<String> wordList) {
		this.wordList = wordList;
	}
	
	/**
	 * @return the random word
	 */
	public String getWord() {
		return this.word;
	}
	
	/**
	 * @param word
	 */
	public void setWord(String word) {
		this.word = word;
	}
	
	/**
	 * @return the incorrect guess wordlist
	 */
	public ArrayList<Character> getIncorrectGuess() {
		return this.incorrectGuess;
	}
	
	/**
	 * @param guess
	 */
	public abstract void makeGuess(char guess);
	
	/**
	 * @param guess
	 * @return true if it has already been guessed or in the incorrect list
	 */
	public boolean alreadyGuessed(char guess) {
		if(guessedLetter.contains(guess) || incorrectGuess.contains(guess)) {
			return true;
		}else{
			return false;
		}
	}
	
	/**
	 * add guessed letter to the guessed wordlist
	 * @param guess
	 */
	public void GuessesMade(char guess) {
		if(!alreadyGuessed(guess)) {
			guessedLetter.add(guess);
		}
	}
	
	/**
	 * @return print current guessed word situation
	 */
	public char[] getDisplayWord() {
		return displayWord;
	}
	
	/**
	 * set current guessed word situation
	 * @param displayWord
	 */
	public void setDisplayWord(char[] displayWord) {
		this.displayWord = displayWord;
	}
	
	/**
	 * @return true if the game is over, else it returns false
	 */
	public boolean isGameOver() {
		boolean noDash = true;
		for(int i=0; i < displayWord.length; i++) {
			if(displayWord[i] == '_') {
				noDash = false;
			}
		}
		return (this.guessesRemaining == 0) || (noDash);
	}
	
	/**
	 * print current guess word situation and list incorrected wordlist
	 */
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
