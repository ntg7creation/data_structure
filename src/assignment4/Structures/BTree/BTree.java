package assignment4.Structures.BTree;

import assignment4.StorageL.File_Reader;

public class BTree {
	
	BTreeNode root;
	int t;
	String tVal;
	
	//hi
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
			root.keys[0] = newKey;
			root.n = 1;
	
		}
		else {
			if(root.n == 2*t-1) {
			BTreeNode s = new BTreeNode(tVal, false);
			s.n = 0;
			s.children[0]= root;
			s.splitChild(s,root,1);
			root = s;
			}
			root.insertNonFull(newKey);
		}
	}
	
	
	public void createFullTree(String string) {
		// TODO Auto-generated method stub
		
	}
	public void print(BTreeNode n) 
	{
		for(int i = 0; i < n.n; i++) {
			System.out.print(n.keys[i].friends + " " );
			
		}

		if(!n.isLeaf)	{
			for(int j = 0; j <= n.n  ; j++){				
				if(n.children[j] != null ){		
						System.out.println();
					print(n.children[j]);  
				
				}
			}
		}

	}
}
