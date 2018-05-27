package assignment4.StorageL;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class File_Reader {

	static public String[] readFile(String path) {
		String fileName = path;
		// File file = new File(fileName);
		Scanner inputStream = null;
		int countOfLines = 0;
		String[] txt = null;
		try {
			countOfLines = (int) Files.lines(Paths.get(new File(fileName).getPath())).count();
			// System.out.println(String.format("There are %s lines in the document",
			// countOfLines));

			inputStream = new Scanner(new File(fileName));
			txt = new String[countOfLines];

			for (int count = 0; count < txt.length & inputStream.hasNext(); count++) {
				String line = inputStream.nextLine();
				txt[count] = line;
				// System.out.println(line);
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not Found");
			return null;
		}
		
		return txt;
	}

	public static void main(String arg[]) {
		for (String string : readFile("files\\messages.txt")) {
			System.out.println(string);
		}

	}

}
