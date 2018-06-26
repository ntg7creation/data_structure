package assignment4.Structures.HashTable;

import java.util.Iterator;

import assignment4.Structures.List.LinkedListIterator;
import assignment4.Structures.List.MyList;

public class HashList implements Iterable<HashListElements> {

	private MyList<HashListElements> words;
	//O(1)
	public HashList() {
		words = new MyList<HashListElements>();
	}
	//O(number of keys in list)
	public void addData(String key) {
		for (HashListElements element : this) {
			if (element.getKey().equals(key)) {
				element.increaseCount();
				return;
			}
		}
		words.addLast(new HashListElements(key));
	}
	//O(number of keys in list)
	public HashListElements getData(String key) {
		for (HashListElements element : this) {
			if (element.getKey().equals(key))
				return element;
		}
		return null;
	}
	//O(number or keys in list)
	public Boolean deleteElement(String key) {
		for (HashListElements element : this) 
			if (element.getKey().equals(key)) {
				words.removeNode(element);
				return true;
			}
		return false;
		
	}
	//O(1)
	public MyList<HashListElements> getAllElements() {
		return words;
	}
	//O(1)
	@Override
	public Iterator<HashListElements> iterator() {
		return new LinkedListIterator<HashListElements>(words.getFirst());
	}

}
