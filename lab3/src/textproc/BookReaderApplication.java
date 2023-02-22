package textproc;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BookReaderApplication {
	
	public static final String[] REGIONS = { "blekinge", "bohuslän", "dalarna", "dalsland", "gotland", "gästrikland",
			"halland", "hälsingland", "härjedalen", "jämtland", "lappland", "medelpad", "närke", "skåne", "småland",
			"södermanland", "uppland", "värmland", "västerbotten", "västergötland", "västmanland", "ångermanland",
			"öland", "östergötland" };

	public static void main(String[] args) throws FileNotFoundException {
		
		Set<String> stopwords = new HashSet<String>();
		GeneralWordCounter gwc = new GeneralWordCounter(stopwords);

		Scanner scan = new Scanner(new File("undantagsord.txt"));
		scan.findWithinHorizon("\uFEFF", 1);
		scan.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (scan.hasNext()) {
			String word = scan.next().toLowerCase();
			stopwords.add(word);
		}
		scan.close();
		
		Scanner s = new Scanner(new File("nilsholg.txt"));
		s.findWithinHorizon("\uFEFF", 1);
		s.useDelimiter("(\\s|,|\\.|:|;|!|\\?|'|\\\")+");
		while (s.hasNext()) {
			String word = s.next().toLowerCase();
			gwc.process(word);
			/**for (TextProcessor hej:list) {
				hej.process(word);
			}*/
		}

		s.close();
		gwc.report();
		/**for(TextProcessor då:list) {
			då.report();
		}*/
		
		BookReaderController kontroll = new BookReaderController(gwc);

	}
	
}