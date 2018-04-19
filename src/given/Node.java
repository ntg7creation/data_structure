package given;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class Node {

	//basic node the contain a page 
    private Node next;
    private Node pre;
    private Page data;
    public Node(Page info) {
	
	data = info;
    }
    public Page getData() {
        return data;
    }
    public void setData(Page data) {
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
