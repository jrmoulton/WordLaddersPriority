
package WordLadders;

import java.util.ArrayList;

public class WordInfoExhaustive extends WordInfo {

    public WordInfoExhaustive(String data) {
        this.word = data;
        this.history = new ArrayList<String>();
    }

    @Override
    public String toString() {
        return String.format("Seeking exhaustive solution from %s -> %s\n%s total enqueues %s",
                history.get(0), history.get(history.size() - 1), history, moves);
    }
}
