package assignment4.Structures.List;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListIterator<T> implements Iterator<T> {
	private MyNode<T> current ;

	public LinkedListIterator (MyNode<T> first) {
		current = first ;
	}

	@Override
	public boolean hasNext() {
		return current != null ;
	}

	@Override
	public T next() {
		//System.out.println("iterator was called");
		if (!hasNext ())
			throw new NoSuchElementException() ;

		T next = current.getData() ;
		current = current.getNext() ;
		return next ;
	}

	@Override
	public void remove() {
		throw new UnsupportedOperationException();
	}
}
