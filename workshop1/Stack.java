/* JAC444 - Workshop 1 
 * Student: Kenneth Yue - 127932176
 * Date: January 24, 2019
 */

public class Stack {
	private char word[];
	
	// constructor
	public Stack() {
		word = new char[0];
	}
	
	// add to top of stack
	public void push(char newChar) {
		char[] newWord = new char[size() + 1];
		System.arraycopy(word, 0, newWord, 0, word.length);
		newWord[word.length] = newChar;
		word = newWord;
	}
	
	// remove (and get) from top of stack 
	// NOTE: Ideally this method should throw an exception if the stack is empty
	public char pop() {
		char rtnChar = '\u0000';
		if (word.length > 0) {
			rtnChar = word[word.length - 1];
			char[] newWord = new char[word.length - 1];
			System.arraycopy(word, 0, newWord, 0, newWord.length);
			word = newWord;
		}
		return rtnChar;	
	}
	
	// get top of stack
	// NOTE: Ideally this method should throw an exception if the stack is empty
	public char top() {
		return word.length > 0 ? word[word.length - 1] : '\u0000';
	}
	
	// check if stack is empty
	public boolean isEmpty() {
		return word.length == 0 ? true : false;
	}
	
	// return size of stack
	public int size() {
		return word.length;
	}
}