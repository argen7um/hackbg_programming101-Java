package week07;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;


public class WC {
	
	public static class WordCounterResult {
		public int numberWords = 0;
		public int numberLines = 0;
		public int numberChars = 0;
 	}
	
	private static String getContent(String fileName) throws IOException {
		byte [] encoded = Files.readAllBytes(Paths.get(fileName));
		String content = new String(encoded, Charset.defaultCharset());
		return content;
	}
	
	public static WordCounterResult get(String fileName) throws IOException {
		WordCounterResult res = new WordCounterResult();
		String content = getContent(fileName);
		res.numberChars = content.length();
		res.numberWords = content.split("\\s+").length;
		res.numberLines = content.split(System.lineSeparator()).length;
		return res;
	}
	
	
	public static void main(String[] args) {
		WC.WordCounterResult res;
		try {
			res = WC.get("/home/angel/mytmp/note.txt");
			System.out.println(res.numberChars);
			System.out.println(res.numberWords);
			System.out.println(res.numberLines);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
