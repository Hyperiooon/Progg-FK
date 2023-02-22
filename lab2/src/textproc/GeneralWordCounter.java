package textproc;

import java.util.ArrayList;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GeneralWordCounter implements TextProcessor {
	private Map <String, Integer> karta;
	private Set <String> s;

	public GeneralWordCounter (Set<String> s) {
		karta = new TreeMap<String, Integer>();
		this.s = s;
		
	}
	@Override
	public void process(String w) {
		if (!s.contains(w)) {
			int nbr = karta.getOrDefault((w), 0)+1;
			karta.put(w, nbr);
	}
	}

	@Override
	public void report() {
		/**for (String key : karta.keySet()) {
			if (karta.get(key) >= 200) {
			System.out.println(key + " " + karta.get(key));
			}
		}
		*/
		Set<Map.Entry<String, Integer>> wordSet = karta.entrySet();
        List<Map.Entry<String, Integer>> wordList = new ArrayList<>(wordSet);
        wordList.sort((w1, w2)-> {
        	if (w2.getValue() == w1.getValue()) {
        		return w1.getKey().compareTo(w2.getKey());
        	}
        	else {
        		return w2.getValue()-w1.getValue();	
        	}
        });
        for(int i = 0; i < 5;i++) {
        	System.out.println(wordList.get(i).toString());
        }

	}
	public List<String> getWordList() {
        return null;
}

}
