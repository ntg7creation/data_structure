package assignment4;

import assignment4.StorageL.File_Reader;

public class BTree {
	
	BTreeNode root;
	int t;
	String tVal;
	
	
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
		BTreeNode r = root;
		if (root != null && root.n == 2*t-1) {
			BTreeNode s = new BTreeNode(tVal, false);
			s.n = 0;
			root = s;
			s.children[0]= r;
			s.splitChild(s,r,1);
			r = s;
		}
		insertNonFull(r, newKey);	
		
	}

	
	
	public void insertNonFull(BTreeNode r,key newKey) {
		if (root == null) {
			r = new BTreeNode(tVal, true);
			r.keys[0] = newKey;
			r.n = 1;
			root = r;
			
			
		}
		else {
			int i = r.n;
			if (r.isLeaf) {
				while (i >= 1 && newKey.k < r.keys[i-1].k) {
					r.keys[i] = r.keys[i-1];
					i = i-1;
				}
				r.keys[i] = newKey;
				r.n = (r.n) + 1;
			}
			else {
				while ( i >= 1 && newKey.k < r.keys[i-1].k) {
					i = i-1;
				}
				if ((r.children[i]).n == (2*t)-1) {
					r.splitChild(r, r.children[i], i);
					if (newKey.k > r.keys[i-1].k) {
						i = i+1;
					}
				}
				insertNonFull(r.children[i], newKey);
			}
		}
	}
	
	public void createFullTree(String string) {
		// TODO Auto-generated method stub
		
	}
	public String toString(BTreeNode n){
		String friendsList = "";
		if (n==null)
		    return "empty tree";
		if (n.isLeaf) {
			friendsList = friendsList + " # " + n.toString();
		}
		else {
			friendsList = friendsList + " # " + n.toString();
			for (BTreeNode currChild : n.children) {
				if (currChild.n != 0) {
					currChild.toString();
				}
					
			}
		} 
		return friendsList;
	}
	
}
