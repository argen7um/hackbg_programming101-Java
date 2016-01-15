package week07;

import static org.junit.Assert.assertEquals;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class ProperiesParserTest {
	
	private static ProperiesParser parser;
	private static String fileName = "/tmp/property.txt";
	
	@BeforeClass
	public static void init() {
		createFile();
		parser = new ProperiesParser(fileName);
	}
	
	@AfterClass
	public static void clear() {
		try {
			Files.delete(Paths.get(fileName));
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	private static void createFile() {
		String newLine = System.lineSeparator();
		String s =
		"# this=comment" + newLine +
        "a1=b1" + newLine +
        "a2 =b2" + newLine +
        "a3    =    b3" + newLine +
        "a4 = b4" + newLine +
        "a5=b6=b7=b8" + newLine +
        "a6=b9 #comment" + newLine + 
        "a7==b10" + newLine;
		try {
			BufferedWriter in = Files.newBufferedWriter(Paths.get(fileName));
			in.write(s);
			in.close();
		} catch (IOException e) {
			System.out.println(e);
		}
	}

	//@Test
	//public void testGetLines() {
	//	fail("Not yet implemented");
	//}

	//@Test
	//public void testParseLine() {
	//	fail("Not yet implemented");
	//}

	@Test
	public void testParse() {
		Map <String, String> expected;
		Map<String, String> actuals = new HashMap<String, String>();
		actuals.put("a1", "b1");
		actuals.put("a2", "b2");
		actuals.put("a3", "b3");
		actuals.put("a4", "b4");
		actuals.put("a5", "b6=b7=b8");
		actuals.put("a6", "b9");
		actuals.put("a7", "=b10");
		try {
			expected = parser.parse();
			assertEquals(expected, actuals);
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
