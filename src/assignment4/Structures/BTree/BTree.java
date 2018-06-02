package assignment4.Structures.BTree;

import assignment4.StorageL.File_Reader;

public class BTree {
	
	private BTreeNode root;
	private int t;
	private String tVal;
	
	
	public BTree(String tVal) {
		t = Integer.parseInt(tVal);
		root = null;
		this.tVal = tVal;
	}
	
	
	public BTreeNode search (String k) {
		if (root!=null)
			return root.search(k);
		return null;
	}
	
//	public void insertAllFriends(String path) {
//		for (String x : File_Reader.readFile(path)) {
//			String newkey = x;
//			insert(newkey);
//		}
//	
//		
//	}
	
	public void insert (String newKey) {
		if (root == null) {
			root = new BTreeNode(tVal, true);
			root.setKeys( newKey , 0 );
			root.setN(1);
		}
		
		
		else {
			if(root.getN() == (2*t)-1) {
			BTreeNode s = new BTreeNode(tVal, false);
			s.setN(0);
			s.setChildren(root, 0);
			s.splitChild(s,root,1);
			root = s;
			}
			root.insertNonFull(newKey);
		}
	}
	
	
	public void createFullTree(String string) {
		for (String x : File_Reader.readFile(string)) {
			String newkey = x;
			insert(newkey);
		}
		
	}
	
	public BTreeNode getRoot () {
		return root;
	}
	
	public int getTInt () {
		return t;
	}
	
	public String getTString () {
		return tVal;
	}
	
	
	
	public String toString () {
		String BFS = "";
		if (root == null) {
			return BFS;
		}
		return root.BFS(BFS);
	}
	
	public void printBFS() {
		System.out.println(toString());
	}

	public void print() { // in order
		if (root == null) {
			System.out.println("empty tree");
		}
		else {
			root.print();
		}
	}
}
