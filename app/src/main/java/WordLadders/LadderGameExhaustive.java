
package WordLadders;

import java.util.ArrayList;

public class LadderGameExhaustive extends LadderGame {
	// private ArrayList<ArrayList<String>> organizedWords;
	// private ArrayList<String> unorganizedWords;
	public boolean withRemoval = true;

	public LadderGameExhaustive(String dictionaryFile) {
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
		Queue<WordInfoExhaustive> queue = new Queue<WordInfoExhaustive>();
		WordInfoExhaustive startTemp = new WordInfoExhaustive(start);
		startTemp.pushHistory(start);
		usedWords.add(start);
		queue.enqueue(startTemp);

		while (!queue.isEmpty()) {
			WordInfoExhaustive fromQueue = queue.dequeue();
			for (String wordOneAway : oneAway(fromQueue.getWord())) {
				if (wordOneAway.equals(end)) {
					fromQueue.pushHistory(end);
					fromQueue.setMoves(totalMoves);
					System.out.println(fromQueue);
					return fromQueue.getHistory();
				} else {
					if (this.withRemoval) {
						if (!usedWords.contains(wordOneAway)) {
							WordInfoExhaustive temp = new WordInfoExhaustive(wordOneAway);
							temp.pushHistory(fromQueue.getHistory());
							temp.pushHistory(wordOneAway);
							usedWords.add(wordOneAway);
							queue.enqueue(temp);
							totalMoves += 1;
						}
					} else {
						if (!fromQueue.getHistory().contains(wordOneAway)) {
							WordInfoExhaustive temp = new WordInfoExhaustive(wordOneAway);
							temp.pushHistory(fromQueue.getHistory());
							temp.pushHistory(wordOneAway);
							usedWords.add(wordOneAway);
							queue.enqueue(temp);
							totalMoves += 1;
						}
					}
				}
			}
		}
		return null;
	}

}
