package textproc;

import java.util.TreeMap;
import java.util.Map;

public class MultiWordCounter implements TextProcessor {
	private Map<String, Integer> karta;

	public MultiWordCounter(String[] words) {
		karta = new TreeMap<String, Integer>();
		for (int i = 0; i < words.length; i++) {
			karta.put(words[i], 0);
		}
	}

	@Override
	public void process(String w) {

		if (karta.containsKey(w)) {
			int nbr = karta.get(w) + 1;
			karta.put(w, nbr);
		}
	}

	@Override
	public void report() {
		for (String key : karta.keySet()) {
			System.out.println(key + " " + karta.get(key));
		}
	}

}
