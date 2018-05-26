package assignment4;

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
	

	
	
	
	public void createFullTree(String string) {
		// TODO Auto-generated method stub
		
	}

}
