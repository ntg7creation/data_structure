package assignment4.Structures.BTree;

public class testing {

	public static void main(String[] args) {
		String t = "2";
		
		  BTree B = new BTree(t);
			B.insert("A");
			B.insert("B");
			B.insert("C");
			B.insert("D");
			B.insert("G");
			B.insert("H");
			B.insert("K");
			B.insert("M");
			B.insert("R");
			B.insert("W");
			B.insert("Z");
          System.out.println("D#B|H,M#A|C^G|K|R,W,Z");
			System.out.println(B.toString());
		
		BTree BT = new BTree(t);
		BT.createFullTree("files\\friends.txt");
		
		BT.printBFS();
		//BT.print(); 
		
	
		System.out.println(BT.areFreinds("McCartney" , "Lennon"));

		
	}
	

}
