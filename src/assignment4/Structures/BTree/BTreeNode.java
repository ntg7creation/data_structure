package assignment4.Structures.BTree;


public class BTreeNode {
	
	private int t;
	private String keys[];
	private boolean isLeaf;
	private BTreeNode children[];
	private int n; // number of keys
	private String tVal;
	private BTreeNode pre;
	private BTreeNode next;
	int hight;
	BTreeNode father;
	
	//Run time : O(1)	
	public BTreeNode (String tVal, boolean isLeaf) {
		this.t = Integer.parseInt(tVal);
		children = new BTreeNode[2*t];
		this.isLeaf = isLeaf;
		keys = new String[(2*t) -1];
		n = 0;
		this.tVal = tVal;
		
	}	
	//Run time : O(th)
	public BTreeNode search (String k) {
		int i = 0;
		while ((i < this.n) & (k.compareTo(this.keys[i]) > 0)) {
			i = i+1;
		}
		if(i <= this.n & k.compareTo(this.keys[i]) == 0) {
			return this;
		}
		if (this.isLeaf)
			return null;
		else 
			children[i].search(k);
			
		return null;
	}
	
	
	//Run time : O(t)
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
	//Run time : O(th)
	public void insertNonFull(String newKey) {
		int i = n; // n = number of keys in this node
		if (isLeaf) { // if this is a leaf we look for the place for this key in this node.

			while (i >= 1 && newKey.compareTo(keys[i-1]) < 0) {
				keys[i] = keys[i-1];
				i = i-1;
			}
			
			keys[i] = newKey;
			n = n + 1;
		}
		
		else { // if it's not a leaf we look for the rigth child to try to insert the key in him.
			while ( i >= 1 && newKey.compareTo(keys[i-1]) < 0) {
				i = i-1;
			}
			if (children[i] != null && ((children[i]).n == (2*t)-1)) {
				splitChild(this, children[i], i+1); 
				if (newKey.compareTo(keys[i]) > 0) {
					i = i+1;
				}
			}
			children[i].insertNonFull(newKey);
		}
	}

	//Run time : O(1)
	public int getT() {
		return t;
	}

	//Run time : O(1)
	public void setT(int t) {
		this.t = t;
	}

	//Run time : O(1)
	public String[] getKeys() {
		return keys;
	}
	//Run time : O(1)
	public String getKey(int index) {
		return keys[index];
	}
	//Run time : O(1)
	public void setKeys(String newKey, int index) {
		this.keys[index] = newKey;
	}

	//Run time : O(1)
	public boolean isLeaf() {
		return isLeaf;
	}

	//Run time : O(1)
	public void setLeaf(boolean isLeaf) {
		this.isLeaf = isLeaf;
	}

	//Run time : O(1)
	public BTreeNode[] getChildren() {
		return children;
	}
	
	
	//Run time : O(1)
	public BTreeNode getChild(int index) {
		return children[index];
	}
	
	//Run time : O(1)
	public void setChildren (BTreeNode NewChild, int index) {
		this.children[index] = NewChild;
	}

	//Run time : O(1)
	public int getN() {
		return n;
	}

	//Run time : O(1)
	public void setN(int n) {
		this.n = n;
	}

	//Run time : O(1)
	public String gettVal() {
		return tVal;
	}

	//Run time : O(1)
	public void settVal(String tVal) {
		this.tVal = tVal;
	}
	//Run time : O(1)
	public void setPre (BTreeNode n) {
		pre = n;
	}
	//Run time : O(1)
	public void setNext (BTreeNode n) {
		next = n;
	}
	//Run time : O(1)
	public BTreeNode getPre () {
		return pre;
	}
	//Run time : O(1)
	public BTreeNode getNext () {
		return next;
	}
	
	
	
	//Run time : O(n)
	// we use queue for the BFS 
	// we go over all the nodes, at first we enqueue the root
	// every time we dequeue node we enqueue all of his children. 
	// every node that we dequeue, added to BFS string with the sign according to the previous node we dequeued.
	public String BFS (String BFS) {
		Queue qNodes = new Queue(); 
		BTreeNode curr =this; 
		BTreeNode prev;
		qNodes.enqueue(this); 
		this.hight = 0;
		
		while (!qNodes.isEmpty()) {
			prev = curr;
			curr= qNodes.dequeue();
		
			if (curr != this) {
				if (prev.hight == curr.hight & prev.father == curr.father) 
					BFS = BFS + "|";
				if (prev.hight == curr.hight & prev.father != curr.father) 
					BFS = BFS + "^";
				if (prev.hight != curr.hight) 
					BFS = BFS + "#";
			}
			
			for (int i = 0 ; i < curr.getN() ; i++) {
				BFS = BFS + curr.getKey(i);
				if (i < curr.getN() - 1)
					BFS = BFS + ",";
			}
						
			for (int i = 0 ;curr.getChild(i) != null && i <= curr.getN() ; i++) {
					curr.getChild(i).father = curr;	
					curr.getChild(i).hight = curr.getChild(i).father.hight + 1;
				qNodes.enqueue(curr.getChild(i));
			}
		}
		return BFS;
	}
	
	
//	public void print() { // in order
//		int i;
//		String output = "";
//		for( i = 0 ; i < this.getN(); i++) {
//			if (!isLeaf) {
//				this.getChild(i).print();
//			}
//			output = output + " " +this.getKey(i);
//		}
//		
//		if(!this.isLeaf())	{			
//			this.getChild(i).print();		
//		}
//		
//		System.out.println(output);
//	}

	
}
