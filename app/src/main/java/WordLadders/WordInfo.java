
package WordLadders;

import java.util.ArrayList;

/**
 * WordInfo - A container to hold a word node and its history of previously
 * visited values
 */
public class WordInfo {
    private String word;
    private ArrayList<String> history;
    private int enqueues;

    public WordInfo(String data) {
        this.word = data;
        this.history = new ArrayList<String>();
    }

    public String getData() {
        return word;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void pushHistory(String word) {
        this.history.add(word);
    }

    public void pushHistory(ArrayList<String> history) {
        for (String word : history) {
            this.history.add(word);
        }
    }

    public void setEnqueues(int enqueues) {
        this.enqueues = enqueues;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s : %d Moves %s total enqueues %s",
                word, history.get(history.size() - 1), history.size() - 1, history, enqueues);
    }

}
