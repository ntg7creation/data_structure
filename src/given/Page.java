package given;

/**
 * 
 * @author natai & 208768150
 * @author bar & 205817521
 */
public class Page {
    // ADD YOUR CODE HERE
    private String info;
    private int home;

    public Page(String info, int home) {
	this.info = info; // strcopy
	this.home = home;
    }

    public void write(char c) {
	info = info + c;
    }

    public String read() {
	return info;
    }

    public int getHome() {
	return home;
    }
}
