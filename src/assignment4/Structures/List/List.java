package assignment4.Structures.List;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class List<T> {

	private Node<T> root;
	private Node<T> last;
	private int size;
	public List() {
		this.size = 0;
	}

	public Node<T> replace(Node<T> n, List<T> list) {
		Node<T> pre = n.getPre();
		Node<T> next = n.getNext();
		list.getLast().setNext(next);
		if (pre == null) {
			root = list.getFirst();
		} else {
			pre.setNext(list.getFirst());
		}
		if (next == null) {
			last = list.getLast();
		}
		return removeNode(n);
	}

	 public Node<T> removeNode(Node<T> n)
	{
		n.setNext(null);
		n.setPre(null);
		return n;
	}
	
	public Node<T> getLast() {
		return last;
	}

	public Node<T> getFirst() {
		return root;
	}

	public void addLast(T data) {
		Node<T> newN = new Node<T>(data);
		addLast(newN);
	}

	// addes a Node<T> to the last place in the tree
	public void addLast(Node<T> node) {

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

	public Boolean isEmpty() {
		if (size == 0)
			return true;
		return false;
	}

}
