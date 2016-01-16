package week07;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FixSubs {
	
	
	private static String getContent(String fileName) throws IOException{
		byte [] bytes = Files.readAllBytes(Paths.get(fileName));
		String content = new String(bytes, "windows-1251");
		return content;	
	}
	
	public static void writeSubs(String fileSourse, String fileDestination) throws IOException {
		String content = getContent(fileSourse);
		BufferedWriter fw = null;
		try {
			fw = Files.newBufferedWriter(Paths.get(fileDestination), StandardCharsets.UTF_8);
			fw.write(content);
		} finally {
			fw.close();
		}
	}
	

	public static void main(String[] args) {
		try {
			FixSubs.writeSubs("/home/angel/lost.s04e11.hdtv.xvid-2hd.html", "/home/angel/subs.txt");
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
