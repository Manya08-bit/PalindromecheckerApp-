public class UseCase10PalindromeCheckerApp {

    public static void main(String[] args) {

        String original = "A man a plan a canal Panama";

        // Step 1: Normalize string
        String normalized = original
                .replaceAll("[^a-zA-Z0-9]", "")  // Remove spaces & special characters
                .toLowerCase();                  // Convert to lowercase

        // Step 2: Check palindrome using two-pointer technique
        boolean isPalindrome = checkPalindrome(normalized);

        if (isPalindrome) {
            System.out.println("\"" + original + "\" is a Palindrome (ignoring case and spaces).");
        } else {
            System.out.println("\"" + original + "\" is NOT a Palindrome.");
        }
    }

    public static boolean checkPalindrome(String str) {

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
}