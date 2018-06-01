package assignment4.Structures.Queue;

import assignment4.Structures.List.MyList;
import java.util.NoSuchElementException;


public class QueueAsLinkedList <T>{

	private MyList<T> list;

	public QueueAsLinkedList() {
		this.list = new  MyList<>();
	}

	public boolean isEmpty() {
		return list.isEmpty();
	}

	public void enqueue(T element) {
		if(element == null) 
			throw new NullPointerException();
		list.addLast(element);
	}


	public T dequeue() {
		if(isEmpty()) 
			throw new NoSuchElementException();
		return   (T) list.getFirst();
	}

	public T peek() {
		if(isEmpty()) 
			throw new NoSuchElementException();
		return  (T) list.getFirst();
	}

}

