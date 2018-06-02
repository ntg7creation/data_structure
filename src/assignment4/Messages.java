package assignment4;

import java.util.Iterator;

import assignment4.StorageL.File_Reader;
import assignment4.Structures.BTree.BTree;
import assignment4.Structures.HashTable.HashListElements;
import assignment4.Structures.HashTable.HashTable;
import assignment4.Structures.List.LinkedListIterator;
import assignment4.Structures.List.MyList;
import assignment4.components.Message;
import assignment4.components.Spam;
import assignment4.components.Spams;

public class Messages implements Iterable<Message> {

	private final String path = "messages.txt"; // deful path for messages in the end not used
	MyList<Message> allMessages;

	public Messages() {
		allMessages = new MyList<Message>();

	}

	private void creat_Msg_From_Txt(int messageStart, int messageEnd, String[] txt) {
		String[] msg = new String[messageEnd - messageStart];
		for (int line = messageStart; line < messageEnd; line++)
			msg[line - messageStart] = txt[line];

		allMessages.addLast(new Message(msg, allMessages.getSize()));
	}

	public void createHashTables(String hashint) {
		int hashsize = Integer.parseInt(hashint);
		for (Message msg : allMessages)
			msg.creatHash(hashsize);

	}

	public String findSpams(String path, BTree btree) {
		Spams trash = new Spams(path);
		String output = "";
		for (Message message : allMessages) {
			// if(!btree.areFrinds(message.getRecipient(),message.getRecipient()))
			for (Spam spamword : trash) {
				HashTable table = message.getMywords();
				HashListElements msgword = table.Search(spamword.getWord());
				if (msgword != null ) {
					double wordprs = 100*(double) msgword.getCount() / (double) message.getMywords().getElementsCount();
					if(wordprs > spamword.getPrs())
					output += "," + message.getMsgNumber();
					// break;
				}
			}

		}
		System.out.println(output);
		return null;
	}

	public void generateMessages(String path) {
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

	@Override
	public Iterator<Message> iterator() {
		return new LinkedListIterator<Message>(allMessages.getFirst());
	}

	public static void main(String arg[]) {
		Messages box = new Messages();
		String test = "abcd" + 65;
		System.out.println(test);
	}

}
