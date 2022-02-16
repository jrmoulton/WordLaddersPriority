
package WordLadders;

import java.util.ArrayList;

/**
 * WordInfo - A container to hold a word node and its history of previously
 * visited values
 */
abstract class WordInfo {
    protected String word;
    protected ArrayList<String> history;
    protected int moves;

    public String getWord() {
        return word;
    }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void pushHistory(String word) {
        if (this.history == null) {
            this.history = new ArrayList<>();
        }
        this.history.add(word);
    }

    public void pushHistory(ArrayList<String> history) {
        if (this.history == null) {
            this.history = new ArrayList<>();
        }
        for (String word : history) {
            this.history.add(word);
        }
    }

    public void setMoves(int moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return String.format("%s -> %s : %d Moves %s total enqueues %s",
                history.get(0), history.get(history.size() - 1), history.size() - 1, history, moves);
    }

}
