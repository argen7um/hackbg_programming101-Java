package week03.Wednesday;

import java.util.LinkedHashMap;
import java.util.Map;


public class CountWords {
	
	private static Map<String, Integer> data;
	

	public static Map <String, Integer> count(String text) {
		data = new LinkedHashMap<String, Integer>();
		String [] words = text.split("\\s+");
		for (String word: words) {
			if (data.containsKey(word)) {
				data.replace(word, data.get(word) + 1);
			} else {
				data.put(word, 1);
			}
		}
		return data;
	}
	
	public static void main(String [] Args) {
		String s = "Ninjas are all over the place! We are all going to die!";
		System.out.println(CountWords.count(s));
	}
	
}
