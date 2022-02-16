
package WordLadders;

import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

abstract class LadderGame {

	protected ArrayList<ArrayList<String>> organizedWords;
	protected ArrayList<String> unorganizedWords;

	abstract ArrayList<String> play(String start, String end);
    // abstract ArrayList<String> listWords(int length, int howMany);
	// abstract ArrayList<String> oneAway(String word);

	/*
	 * Reads a list of words from a file, putting all words of the same length
	 * into the same array.
	 */
	protected void readDictionary(String dictionaryFile) {
		File file = new File(dictionaryFile);
		this.organizedWords = new ArrayList<>();
		this.unorganizedWords = new ArrayList<>();

		// Track the longest word, because that tells us how big to make the
		// array.
		int longestWord = 0;
		try (Scanner input = new Scanner(file)) {
			//
			// Start by reading all the words into memory.
			while (input.hasNextLine()) {
				String word = input.nextLine().toLowerCase();
				unorganizedWords.add(word);
				longestWord = Math.max(longestWord, word.length());
			}

			// DONE: You need to do something here to organize the words into
			// groups/arrays of words with the same size
			ArrayList<ArrayList<String>> organizedWords = new ArrayList<ArrayList<String>>(longestWord);
			for (int i = 0; i <= longestWord; i++) {
				organizedWords.add(new ArrayList<String>());
			}
			for (String word : unorganizedWords) {
				organizedWords.get(word.length()).add(word);
			}

			this.organizedWords = organizedWords;

		} catch (java.io.IOException ex) {
			System.out.println("An error occurred trying to read the dictionary: " + ex);
		}
	}

	/*
	 * List all words that are one character different from the given word
	 * //! I have decided to move the functionality of the withRemoval directly to
	 * //! the LadderGame Class becuase instead of removing the values from the
	 * //! dictionary and keeping a copy I just chose to keep a history of the
	 * //! previously visited values.
	 */
	public ArrayList<String> oneAway(String word) {
		// DONE: Write some good stuff here
		int length = word.length();
		ArrayList<String> words = this.organizedWords.get(length);
		ArrayList<String> oneAway = new ArrayList<String>();

		// Loop through all words of the size of the word
		for (int wordIndex = 0; wordIndex < words.size(); wordIndex++) {
			String string = words.get(wordIndex);
			int count = 0;

			// Loop through all chars of that word and track num of differences
			for (int charIndex = 0; charIndex < length; charIndex++) {
				if (word.charAt(charIndex) != string.charAt(charIndex)) {
					count += 1;
				}
			}

			// If the words differ by one add the string to the list
			if (count == 1) {
				oneAway.add(string);
			}
		}
		return oneAway;
	}

	/*
	 * Return and print the first howMany words of size length from the
	 * pre-organized words
	 */
	public ArrayList<String> listWords(int length, int howMany) {
		// DONE: Write some good stuff here
		ArrayList<String> words = new ArrayList<>();
		for (int i = 0; i < howMany; i++) {
			words.add(this.organizedWords.get(length).get(i));
		}
		System.out.println(words);
		return words;
	}
}
