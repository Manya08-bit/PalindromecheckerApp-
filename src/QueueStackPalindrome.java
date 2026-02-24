import java.util.Queue;
import java.util.LinkedList;
import java.util.Stack;

public class QueueStackPalindrome {
    public static void main(String[] args) {

        // Original string
        String original = "madam";

        // Create Queue and Stack
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        // Add characters to Queue and Stack
        for (int i = 0; i < original.length(); i++) {
            char ch = original.charAt(i);
            queue.add(ch);     // Enqueue (FIFO)
            stack.push(ch);    // Push (LIFO)
        }

        // Compare dequeue and pop
        boolean isPalindrome = true;

        while (!queue.isEmpty()) {
            if (!queue.remove().equals(stack.pop())) {
                isPalindrome = false;
                break;
            }
        }

        // Print result
        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }
}
