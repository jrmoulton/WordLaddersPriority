
package WordLadders;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class LadderGame {
	private ArrayList<ArrayList<String>> organizedWords;
	private ArrayList<String> unorganizedWords;
	public boolean withRemoval = true;
	private int totalEnqueues = 0;

	public LadderGame(String dictionaryFile) {
		readDictionary(dictionaryFile);
	}

	/*
	 * Print a Word Ladder from start word to end word
	 */
	public ArrayList<String> play(String start, String end) {
		// DONE: Write some good stuff here
		ArrayList<String> usedWords = new ArrayList<String>();
		if (start.length() != end.length()) {
			System.out.println("Err: The length of the input strings must match");
			return null;
		}
		if (start.equals(end)) {
			ArrayList<String> returnList = new ArrayList<String>();
			returnList.add(start);
			returnList.add(end);
			return returnList;
		}
		Queue<WordInfo> queue = new Queue<WordInfo>();
		WordInfo startTemp = new WordInfo(start);
		startTemp.pushHistory(start);
		usedWords.add(start);
		queue.enqueue(startTemp);

		while (!queue.isEmpty()) {
			WordInfo fromQueue = queue.dequeue();
			for (String wordOneAway : oneAway(fromQueue.getData())) {
				if (wordOneAway.equals(end)) {
					fromQueue.pushHistory(end);
					fromQueue.setEnqueues(totalEnqueues);
					System.out.println(fromQueue);
					return fromQueue.getHistory();
				} else {
					if (this.withRemoval) {
						if (!usedWords.contains(wordOneAway)) {
							WordInfo temp = new WordInfo(wordOneAway);
							temp.pushHistory(fromQueue.getHistory());
							temp.pushHistory(wordOneAway);
							usedWords.add(wordOneAway);
							queue.enqueue(temp);
							totalEnqueues += 1;
						}
					} else {
						if (!fromQueue.getHistory().contains(wordOneAway)) {
							WordInfo temp = new WordInfo(wordOneAway);
							temp.pushHistory(fromQueue.getHistory());
							temp.pushHistory(wordOneAway);
							usedWords.add(wordOneAway);
							queue.enqueue(temp);
							totalEnqueues += 1;
						}
					}
				}
			}
		}
		return null;
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

	/*
	 * Reads a list of words from a file, putting all words of the same length
	 * into the same array.
	 */
	private void readDictionary(String dictionaryFile) {
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
}
