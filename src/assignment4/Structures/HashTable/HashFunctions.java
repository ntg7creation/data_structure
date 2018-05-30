package assignment4.Structures.HashTable;

public class HashFunctions {

	static public int getHash(int hashNumber, int size, String key) {
		switch (hashNumber) {
		case 1:
			return hash1(size, key);
		default:
			System.out.println("hash dous not exsist");
			break;
		}
		return 0;
	}

	static public int hash1(int size, String key) {
		int keyValue = 0;
		for (int i = 0; i < key.length(); i++) {
			char c = key.charAt(i);
			keyValue += c; // each char have an asky code value
		}

		return (keyValue * keyValue) % size;
	}

}
