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
		//not guess yet
		assertEquals(10,evilGameTest.getGuessRemaining());
		// guessed correct
		evilGameTest.makeGuess('e');
		assertEquals(10,evilGameTest.getGuessRemaining());
		// guessed incorrect
		evilGameTest.makeGuess('c');
		assertEquals(9,evilGameTest.getGuessRemaining());
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
		// make incorrect guess
		evilGameTest.makeGuess('c');
		ArrayList<Character> testList = new ArrayList<>();
		testList.add('c');
		assertEquals(testList,evilGameTest.getIncorrectGuess());
				
		// make correct guess, 'e' shouldn't be added to the incorrect guess list
		evilGameTest.makeGuess('e');
		assertEquals(testList,evilGameTest.getIncorrectGuess());
	}

	/**
	 * Test method for {@link hangMan.Hangman#alreadyGuessed(char)}.
	 */
	@Test
	void testAlreadyGuessed() {
		//haven't made a guess before
		assertFalse(evilGameTest.alreadyGuessed('c'));
		//after making a guess
		evilGameTest.makeGuess('c');
		assertTrue(evilGameTest.alreadyGuessed('c'));
	}

	/**
	 * Test method for {@link hangMan.Hangman#GuessesMade(char)}.
	 */
	@Test
	void testGuessesMade() {
		//any guess hasn't been made yet
		assertFalse(evilGameTest.alreadyGuessed('a'));
		//made a guess
		evilGameTest.GuessesMade('a');
		assertTrue(evilGameTest.alreadyGuessed('a'));
	}

	/**
	 * Test method for {@link hangMan.Hangman#getGuessedLetter()}.
	 */
	@Test
	void testGetGuessedLetter() {
		// make incorrect guess
		ArrayList<Character> testList = new ArrayList<>();
		evilGameTest.makeGuess('c');
		testList.add('c');
		assertEquals(testList,evilGameTest.getGuessedLetter());
		// make correct guess
		evilGameTest.makeGuess('e');
		testList.add('e');
		assertEquals(testList,evilGameTest.getGuessedLetter());
	}
	
	/**
	 * Test method for {@link hangMan.Hangman#getDisplayWord()}.
	 */
	@Test
	void testGetDisplayWord() {
		//initial guessed situation
		char[] testDisp = {'_','_','_','_','_'};
		assertTrue(Arrays.equals(testDisp, evilGameTest.getDisplayWord()));
		//after taking a guess of 'c', which is incorrect, doesn't change the current word display
		evilGameTest.makeGuess('c');
		assertTrue(Arrays.equals(testDisp, evilGameTest.getDisplayWord()));
		//after taking a guess of 'e', which is correct, change the current word display
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
