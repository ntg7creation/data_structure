package assignment4.components;

import assignment4.Structures.HashTable.HashTable;

public class Message {

	private int msgNumber;
	private String Sender;
	private String Recipient;
	private String content = "";
	private HashTable mywords;

	//O(n) n = number of lines
	public Message(String[] txt, int msgNumber) {
		mywords = null;
		this.msgNumber = msgNumber;
		if (txt.length < 3)
			System.out.println("invalid messge");

		Sender = txt[0].substring(5);
		Recipient = txt[1].substring(3);
		for (int i = 2; i < txt.length; i++)
			content = content + " " + txt[i];

	}

	//O(n) n = number of words in msg
	public void creatHash(int hashsize) {
		mywords = new HashTable(content, hashsize);
	}

	//O(1)
	/**
	 * @return the sender
	 */
	public String getSender() {
		return Sender;
	}
	//O(1)
	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return Recipient;
	}
	//O(1)
	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
	//O(1)
	/**
	 * @return the mywords
	 */
	public HashTable getMywords() {
		return mywords;
	}
	//O(1)
	/**
	 * @return the msgNumber
	 */
	public int getMsgNumber() {
		return msgNumber;
	}
	//O(1)
	@Override
	public String toString() {
		String output = Sender + "\n" + Recipient + "\n" + content;
		return output;
	}
}
