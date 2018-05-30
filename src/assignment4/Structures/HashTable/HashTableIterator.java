package assignment4.Structures.HashTable;

import java.util.Iterator;
import java.util.NoSuchElementException;
import assignment4.Structures.HashTable.HashListElements;
import assignment4.Structures.List.MyNode;

public class HashTableIterator implements Iterator<HashListElements> {

	//this class needs heavy testing 
	
	private HashList[] allItems;
	private MyNode<HashListElements> currentData;
	private int currentSlot;

	public HashTableIterator(HashList[] Items) {
		allItems = Items;
		currentSlot = 0;
		currentData = null;
		for (; currentSlot <= allItems.length || currentData != null; currentSlot++)
			currentData = allItems[currentSlot].getAllElements().getFirst();

	}

	@Override
	public boolean hasNext() {
		return currentSlot < allItems.length;
	}

	@Override
	public HashListElements next() {
		// System.out.println("iterator was called");
		if (!hasNext())
			throw new NoSuchElementException();
		// if(allItems[current].getAllElements().)
		//
		HashListElements next = currentData.getData();
		currentData = currentData.getNext();
		if (currentData == null)
			for (; currentSlot <= allItems.length || currentData != null; currentSlot++)
				currentData = allItems[currentSlot].getAllElements().getFirst();
		return next;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
