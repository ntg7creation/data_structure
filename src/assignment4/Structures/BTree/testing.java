package assignment4.Structures.BTree;

public class testing {

	public static void main(String[] args) {
		String t = "4";
		
		
		BTree BT = new BTree(t);
		BT.insertAllFriends("files\\friends.txt");
		
		BT.print(BT.getRoot());;
		
	}
}
