package leetcode;

public class ValidPalindrome125 {
    public boolean isPalindrome(String s) {
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            char loChar = s.charAt(lo), hiChar = s.charAt(hi);
            if (!Character.isLetterOrDigit(loChar)) {
                lo++;
            } else if (!Character.isLetterOrDigit(hiChar)) {
                hi--;
            } else {
                if (Character.toLowerCase(loChar) != Character.toLowerCase(hiChar)) return false;
                lo++;
                hi--;
            }
        }

        return true;
    }
}
