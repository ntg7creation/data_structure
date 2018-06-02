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
<<<<<<< HEAD
	
	
	public BTreeNode search (String k) {
		if (root!=null)
=======

	public BTreeNode search(int k) {
		if (root != null)
>>>>>>> branch 'assiment-4' of https://github.com/ntg7creation/data_structure.git
			return root.search(k);
		return null;
	}
<<<<<<< HEAD
	
	
	public void insert (String newKey) {
=======

	public void insertAllFriends(String path) {
		int counter = 0;
		for (String x : File_Reader.readFile(path)) {
			counter = counter + 1;
			key newkey = new key(x, counter);
			insert(newkey);
		}

	}

	public void insert(key newKey) {
>>>>>>> branch 'assiment-4' of https://github.com/ntg7creation/data_structure.git
		if (root == null) {
			root = new BTreeNode(tVal, true);
			root.getKeys()[0] = newKey;
			root.setN(1);
<<<<<<< HEAD
		}
		
		
		else {
			if(root.getN() == (2*t)-1) {
			BTreeNode s = new BTreeNode(tVal, false);
			s.setN(0);
			s.setChildren(root, 0);
			s.splitChild(s,root,1);
			root = s;
=======

		} else {
			if (root.getN() == 2 * t - 1) {
				BTreeNode s = new BTreeNode(tVal, false);
				s.setN(0);
				s.getChildren()[0] = root;
				s.splitChild(s, root, 1);
				root = s;
				root.setKeys(newKey, 0);
				root.setN(1);

			} else {
				if (root.getN() == 2 * t - 1) {
					BTreeNode s = new BTreeNode(tVal, false);
					s.setN(0);
					s.setChildren(root, 0);
					s.splitChild(s, root, 1);
					root = s;
				}
				root.insertNonFull(newKey);
>>>>>>> branch 'assiment-4' of https://github.com/ntg7creation/data_structure.git
			}
		}
	}

	public void createFullTree(String string) {
<<<<<<< HEAD
		for (String x : File_Reader.readFile(string)) {
			String newkey = x;
			insert(newkey);
		}
		
=======
		// TODO Auto-generated method stub
>>>>>>> branch 'assiment-4' of https://github.com/ntg7creation/data_structure.git
	}

	public void print1(BTreeNode n) {
		for (int i = 0; i < n.getN(); i++) {
			System.out.print(n.getKeys()[i].friends + " ");
		}
	}

	public BTreeNode getRoot() {
		return root;
	}

	public int getTInt() {
		return t;
	}

	public String getTString() {
		return tVal;
	}
<<<<<<< HEAD
	
	
	
	public String toString () {
		String BFS = "";
=======

	public String BFS() {
		String BFS = "jj";

>>>>>>> branch 'assiment-4' of https://github.com/ntg7creation/data_structure.git
		if (root == null) {
			return BFS;
<<<<<<< HEAD
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
=======
		} else {
			return root.BFS(BFS);
>>>>>>> branch 'assiment-4' of https://github.com/ntg7creation/data_structure.git
		}
<<<<<<< HEAD
=======

	}

	public void printBFS(BTreeNode n) {
		System.out.println(BFS());
	}

	public void print(BTreeNode n) { // in order
		for (int i = 0; i < n.getN(); i++) {
			System.out.print(n.getKey(i).friends + " ");

		}

		if (!n.isLeaf()) {
			for (int j = 0; j <= n.getN(); j++) {
				if (n.getChildren()[j] != null) {
					System.out.println();
					print(n.getChildren()[j]);
				}
			}
			if (!n.isLeaf()) {
				for (int j = 0; j <= n.getN(); j++) {
					if (n.getChild(j) != null) {
						System.out.println();
						print(n.getChild(j));
					}
				}
			}

		}

>>>>>>> branch 'assiment-4' of https://github.com/ntg7creation/data_structure.git
	}
}
