package assignment4.Structures.BTree;

import assignment4.StorageL.File_Reader;

public class BTree {
	
	private BTreeNode root;
	private int t;
	private String tVal;
	
	//Run time : O(1)
	public BTree(String tVal) {
		t = Integer.parseInt(tVal);
		root = null;
		this.tVal = tVal;
	}
	
	//Run time : O(th)
	public BTreeNode search (String k) {
		if (root!=null) // if the tree is not empty ask for the root to search
			return root.search(k);
		return null; // if empty return null
	}
	
	//Run time : O (1)
	// insert new key to the tree
	public void insert (String newKey) {
		if (root == null) { // if the tree is empty insert to root
			root = new BTreeNode(tVal, true);
			root.setKeys( newKey , 0 );
			root.setN(1);
		}
		
		
		else { // if not empty
			if(root.getN() == (2*t)-1) {  // if root node is full split before insertion
			BTreeNode s = new BTreeNode(tVal, false);
			s.setN(0);
			s.setChildren(root, 0);
			s.splitChild(s,root,1);
			root = s;
			}
			root.insertNonFull(newKey); // ask the root to insert
		}
	}
	
	//Run time : O(n)
	public void createFullTree(String string) {
		for (String x : File_Reader.readFile(string)) {
			String newkey = x;
			insert(newkey);
		}
		
	}
	//Run time :O(1)
	public BTreeNode getRoot () {
		return root;
	}
	//Run time : O(1)
	public int getTInt () {
		return t;
	}
	//Run time : O(1)
	public String getTString () {
		return tVal;
	}
	
	
	//Run time : O(1)
	// creates a String with all the Friends in BFS order
	public String toString () {
		String BFS = "";
		if (root == null) { // if empty return empty string
			return BFS;
		}
		return root.BFS(BFS); // if not empty ask the root 
	}
	//Run time : O(1)
	// prints BFS string
	public void printBFS() {
		System.out.println(toString());
	}

//	public void print() { // in order
//		if (root == null) {
//			System.out.println("empty tree");
//		}
//		else {
//			root.print();
//		}
//	}
}
