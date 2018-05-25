package assignment4;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class List {

	private Node root;
	private Node last;
	private int size;
	private int max;

	public List() {
		this.size = 0;
	}

	public Node replace(Node n, List list) {
		Node pre = n.getPre();
		Node next = n.getNext();
		list.getLast().setNext(next);
		if (pre == null) {
			root = list.getFirst();
		} else {
			pre.setNext(list.getFirst());
		}
		if (next == null) {
			last = list.getLast();
		}
		return List.removeNode(n);
	}

	static public Node removeNode(Node n)
	{
		n.setNext(null);
		n.setPre(null);
		return n;
	}
	
	public Node getLast() {
		return last;
	}

	public Node getFirst() {
		return root;
	}

	public void addLast(String str) {
		Node newN = new Node(str);
		addLast(newN);
	}

	// addes a node to the last place in the tree
	public void addLast(Node node) {

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
