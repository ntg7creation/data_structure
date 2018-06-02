package assignment4.StorageL;

import java.io.File;
import java.util.Scanner;

import assignment4.Structures.List.MyList;
import assignment4.Structures.List.MyNode;

public class File_Reader {

	static public String[] readFile(String path) {
		String[] txt = null;
		try {
			MyList<String> temp = new MyList<String>();
			Scanner inputStream = new Scanner(new File(path));
			while (inputStream.hasNext())
				temp.addLast(inputStream.nextLine());

			txt = new String[temp.getSize()];

			MyNode<String> tnode = temp.getFirst();
			for (int count = 0; count < txt.length; count++) {
				String line = tnode.getData();
				txt[count] = line;
				tnode = tnode.getNext();
			}
			inputStream.close();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("File not Found");
			return null;
		}

		return txt;
	}


}
