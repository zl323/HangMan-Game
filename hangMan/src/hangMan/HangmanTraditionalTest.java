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
		gameTest.makeGuess('c');
		ArrayList<Character> testList = new ArrayList<>();
		testList.add('c');
		assertEquals(testList,gameTest.getIncorrectGuess());
	}

	/**
	 * Test method for {@link hangMan.Hangman#alreadyGuessed(char)}.
	 */
	@Test
	void testAlreadyGuessed() {
		assertFalse(gameTest.alreadyGuessed('c'));
		gameTest.makeGuess('c');
		assertTrue(gameTest.alreadyGuessed('c'));
		
	}

	/**
	 * Test method for {@link hangMan.Hangman#GuessesMade(char)}.
	 */
	@Test
	void testGuessesMade() {
		assertFalse(gameTest.alreadyGuessed('a'));
		gameTest.GuessesMade('a');
		assertTrue(gameTest.alreadyGuessed('a'));
	}

	/**
	 * Test method for {@link hangMan.Hangman#getDisplayWord()}.
	 */
	@Test
	void testGetDisplayWord() {
		char[] testDisp = {'_','_','_','_','_'};
		assertTrue(Arrays.equals(testDisp, gameTest.getDisplayWord()));
		gameTest.makeGuess('c');
		assertTrue(Arrays.equals(testDisp, gameTest.getDisplayWord()));
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
