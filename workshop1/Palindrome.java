/* JAC444 - Workshop 1 
 * Student: Kenneth Yue - 127932176
 * Date: January 24, 2019
 */

public class Palindrome {
	// Checks if a string is a palindrome
	public static boolean checkPalindrome(String input, boolean ignoreCase) {
		String revString = getReverse(input);
		
		return ignoreCase ? input.equalsIgnoreCase(revString) : input.equals(revString);
	}
	
	// Uses a stack to reverse the string
	public static String getReverse(String input) {
		Stack stack = new Stack();
		String revString = new String();
		
		for (int i = 0; i < input.length(); i++) {
			stack.push(input.charAt(i));
		}
		
		for (int i = 0; i < input.length(); i++) {
			revString += stack.pop();
		}
		
		return revString;
	}
	
	public static void main(String[] args) {
		if (args.length == 0) {
			System.out.println("No arguments were provided! Please provide one argument.");
			return;
		}
		
		if (checkPalindrome(args[0], true)) {
			System.out.println(args[0] + " is a palindrome!");
		} else {
			System.out.println(args[0] + " is not a palindrome...");
		}
	}
	
}