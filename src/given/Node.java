package given;

public class Node {

    private Node next;
    private Node pre;
    private Page data;
    public Node(String info) {
	
	data = new Page(info);
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
