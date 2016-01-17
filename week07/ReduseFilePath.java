package week07;

import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class ReduseFilePath {
	
	public static String Do(String path) {
		return Paths.get(path).normalize().toString();
	}
	

	@Test
	public void DoTest() {
		assertEquals(("/"), Do("/"));
		assertEquals("/", Do("/srv/../"));
		assertEquals("/srv/www/htdocs/wtf", Do("/srv/www/htdocs/wtf/"));
		assertEquals("/srv/www/htdocs/wtf" ,Do("/srv/www/htdocs/wtf"));
		assertEquals("/srv", Do("/srv/./././././"));
		assertEquals("/etc/wtf" ,Do("/etc//wtf/"));
		assertEquals("/", Do("/etc/../etc/../etc/../"));
		assertEquals("/", Do("//////////////"));
		assertEquals("/", Do("/../"));
	}

}
