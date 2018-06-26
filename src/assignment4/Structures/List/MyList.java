package assignment4.Structures.List;

import java.util.Iterator;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class MyList<T> implements Iterable<T>  {

	private MyNode<T> root;
	private MyNode<T> last;
	private int size;

	public MyList() {
		this.size = 0;
	}

	
	public MyNode<T> replace(MyNode<T> n, MyList<T> list) {
		MyNode<T> pre = n.getPre();
		MyNode<T> next = n.getNext();
		list.getLast().setNext(next);
		if (pre == null) {
			root = list.getFirst();
		} else {
			pre.setNext(list.getFirst());
		}
		if (next == null) {
			last = list.getLast();
		}
		size += list.getSize();
		return removeNode(n);
	}

	public MyNode<T> removeNode(MyNode<T> n) {
		n.setNext(null);
		n.setPre(null);
		size--;
		return n;
	}

	public MyNode<T> removeNode(T element) {
		MyNode<T> temp = root;
		while (temp != null)
			if (temp.getData().equals(element))
				return removeNode(temp);
		return null;
	}

	public MyNode<T> getLast() {
		return last;
	}

	public MyNode<T> getFirst() {
		return root;
	}

	public void addLast(T data) {
		MyNode<T> newN = new MyNode<T>(data);
		addLast(newN);
	}

	// addes a Node<T> to the last place in the tree
	public void addLast(MyNode<T> node) {

		if (isEmpty()) {
			root = node;
			last = node;
		} else {
			node.setNext(null); // not needed
			node.setPre(last);
			last.setNext(node);
			last = node; // last = last.getNext(); same thing
		}
		size++;
	}

	public int getSize()
	{
		return size;
	}
	
	public Boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}


	@Override
	public Iterator<T> iterator() {
		return new LinkedListIterator<T>(root);
	}

}
