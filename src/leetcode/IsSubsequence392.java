package leetcode;

public class IsSubsequence392 {
    public boolean isSubsequence(String s, String t) {
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        int idx = 0;

        if (sArr.length == 0) return true;

        for (int i = 0; i < tArr.length; i++) {
            if (tArr[i] == sArr[idx]) {
                if (idx < sArr.length - 1) idx++;
                else return true;
            }
        }

        return false;

    }z
}
