package assignment4;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class Node<T> {

	//basic node the contain a String 
    private Node next;
    private Node pre;
    private T data;
    public Node(T info) {
	data = info;
	next = null;
	pre = null;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public Node getPre() {
        return pre;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public void setPre(Node pre) {
        this.pre = pre;
    }

    
}
