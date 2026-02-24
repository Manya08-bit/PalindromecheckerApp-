public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        String input = "level";

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println(input + " is a Palindrome.");
        } else {
            System.out.println(input + " is NOT a Palindrome.");
        }
    }
}


// Palindrome Service Class
class PalindromeChecker {

    // Public method exposed to client
    public boolean checkPalindrome(String str) {

        if (str == null)
            return false;

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