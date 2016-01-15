package week07;

import static org.junit.Assert.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.BeforeClass;
import org.junit.Test;

public class WCTest {

	@BeforeClass
	public static void init() {
		fileName = "/tmp/test.txt";
		try {
			writeFile();
			result = WC.get(fileName);
		} catch (IOException e) {
			System.out.println(e);
		}
		
	}
	
	private static void writeFile() throws IOException {
		String newLine = System.lineSeparator();
		String s = 
		"adfa adf  ddd" + newLine +  
		"dad f" + newLine + 
		"adf" + newLine +
		"ad"  + newLine;
		BufferedWriter wr = null;
		try {
			wr = Files.newBufferedWriter(Paths.get(fileName));
			wr.write(s);
		} finally {
			wr.close();
		}
	}
	
	private static WC.WordCounterResult result;
	private static String fileName;
	
	@Test
	public void testGet() {
		assertEquals("chars",result.numberChars , 27);
		assertEquals("words",result.numberWords , 7);
		assertEquals("lines",result.numberLines , 4);
	}

}
