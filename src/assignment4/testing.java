package assignment4;

public class testing {

	public static void main(String[] args) {
		String t = "7";
		
		
		
		BTree BT = new BTree(t);
		BT.insertAllFriends("files\\friends.txt");
		System.out.println(BT.root.toString());
	}
}
