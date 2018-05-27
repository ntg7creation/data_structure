package assignment4.Structures.HashTable;

import assignment4.Structures.List.MyList;

public class ChainHash {
	
	MyList<String>[] Word_Count;
	
	public ChainHash(String msg)
	{
		String[] words = msg.split(" ");
		for (String str : words) {
			System.out.println(str);
		}
	}
	
	public static void main(String arg[]) {
		new ChainHash("hi this is a test to split a messge");
	}

}
