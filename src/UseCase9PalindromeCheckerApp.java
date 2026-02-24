
public class UseCase9PalindromeCheckerApp {

    public static void main(String[] args) {

        String original = "madam";

        boolean isPalindrome = checkPalindrome(original, 0, original.length() - 1);

        if (isPalindrome) {
            System.out.println(original + " is a Palindrome.");
        } else {
            System.out.println(original + " is NOT a Palindrome.");
        }
    }

    // Recursive Palindrome Method
    public static boolean checkPalindrome(String str, int start, int end) {

        // Base Condition: If pointers cross or are equal
        if (start >= end) {
            return true;
        }

        // If characters don't match
        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        // Recursive call (move inward)
        return checkPalindrome(str, start + 1, end - 1);
    }
}