package given;

public class List {

    private Node root;
    private Node last;

    public List() {

    }

    
    // node mast be from this tree
    public Boolean removeNode(Node node) {
	if (isEmpty() || node == null)
	    return false;
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
    }

    // node mast be from this tree
    public void moveToLast(Node node) {

	if (removeNode(node))
	    addLast(node);

    }

    public Node getAndRemoveFirst()
    {
	Node temp = root;
	removeNode(temp);
	return temp;
    }
    
    public Boolean isEmpty() {
	if (root == null)
	    return true;
	return false;
    }

}
