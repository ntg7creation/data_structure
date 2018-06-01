package assignment4.Structures.HashTable;

import java.util.Iterator;

public class HashTable  implements Iterable<HashListElements>{

	private HashList[] Slots;

	public HashTable(String msg, int tableIntSize) {
		Slots = new HashList[tableIntSize];
		for(int i = 0;i<Slots.length;i++)
			Slots[i] = new HashList();
//		for (HashList hashList : Slots)
//			hashList = new HashList();

		String[] words = msg.split(" ");
		for (String str : words) {
			System.out.println(str + " was just inserted into slot: " + HashFunctions.hash1(Slots.length, str));

			Insert(str);
		}
	}

	public HashListElements Search(String key) {
		int keyValue = HashFunctions.hash1(Slots.length, key);
		if (keyValue >= Slots.length)
			System.out.println("error in hashfunction");
		return Slots[keyValue].getData(key);
	}

	public void Insert(String key) {
		int keyValue = HashFunctions.hash1(Slots.length, key);
		if (keyValue >= Slots.length)
			System.out.println("error in hashfunction");
		Slots[keyValue].addData(key);
	}

	public void Delete(String key) {
		int keyValue = HashFunctions.hash1(Slots.length, key);
		if (keyValue >= Slots.length)
			System.out.println("error in hashfunction");
		Slots[keyValue].deleteElement(key);
	}

	public void ReHash() {
		int nextSize = 2 * Slots.length;
		HashList[] newTable = new HashList[nextSize];
		for (HashListElements elements : this) {
			int keyValue = HashFunctions.hash1(nextSize, elements.getKey());
			if (keyValue >= nextSize)
				System.out.println("error in hashfunction");
			Slots[keyValue].addData(elements.getKey());
		}
		Slots = newTable;
	}


	@Override
	public Iterator<HashListElements> iterator() {
		return new HashTableIterator(Slots);
	}
	
	public static void main(String arg[]) {
		String msg = "hi this is a test to split a messge";
		HashTable table = new HashTable(msg, 16);
		for (HashListElements hashListElements : table) {
			System.out.println(hashListElements.getKey()+" was inserted " + hashListElements.getCount() +" times");
		}
	}

}
