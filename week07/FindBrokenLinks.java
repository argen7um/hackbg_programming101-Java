package week07;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FindBrokenLinks {

	public static boolean isCorrect(String pathString) throws IOException {
		Path path = Paths.get(pathString);
		Path dir = path.getParent();
		if (!Files.isSymbolicLink(path)) {
			return false;
		} 
		Path targetPath = Files.readSymbolicLink(path);
		if (!targetPath.isAbsolute()) { // can be relative
			targetPath = Paths.get(dir.toString(), targetPath.toString()).normalize();
		}
		System.out.println(targetPath);
		if (Files.exists(targetPath)) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		try {
		System.out.println(FindBrokenLinks.isCorrect("/home/angel/mytmp/sym_note.txt"));
		} catch (IOException e) {
			System.out.println(e);
		}
	}

}
