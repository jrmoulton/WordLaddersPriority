
package WordLadders;

import java.util.ArrayList;

public class LadderGameExhaustive extends LadderGame {
	// private ArrayList<ArrayList<String>> organizedWords;
	// private ArrayList<String> unorganizedWords;
	public boolean withRemoval = true;
	private int totalEnqueues = 0;

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

}
