package assignment4;

import java.util.Iterator;

import assignment4.StorageL.File_Reader;
import assignment4.Structures.BTree.BTree;
import assignment4.Structures.List.LinkedListIterator;
import assignment4.Structures.List.MyList;
import assignment4.components.Message;

public class Messages implements Iterable<Message> {

	final String path = "files\\messages.txt";
	MyList<Message> allMessages;

	public Messages() {
		allMessages = new MyList<Message>();
		String[] txt = File_Reader.readFile(path);
		int messageStart = 0;
		int messageEnd = 0;
		for (messageEnd = 0; messageEnd < txt.length; messageEnd++) {
			if (txt[messageEnd].matches("#")) {
				creat_Msg_From_Txt(messageStart, messageEnd, txt);
				messageStart = messageEnd + 1;
			}
		}
		creat_Msg_From_Txt(messageStart, messageEnd, txt);

	}

	private void creat_Msg_From_Txt(int messageStart, int messageEnd, String[] txt) {
		String[] msg = new String[messageEnd - messageStart];
		for (int line = messageStart; line < messageEnd; line++)
			msg[line - messageStart] = txt[line];

		allMessages.addLast(new Message(msg));
	}

	public void createHashTables(String string) {
		// TODO Auto-generated method stub

	}

	public String findSpams(String string, BTree btree) {
		// TODO Auto-generated method stub
		return null;
	}

	public void generateMessages(String string) {
		// TODO Auto-generated method stub
		System.out.println(string);
	}

	@Override
	public Iterator<Message> iterator() {
		return new LinkedListIterator<Message>(allMessages.getFirst());
	}

	public static void main(String arg[]) {
		Messages box = new Messages();
		// Iterator it = box.iterator();
//		for (Message message : box) {
//			System.out.println(message.toString());
//			System.out.println();
//			System.out.println();
//		}
	}

}
