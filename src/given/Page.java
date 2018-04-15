package given;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class Page {
    // ADD YOUR CODE HERE
    private String info;

    public Page(String info) {
	this.info = info; // strcopy
    }

    public void write(char c) {
	info = info + c;
    }

    public String read() {
	return info;
    }
}
