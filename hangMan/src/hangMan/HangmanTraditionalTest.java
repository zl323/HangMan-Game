/**
 * 
 */
package hangMan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author zhiyuanli
 *
 */
class HangmanTraditionalTest {

	Hangman gameTest;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<String> wordList = new ArrayList<>();
		wordList.add("apple");
		wordList.add("hinge");
		wordList.add("froze");
		gameTest = new TraditionalHangman(wordList);
	}

	/**
	 * Test method for {@link hangMan.Hangman#getGuessRemaining()}.
	 */
	@Test
	void testGetGuessRemaining() {
		//not guess yet
		assertEquals(8,gameTest.getGuessRemaining());
		// guessed correct
		gameTest.makeGuess('e');
		assertEquals(8,gameTest.getGuessRemaining());
		// guessed incorrect
		gameTest.makeGuess('c');
		assertEquals(7,gameTest.getGuessRemaining());
	}

	/**
	 * Test method for {@link hangMan.Hangman#setGuessRemaining(int)}.
	 */
	@Test
	void testSetGuessRemaining() {
		gameTest.setGuessRemaining(6);
		assertEquals(6,gameTest.getGuessRemaining());
	}

	/**
	 * Test method for {@link hangMan.Hangman#getWordList()}.
	 */
	@Test
	void testGetWordList() {
		Set<String> testList = new HashSet<>();
		testList.add("apple");
		testList.add("hinge");
		testList.add("froze");
		
		assertEquals(testList,new HashSet<String>(gameTest.getWordList()));
	}

	/**
	 * Test method for {@link hangMan.Hangman#setWordList(java.util.ArrayList)}.
	 */
	@Test
	void testSetWordList() {
		ArrayList<String> testList = new ArrayList<>();
		testList.add("play");
		testList.add("junk");
		testList.add("bell");
		gameTest.setWordList(testList);
		assertEquals(testList,gameTest.getWordList());
	}

	/**
	 * Test method for {@link hangMan.Hangman#getWord()}.
	 */
	@Test
	void testGetWord() {
		assertTrue("apple".equals(gameTest.getWord())||"hinge".equals(gameTest.getWord())||"forze".equals(gameTest.getWord()));
	}

	/**
	 * Test method for {@link hangMan.Hangman#setWord(java.lang.String)}.
	 */
	@Test
	void testSetWord() {
		gameTest.setWord("paper");
		assertEquals("paper",gameTest.getWord());
	}

	/**
	 * Test method for {@link hangMan.Hangman#getIncorrectGuess()}.
	 */
	@Test
	void testGetIncorrectGuess() {
		// make incorrect guess
		gameTest.makeGuess('c');
		ArrayList<Character> testList = new ArrayList<>();
		testList.add('c');
		assertEquals(testList,gameTest.getIncorrectGuess());
		
		// make correct guess, 'e' shouldn't be added to the incorrect guess list
		gameTest.makeGuess('e');
		assertEquals(testList,gameTest.getIncorrectGuess());
	}

	/**
	 * Test method for {@link hangMan.Hangman#alreadyGuessed(char)}.
	 */
	@Test
	void testAlreadyGuessed() {
		//haven't made a guess before
		assertFalse(gameTest.alreadyGuessed('c'));
		//after making a guess
		gameTest.makeGuess('c');
		assertTrue(gameTest.alreadyGuessed('c'));
		
	}

	/**
	 * Test method for {@link hangMan.Hangman#GuessesMade(char)}.
	 */
	@Test
	void testGuessesMade() {
		//any guess hasn't been made yet
		assertFalse(gameTest.alreadyGuessed('a'));
		//made a guess
		gameTest.GuessesMade('a');
		assertTrue(gameTest.alreadyGuessed('a'));
	}
	
	/**
	 * Test method for {@link hangMan.Hangman#getGuessedLetter()}.
	 */
	@Test
	void testGetGuessedLetter() {
		// make incorrect guess
		ArrayList<Character> testList = new ArrayList<>();
		gameTest.makeGuess('c');
		testList.add('c');
		assertEquals(testList,gameTest.getGuessedLetter());
		// make correct guess
		gameTest.makeGuess('e');
		testList.add('e');
		assertEquals(testList,gameTest.getGuessedLetter());
	}

	/**
	 * Test method for {@link hangMan.Hangman#getDisplayWord()}.
	 */
	@Test
	void testGetDisplayWord() {
		//initial guessed situation
		char[] testDisp = {'_','_','_','_','_'};
		assertTrue(Arrays.equals(testDisp, gameTest.getDisplayWord()));
		//after taking a guess of 'c', which is incorrect, doesn't change the current word display
		gameTest.makeGuess('c');
		assertTrue(Arrays.equals(testDisp, gameTest.getDisplayWord()));
		//after taking a guess of 'e', which is correct, change the current word display
		gameTest.makeGuess('e');
		testDisp[4] = 'e';
		assertTrue(Arrays.equals(testDisp, gameTest.getDisplayWord()));
	}

	/**
	 * Test method for {@link hangMan.Hangman#setDisplayWord(char[])}.
	 */
	@Test
	void testSetDisplayWord() {
		char[] testDisp = {'_','_','_','_','_'};
		assertTrue(Arrays.equals(testDisp, gameTest.getDisplayWord()));
		char[] testDisp2 = {'_','_','_','_','e'};
		gameTest.setDisplayWord(testDisp2);
		assertTrue(Arrays.equals(testDisp2, gameTest.getDisplayWord()));
	}

}
