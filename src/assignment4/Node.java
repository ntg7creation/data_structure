package assignment4;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class Node {

	//basic node the contain a String 
    private Node next;
    private Node pre;
    private String data;
    public Node(String info) {
	data = info;
	next = null;
	pre = null;
    }
    public String getData() {
        return data;
    }
    public void setData(String data) {
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
