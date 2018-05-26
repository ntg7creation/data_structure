package components;

public class Message {

	private String Sender;
	private String Recipient;
	private String content = "";

	public Message(String[] txt) {
		
		if (txt.length < 3)
			System.out.println("invalid messge");

		Sender = txt[0];
		Recipient = txt[1];
		for (int i = 2; i < txt.length; i++)
			content = content + " " + txt[i];
	}

	/**
	 * @return the sender
	 */
	public String getSender() {
		return Sender;
	}

	/**
	 * @return the recipient
	 */
	public String getRecipient() {
		return Recipient;
	}

	/**
	 * @return the content
	 */
	public String getContent() {
		return content;
	}
}
