
package WordLadders;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class LadderGame {
	private ArrayList<ArrayList<String>> organizedWords;

    public LadderGame(String dictionaryFile) {
		readDictionary(dictionaryFile);
    }

    /*
        Print a Word Ladder from start word to end word
     */
    public ArrayList<String> play(String start, String end) {
        // TODO: Write some good stuff here
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
		Queue<WordTrack> queue = new Queue<WordTrack>();

		while (!queue.isEmpty()) {
			 WordTrack val = queue.dequeue();
			 for (String word : oneAway(start, withRemoval)) {
			 	
			 }
		}

		ArrayList<String> oneAway = new ArrayList<String>();
        return oneAway;
    }

    /*
        List all words that are one character different from the given word
     */
    public ArrayList<String> oneAway(String word, boolean withRemoval) {
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
				if (withRemoval) {
					// If withRemoval is set remove the word from the dictionary. 
					words.remove(wordIndex);
				}
			}
		}
        return oneAway;
    }

    /*
        Return and print the first howMany words of size length from the 
		pre-organized words
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
        Reads a list of words from a file, putting all words of the same length 
		into the same array.
     */
    private void readDictionary(String dictionaryFile) {
        File file = new File(dictionaryFile);
        ArrayList<String> allWords = new ArrayList<>();

        // Track the longest word, because that tells us how big to make the 
		// array.
        int longestWord = 0;
        try (Scanner input = new Scanner(file)) {
            //
            // Start by reading all the words into memory.
            while (input.hasNextLine()) {
                String word = input.nextLine().toLowerCase();
                allWords.add(word);
                longestWord = Math.max(longestWord, word.length());
            }
			
            // DONE: You need to do something here to organize the words into 
			// groups/arrays of words with the same size
			ArrayList<ArrayList<String>> organizedWords = new ArrayList<ArrayList<String>>(longestWord);
			for (int i = 0; i <= longestWord; i++) {
				organizedWords.add(new ArrayList<String>());
			}
			for (String word : allWords) {
				organizedWords.get(word.length()).add(word);
			}

			this.organizedWords = organizedWords;

        }
        catch (java.io.IOException ex) {
            System.out.println("An error occurred trying to read the dictionary: " + ex);
        }
    }
}
