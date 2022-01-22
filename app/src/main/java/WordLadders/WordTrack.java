
package WordLadders;

import java.util.ArrayList;

/**
 * WordTrack - A container to hold a word node and its history of previously 
 * visited values
 */
public class WordTrack {
	private String data;
	private ArrayList<String> history;

    public WordTrack(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    // public void setData(String data) {
    //     this.data = data;
    // }

    public ArrayList<String> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<String> history) {
        this.history = history;
    }


}
