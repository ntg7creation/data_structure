package given;

import javax.management.RuntimeErrorException;

public class List {

    private Node root;
    private Node last;
    private int size;
    private int max;

    public List(int size) {
	size = 0;
	max = size;
    }

    // node mast be from this tree
    public Boolean removeNode(Node node) {
	if (isEmpty() || node == null)
	    return false;

	size--;

	if (node.getPre() == null) {

	    root = node.getNext();
	    if (root != null)
		root.setPre(null);

	    node.setNext(null);
	    node.setPre(null);// not needed
	    return true;
	}

	if (node.getNext() == null) {
	    last = node.getPre();
	    last.setNext(null);
	    node.setNext(null);// not needed
	    node.setPre(null);
	    return true;
	}

	node.getNext().setPre(node.getPre());
	node.getPre().setNext(node.getNext());

	node.setNext(null);
	node.setPre(null);
	return true;
    }

    public Boolean addLast(Node node) {
	if (size >= max)
	    return false;

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
	return true;
    }

    // node mast be from this tree
    public void moveToLast(Node node) {

	if (removeNode(node))
	    if (!addLast(node))
		throw new RuntimeException(); // we shold never get here

    }

    //LRU remove
    public Node getAndRemoveFirst() {
	Node temp = root;
	removeNode(temp);
	return temp;
    }

    public Boolean isEmpty() {
	if (size == 0)
	    return true;
	return false;
    }

}
