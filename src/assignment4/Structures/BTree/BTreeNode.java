package assignment4.Structures.BTree;


public class BTreeNode {
	
	public int t;
	public key keys[];
	public boolean isLeaf;
	public BTreeNode children[];
	public int n; // number of keys
	String tVal;
	
		
	public BTreeNode (String tVal, boolean isLeaf) {
		this.t = Integer.parseInt(tVal);
		children = new BTreeNode[2*t];
		this.isLeaf = isLeaf;
		keys = new key[(2*t) -1];
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
		x.children[i] = z;
		for (int j = x.n-1 ; j >= i-1; j-- ) {
			x.keys[j+1] = x.keys[j];
		}
		x.keys[i-1] = y.keys[t-1];
		x.n = x.n + 1;
		
		}
	
	public void insertNonFull(key newKey) {
		int i = n;
		if (isLeaf) {

			while (i >= 1 && newKey.k < keys[i-1].k) {
				keys[i] = keys[i-1];
				i = i-1;
			}
			
			keys[i] = newKey;
			n = n + 1;
		}
		else {
			while ( i >= 1 && newKey.k < keys[i-1].k) {
				i = i-1;
			}
			if (children[i] != null &&(children[i]).n == (2*t)-1) {
				splitChild(this, children[i], i+1);
				if (newKey.k > keys[i-1].k) {
					i = i+1;
				}
			}
			children[i].insertNonFull(newKey);
		}
	}




}
