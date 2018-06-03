package assignment4.Structures.HashTable;

public class HashListElements {

	private String key;
	private int count;
	//O(1)
	public HashListElements(String key) {
		this.key = key;
		count = 1;
	}
	//O(1)
	public void increaseCount() {
		count++;
	}
	//O(1)
	public int getCount() {
		return count;
	}
	//O(1)
	public String getKey() {
		return key;
	}
}
