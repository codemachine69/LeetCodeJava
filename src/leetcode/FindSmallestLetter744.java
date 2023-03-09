package leetcode;

public class FindSmallestLetter744 {
    public char nextGreatestLetter(char[] letters, char target) {
        int l = 0, r = letters.length - 1;
        char ans = '?';
        while (l <= r) {
            int mid = l + (r - l)/2;
            if(letters[mid] <= target) l = mid + 1;
            else { r = mid - 1; ans = letters[mid]; }
        }
        return ans == '?' ? letters[0] : ans;
    }
}
