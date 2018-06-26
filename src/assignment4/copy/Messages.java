package assignment4.copy;

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

	MyList<Message> allMessages;

	// O(1)
	public Messages() {
		allMessages = new MyList<Message>();

	}

	// O(n) n = number of lines in the current msg
	private void creat_Msg_From_Txt(int messageStart, int messageEnd, String[] txt) {
		String[] msg = new String[messageEnd - messageStart];
		for (int line = messageStart; line < messageEnd; line++)
			msg[line - messageStart] = txt[line];

		allMessages.addLast(new Message(msg, allMessages.getSize()));
	}
	// O(n) n = number of words in msg
	public void createHashTables(String hashint) {
		try {
			int hashsize = Integer.parseInt(hashint);
			for (Message msg : allMessages)
				msg.creatHash(hashsize);
		} catch (NumberFormatException e) {
			throw e;
		}

	}
	// O(spam*msg) spam = number of spam words, msg = number of msges
	public String findSpams(String path, BTree btree) {
		Spams trash = new Spams(path);
		String output = "";
		for (Message message : allMessages) {
			if (!btree.areFreinds(message.getRecipient(), message.getSender()))
				for (Spam spamword : trash) {
					HashTable table = message.getMywords();
					HashListElements msgword = table.Search(spamword.getWord());
					if (msgword != null) {
						double wordprs = 100 * (double) msgword.getCount()
								/ (double) message.getMywords().getElementsCount();
						if (wordprs > spamword.getPrs())
							output += "," + message.getMsgNumber();
						break;
					}
				}

		}
		if (output.length() > 0)
			output = output.substring(1);
		// System.out.println(output);
		return output;
	}
	// O(n) n = number of lines in file
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

}
