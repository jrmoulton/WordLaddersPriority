
package WordLadders;

import java.util.ArrayList;

public class LadderGamePriority extends LadderGame {
    private AVLTree<WordInfoPriority> priorityQueue = new AVLTree<WordInfoPriority>();
    
	public LadderGamePriority(String dictionaryFile) {
		readDictionary(dictionaryFile);
	}

    public ArrayList<String> play(String start, String end) {
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

        var result = search(start, end);

        System.out.println(result);
        return result.getHistory();
    }

    private WordInfoPriority search(String start, String end) {
        var usedWords = new AVLTree<WordInfoPriority>();
        var first = new WordInfoPriority(start, 0, estimateWork(start, end, 1));
        first.pushHistory(start);
        priorityQueue.insert(first);
        usedWords.insert(first);

        while (!priorityQueue.isEmpty()) {
            var fromQueue = priorityQueue.deleteMin();
			for (String wordOneAway : oneAway(fromQueue.getWord())) {
                if (wordOneAway.equals(end)) {
                    fromQueue.pushHistory(end);
                    fromQueue.setMoves(totalMoves);
                    return fromQueue;
                } else if (usedWords.contains(fromQueue)) {
                    var tempMoves = fromQueue.getHistory().size();
                    var temp = new WordInfoPriority(wordOneAway, tempMoves, estimateWork(wordOneAway, end, tempMoves));
                    temp.pushHistory(fromQueue.getHistory());
                    temp.pushHistory(wordOneAway);
                    priorityQueue.insert(temp);
                    totalMoves += 1;
                }
            }
        }
        return null;
    }

    private int estimateWork(String start, String end, int prevMoves) {
        var count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i)) {
                count += 1;
            }
        }
        return count + prevMoves;
    }

}
