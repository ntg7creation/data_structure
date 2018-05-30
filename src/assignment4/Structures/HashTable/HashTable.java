package assignment4.Structures.HashTable;

public class HashTable {

	private HashList[] Slots;

	public HashTable(String msg, int tableIntSize) {
		Slots = new HashList[tableIntSize];
		for (HashList hashList : Slots)
			hashList = new HashList();

		String[] words = msg.split(" ");
		for (String str : words) {
			System.out.println(str);
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
		
	}

	public static void main(String arg[]) {
		new HashTable("hi this is a test to split a messge", 16);
	}

}
