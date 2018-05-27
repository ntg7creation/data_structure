package assignment4.Structures.BTree;

public class BTreeNode {
	
	int t;
	key keys[];
	boolean isLeaf;
	BTreeNode children[];
	int n; // number of keys
	String tVal;
	
		
	public BTreeNode (String tVal, boolean isLeaf) {
		this.t = Integer.parseInt(tVal);
		children = new BTreeNode[2*t];
		this.isLeaf = isLeaf;
		keys = new key[2*t -1];
		n = 0;
		this.tVal = tVal;
		
	}
	
	
	public BTreeNode search (int k) {
		int i = 0;
		while ((i < this.n) & (k > this.keys[i].k)) {
			i = i+1;
		}
		if(i <= this.n & k == this.keys[i].k) {
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
			z.keys[j].k= y.keys[j+t].k;
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
			x.keys[j+1].k = x.keys[j].k;
		}
		x.keys[i].k = y.keys[t].k;
		x.n = x.n + 1;
		
		}
	
		
}
