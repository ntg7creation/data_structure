package assignment4.Structures.HashTable;

import java.util.Iterator;

public class HashTable implements Iterable<HashListElements> {

	private HashList[] Slots;
	private int elementsCount;

	public HashTable(String msg, int tableIntSize) {
		elementsCount = 0;
		Slots = new HashList[tableIntSize];
		for (int i = 0; i < Slots.length; i++)
			Slots[i] = new HashList();
		// for (HashList hashList : Slots)
		// hashList = new HashList();

		String[] words = msg.split(" ");
		for (String str : words) {
			Insert(str);
		}
	}
	//O(1)  expected
	public HashListElements Search(String key) {
		int keyValue = HashFunctions.hashFunction(Slots.length, key);
		if (keyValue >= Slots.length)
			System.out.println("error in hashfunction");
		return Slots[keyValue].getData(key);
	}
	//O(1) without rehashing expected
	public void Insert(String key) {

		int keyValue = HashFunctions.hashFunction(Slots.length, key);
		if (keyValue >= Slots.length)
			System.out.println("error in hashfunction");
		Slots[keyValue].addData(key);
		elementsCount++;

		if (elementsCount >= Slots.length)
			ReHash();
	}
	//O(1) expected
	public void Delete(String key) {
		int keyValue = HashFunctions.hashFunction(Slots.length, key);
		if (keyValue >= Slots.length)
			System.out.println("error in hashfunction");
		if (Slots[keyValue].deleteElement(key))
			elementsCount--;
	}
 
	//O(n)
	private void ReHash() {
		int nextSize = 2 * Slots.length;
		HashList[] newTable = new HashList[nextSize];
		for (int i = 0; i < newTable.length; i++)
			newTable[i] = new HashList();

		for (HashListElements elements : this) {
			int keyValue = HashFunctions.hashFunction(nextSize, elements.getKey());
			if (keyValue >= nextSize)
				System.out.println("error in hashfunction");
			for (int i = 0; i < elements.getCount(); i++)
				newTable[keyValue].addData(elements.getKey());
		}
		Slots = newTable;
	}

	/**
	 * @return the elementsCount
	 */
	public int getElementsCount() {
		return elementsCount;
	}

	@Override
	public Iterator<HashListElements> iterator() {
		return new HashTableIterator(Slots);
	}
}
