package assignment4.Structures.HashTable;

public class HashListElements {

	private String key;
	private int count;

	public HashListElements(String key) {
		this.key = key;
		count = 1;
	}

	public void increaseCount() {
		count++;
	}

	public int getCount() {
		return count;
	}

	public String getKey() {
		return key;
	}
}
