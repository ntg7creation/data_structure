package assignment4.components;

import assignment4.Messages;

public class Spam {

	private String word;
	private int prs;
	
	
	public Spam (String newWord) {
		for (int i = 0; i < newWord.length(); i++) {
			if (newWord.charAt(i) == ' ') {
				word = newWord.substring(0, i);
				prs = Integer.parseInt(newWord.substring(i+1));
			}
		}
		
	}

	
	public String getWord() {
		return word;
	}
	
	public int getPrs() {
		return prs;
	}
	
	public String toString()
	{
		String output = word +" "+ prs;
		return output;
	}
	
	
}
