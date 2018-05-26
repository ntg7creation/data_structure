package assignment4;

public class BTreeNode {
	
	int t;
	int keys[];
	boolean isLeaf;
	BTreeNode children[];
	int n; // number of keys
	String tVal;
	
		
	public BTreeNode (String tVal, boolean isLeaf) {
		this.t = Integer.parseInt(tVal);
		children = new BTreeNode[2*t];
		this.isLeaf = isLeaf;
		keys = new int[2*t -1];
		n = 0;
		this.tVal = tVal;
		
	}
	
	
	public BTreeNode search (int k) {
		int i = 0;
		while ((i < this.n) & (k > this.keys[i])) {
			i = i+1;
		}
		if(i <= this.n & k == this.keys[i]) {
			return this;
		}
		if (this.isLeaf)
			return null;
		else 
			children[i].search(k);
			
		return null;
	}
	
	public void splitChild (BTreeNode x, BTreeNode y, int i) {
		BTreeNode z = new BTreeNode(tVal,y.isLeaf );
		z.n = t-1;
		for (int j = 0; j < t-1 ; j++) {
			z.keys[j]= y.keys[j+t];
		}
		if (!y.isLeaf) {
			for (int j = 0; j < t; j++) {
				z.children[j]=y.children[j+t];
			}
		}
		y.n = t-1;
		
		for (int j = x.n ; j >= i ; j--) {
			x.children[j+1] = x.children[j];
		}
		x.children[i-1] = z;
		for (int j = x.n-1 ; j <= i; j-- ) {
			x.keys[j+1] = x.keys[j];
		}
		x.keys[i] = y.keys[t];
		x.n = x.n + 1;
		
		}
		

}
