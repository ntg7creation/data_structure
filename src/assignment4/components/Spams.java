package assignment4.components;

import java.util.Iterator;


import assignment4.StorageL.File_Reader;
import assignment4.Structures.List.LinkedListIterator;
import assignment4.Structures.List.MyList;

public class Spams implements Iterable<Spam>{
	
	MyList<Spam> SpamWords;
	final String path = "files\\spam_words.txt";
	
	public Spams() {
		SpamWords = new MyList<Spam>();
		String[] txt = File_Reader.readFile(path);
		for (int i = 0; i < txt.length; i++) {
			Spam newSpamWord = new Spam(txt[i]);
			SpamWords.addLast(newSpamWord);
		}
	}
	
	public Iterator<Spam> iterator() {
		return new LinkedListIterator<Spam>(SpamWords.getFirst());
	}

}
