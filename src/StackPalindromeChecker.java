import java.util.Stack;

public class StackPalindromeChecker {

    public static void main(String[] args) {

        // Original string
        String original = "radar";

        // Create Stack
        Stack<Character> stack = new Stack<>();

        // Push characters into stack
        for (int i = 0; i < original.length(); i++) {
            stack.push(original.charAt(i));
        }

        // Build reversed string using pop
        String reversed = "";

        while (!stack.isEmpty()) {
            reversed = reversed + stack.pop();
        }

        // Compare original and reversed
        if (original.equals(reversed)) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }
}
