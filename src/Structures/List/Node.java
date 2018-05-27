package Structures.List;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class Node<T> {

	//basic node the contain a String 
    private Node<T> next;
    private Node<T> pre;
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
    public Node<T> getNext() {
        return next;
    }
    public Node<T> getPre() {
        return pre;
    }
    public void setNext(Node<T> next) {
        this.next = next;
    }
    public void setPre(Node<T> pre) {
        this.pre = pre;
    }

    
}
