import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase12PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "madam";

        // Choose strategy dynamically
        PalindromeStrategy strategy = new StackStrategy();
        // Try changing to:
        // PalindromeStrategy strategy = new DequeStrategy();

        PalindromeContext context = new PalindromeContext(strategy);

        boolean result = context.check(input);

        if (result) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}


// Strategy Interface
interface PalindromeStrategy {
    boolean isPalindrome(String str);
}


// Concrete Strategy 1 – Stack Based
class StackStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String str) {

        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}


// Concrete Strategy 2 – Deque Based
class DequeStrategy implements PalindromeStrategy {

    public boolean isPalindrome(String str) {

        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : str.toCharArray()) {
            deque.addLast(ch);
        }

        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) {
                return false;
            }
        }

        return true;
    }
}


// Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean check(String str) {
        return strategy.isPalindrome(str);
    }
}