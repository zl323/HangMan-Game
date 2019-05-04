/**
 * 
 */
package hangMan;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author zhiyuanli
 *
 */
public class FileReader {
	private String filename;

	public FileReader(String filename) {
		this.filename = filename;
	}

	public String getFileName() {
		return this.filename;
	}
	/**
	 * read content in a file and clean content line by line
	 * example : "    hello world    " -> "hello world"
	 * @return a list of string with no empty space at head or end
	 */
	
	public ArrayList<String> getCleanContent() {
		ArrayList<String> wordList = new ArrayList<>();
		try {
			Scanner input = new Scanner(new File(filename));
			while(input.hasNextLine()) {
				String line = input.nextLine().trim();
				if(checkWord(line)) {
					wordList.add(line);
				}
			}
			input.close();
		}catch(FileNotFoundException error) {
			System.out.println("File is not found.");
			error.printStackTrace();;
		}
		
		return wordList;
	}
	
	/**
	 * clean the word in the dictionary
	 * @param word
	 * @return a list of valid word 
	 */
	public boolean checkWord(String word) {
		char[] wordArray = word.toCharArray();
		for(char e : wordArray) {
			if(Character.isDigit(e)) {
				return false;
			}
			if(Character.isUpperCase(e)) {
				return false;
			}
		}
		if(word.contains(" ") || word.contains("-") || word.contains(".") || word.contains("'")) {
			return false;
		}
		return true;
	}
}
