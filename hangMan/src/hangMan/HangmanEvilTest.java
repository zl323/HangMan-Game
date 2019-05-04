/**
 * 
 */
package hangMan;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author zhiyuanli
 *
 */
class HangmanEvilTest {
	
	Hangman evilGameTest;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		ArrayList<String> wordList = new ArrayList<>();
		wordList.add("apple");
		wordList.add("hinge");
		wordList.add("froze");
		evilGameTest = new EvilHangman(wordList);
	}

	/**
	 * Test method for {@link hangMan.Hangman#getGuessRemaining()}.
	 */
	@Test
	void testGetGuessRemaining() {
		assertEquals(10,evilGameTest.getGuessRemaining());
	}

	/**
	 * Test method for {@link hangMan.Hangman#setGuessRemaining(int)}.
	 */
	@Test
	void testSetGuessRemaining() {
		evilGameTest.setGuessRemaining(8);
		assertEquals(8,evilGameTest.getGuessRemaining());
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
		
		assertEquals(testList,new HashSet<String>(evilGameTest.getWordList()));
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
		evilGameTest.setWordList(testList);
		assertEquals(testList,evilGameTest.getWordList());
	}

	/**
	 * Test method for {@link hangMan.Hangman#getWord()}.
	 */
	@Test
	void testGetWord() {
		assertTrue("apple".equals(evilGameTest.getWord())||"hinge".equals(evilGameTest.getWord())||"forze".equals(evilGameTest.getWord()));
	}

	/**
	 * Test method for {@link hangMan.Hangman#setWord(java.lang.String)}.
	 */
	@Test
	void testSetWord() {
		evilGameTest.setWord("paper");
		assertEquals("paper",evilGameTest.getWord());
	}

	/**
	 * Test method for {@link hangMan.Hangman#getIncorrectGuess()}.
	 */
	@Test
	void testGetIncorrectGuess() {
		evilGameTest.makeGuess('c');
		ArrayList<Character> testList = new ArrayList<>();
		testList.add('c');
		assertEquals(testList,evilGameTest.getIncorrectGuess());
	}

	/**
	 * Test method for {@link hangMan.Hangman#alreadyGuessed(char)}.
	 */
	@Test
	void testAlreadyGuessed() {
		assertFalse(evilGameTest.alreadyGuessed('c'));
		evilGameTest.makeGuess('c');
		assertTrue(evilGameTest.alreadyGuessed('c'));
	}

	/**
	 * Test method for {@link hangMan.Hangman#GuessesMade(char)}.
	 */
	@Test
	void testGuessesMade() {
		assertFalse(evilGameTest.alreadyGuessed('a'));
		evilGameTest.GuessesMade('a');
		assertTrue(evilGameTest.alreadyGuessed('a'));
	}

	/**
	 * Test method for {@link hangMan.Hangman#getDisplayWord()}.
	 */
	@Test
	void testGetDisplayWord() {
		char[] testDisp = {'_','_','_','_','_'};
		assertTrue(Arrays.equals(testDisp, evilGameTest.getDisplayWord()));
		evilGameTest.makeGuess('c');
		assertTrue(Arrays.equals(testDisp, evilGameTest.getDisplayWord()));
		evilGameTest.makeGuess('e');
		testDisp[4] = 'e';
		assertTrue(Arrays.equals(testDisp, evilGameTest.getDisplayWord()));
	}

	/**
	 * Test method for {@link hangMan.Hangman#setDisplayWord(char[])}.
	 */
	@Test
	void testSetDisplayWord() {
		char[] testDisp = {'_','_','_','_','_'};
		assertTrue(Arrays.equals(testDisp, evilGameTest.getDisplayWord()));
		char[] testDisp2 = {'_','_','_','_','e'};
		evilGameTest.setDisplayWord(testDisp2);
		assertTrue(Arrays.equals(testDisp2, evilGameTest.getDisplayWord()));
	}

}
