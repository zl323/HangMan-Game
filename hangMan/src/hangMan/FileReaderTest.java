/**
 * 
 */
package hangMan;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * @author zhiyuanli
 *
 */
class FileReaderTest {
	String filename;
	FileReader fileTest;
	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
		filename = "wordTest.txt";
		fileTest = new FileReader(filename);
	}

	/**
	 * Test method for {@link hangMan.FileReader#FileReader(java.lang.String)}.
	 */
	@Test
	void testFileReader() {
		assertEquals(filename, fileTest.getFileName());
	}

	/**
	 * Test method for {@link hangMan.FileReader#getFileName()}.
	 */
	@Test
	void testGetFileName() {
		assertEquals("wordTest.txt", fileTest.getFileName());
	}
	/**
	 * Test method for {@link hangMan.FileReader#getCleanContent()}.
	 */
	@Test
	void testGetCleanContent() {
		ArrayList<String> testList = new ArrayList<>();
		testList.add("apple");
		testList.add("tree");
		testList.add("baby");
		ArrayList<String> wordList = new ArrayList<>();
		wordList = fileTest.getCleanContent();
		assertEquals(testList,wordList);
	}

	/**
	 * Test method for {@link hangMan.FileReader#checkWord(java.lang.String)}.
	 */
	@Test
	void testCheckWord() {
		assertFalse(fileTest.checkWord("Tree"));
		assertFalse(fileTest.checkWord("t-ree"));
		assertFalse(fileTest.checkWord("t ree"));
		assertFalse(fileTest.checkWord("tr'ee"));
		assertFalse(fileTest.checkWord("baby."));
		assertFalse(fileTest.checkWord("3ree"));
		assertTrue(fileTest.checkWord("tree"));
	}

}
