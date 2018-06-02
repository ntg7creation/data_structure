package assignment4.Structures.HashTable;

import java.util.Iterator;

import assignment4.Structures.List.LinkedListIterator;
import assignment4.Structures.List.MyList;
import assignment4.Structures.List.MyNode;

public class HashList implements Iterable<HashListElements> {

	private MyList<HashListElements> words;

	public HashList() {
		words = new MyList<HashListElements>();
	}

	public void addData(String key) {
		for (HashListElements element : this) {
			if (element.getKey().equals(key)) {
				element.increaseCount();
				return;
			}
		}
		words.addLast(new HashListElements(key));
	}

	public HashListElements getData(String key) {
		for (HashListElements element : this) {
			if (element.getKey().equals(key))
				return element;
		}
		return null;
	}

	public Boolean deleteElement(String key) {
		for (HashListElements element : this) 
			if (element.getKey().equals(key)) {
				words.removeNode(element);
				return true;
			}
		return false;
		
	}

	public MyList<HashListElements> getAllElements() {
		return words;
	}

	@Override
	public Iterator<HashListElements> iterator() {
		return new LinkedListIterator<HashListElements>(words.getFirst());
	}

}
