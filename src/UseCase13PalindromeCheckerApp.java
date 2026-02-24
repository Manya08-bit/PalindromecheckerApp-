import java.util.Stack;
import java.util.Deque;
import java.util.ArrayDeque;

public class UseCase13PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "A man a plan a canal Panama";

        // Normalize for fair comparison
        String normalized = input.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

        // Run and compare
        runTest("Two Pointer", normalized, UseCase13PalindromeCheckerApp::twoPointerCheck);
        runTest("Stack Based", normalized, UseCase13PalindromeCheckerApp::stackCheck);
        runTest("Deque Based", normalized, UseCase13PalindromeCheckerApp::dequeCheck);
        runTest("Recursive", normalized, UseCase13PalindromeCheckerApp::recursiveCheck);
    }

    // Performance Runner
    private static void runTest(String name, String input, PalindromeAlgorithm algorithm) {

        long start = System.nanoTime();
        boolean result = algorithm.check(input);
        long end = System.nanoTime();

        long duration = end - start;

        System.out.println("-------------------------------------");
        System.out.println("Algorithm: " + name);
        System.out.println("Result: " + result);
        System.out.println("Execution Time (ns): " + duration);
    }

    // Functional Interface
    interface PalindromeAlgorithm {
        boolean check(String str);
    }

    // 1️⃣ Two Pointer Approach
    private static boolean twoPointerCheck(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // 2️⃣ Stack Based
    private static boolean stackCheck(String str) {
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

    // 3️⃣ Deque Based
    private static boolean dequeCheck(String str) {
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

    // 4️⃣ Recursive
    private static boolean recursiveCheck(String str) {
        return recursiveHelper(str, 0, str.length() - 1);
    }

    private static boolean recursiveHelper(String str, int left, int right) {

        if (left >= right)
            return true;

        if (str.charAt(left) != str.charAt(right))
            return false;

        return recursiveHelper(str, left + 1, right - 1);
    }
}