package assignment4.Structures.HashTable;

public class HashFunctions {

	
	static public int getHash(int hashNumber, int size, String key) {
		switch (hashNumber) {
		case 1:
			return hashFunction(size, key);
		default:
			System.out.println("hash dous not exsist");
			break;
		}
		return 0;
	}

	//O(key size) = O(1)
	static public int hashFunction(int size, String key) {
		int keyValue = 0;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			keyValue += c; // each char have an asky code value
		}

		return keyValue % size;
	}

}
