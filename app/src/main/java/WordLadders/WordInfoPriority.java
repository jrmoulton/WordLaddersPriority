
package WordLadders;

import java.util.ArrayList;

/**
* 
*/
public class WordInfoPriority extends WordInfo implements Comparable<WordInfoPriority> {
    private int priority;
    private int estimatedWork;

    public WordInfoPriority(String word, int moves, int estimatedWork) {
        this.word = word;
        this.moves = moves;
        this.estimatedWork = estimatedWork;
    }

    public WordInfoPriority(String word, int moves, int estimatedWork, ArrayList<String> history) {
        this.word = word;
        this.moves = moves;
        this.estimatedWork = estimatedWork;
        this.history = history;

    }

    @Override
    public int compareTo(WordInfoPriority w) {
        if (this.priority < w.priority) {
            return 1;
        } else if (this.priority == w.priority) {
            return 0;
        } else {
            return -1;
        }
    }

    // public int getPriority() {
    //     return this.priority;
    // }

    // public String getWord() {
    //     return this.word;
    // }

    // public int getMoves() {
    //     return this.moves;
    // }

    // public int getEstimatedWork() {
    //     return this.estimatedWork;
    // }

    // public ArrayList<String> getHistory() {
    //     return this.history;
    // }

    @Override
    public String toString() {
        return String.format("Seeking A* solution from %s -> %s\n%s total enqueues %s",
                history.get(0), history.get(history.size() - 1), history, moves);
    }
}
