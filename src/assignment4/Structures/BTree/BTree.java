package assignment4.Structures.BTree;

import assignment4.StorageL.File_Reader;
import assignment4.Structures.Queue.QueueAsLinkedList;

public class BTree {
	
	private BTreeNode root;
	private int t;
	private String tVal;
	
	
	public BTree(String tVal) {
		t = Integer.parseInt(tVal);
		root = null;
		this.tVal = tVal;
	}
	
	
	public BTreeNode search (int k) {
		if (root!=null)
			return root.search(k);
		return null;
	}
	
	public void insertAllFriends(String path) {
		int counter = 0;
		for (String x : File_Reader.readFile(path)) {
			counter = counter + 1;
			key newkey = new key(x ,counter);
			insert(newkey);
		}
	
		
	}
	
	public void insert (key newKey) {
		if (root == null) {
			root = new BTreeNode(tVal, true);
			root.setKeys( newKey , 0 );
			root.setN(1);
	
		}
		else {
			if(root.getN() == 2*t-1) {
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
		// TODO Auto-generated method stub
		
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
	
	
	public String BFS () {
		String BFS = "jj";

		if (root == null) {
			return BFS;
		}
		else {
			return root.BFS(BFS);
		}
	
	}
	
	public void printBFS(BTreeNode n) {
		System.out.println(BFS());
	}

	public void print(BTreeNode n) { // in order
		for(int i = 0; i < n.getN(); i++) {
			System.out.print(n.getKey(i).friends + " " );
			
		}

		if(!n.isLeaf())	{
			for(int j = 0; j <= n.getN()  ; j++){				
				if(n.getChild(j) != null ){		
						System.out.println();
					print(n.getChild(j));  
				
				}
			}
		}

	}
}
