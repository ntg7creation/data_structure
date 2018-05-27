package assignment4.Structures.List;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class MyNode<T> {

	//basic node the contain a String 
    private MyNode<T> next;
    private MyNode<T> pre;
    private T data;
    public MyNode(T info) {
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
    public MyNode<T> getNext() {
        return next;
    }
    public MyNode<T> getPre() {
        return pre;
    }
    public void setNext(MyNode<T> next) {
        this.next = next;
    }
    public void setPre(MyNode<T> pre) {
        this.pre = pre;
    }

    
}
