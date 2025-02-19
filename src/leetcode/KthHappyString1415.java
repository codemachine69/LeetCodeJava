package leetcode;

import java.util.ArrayList;
import java.util.List;

public class KthHappyString1415 {
    public String getHappyString(int n, int k) {
        List<String> arr = new ArrayList<>();
        solve(new StringBuilder(), arr, n, k, ' ');
        if (arr.size() < k) return "";
        return arr.get(k - 1);
    }

    private void solve(StringBuilder sb, List<String> arr, int n, int k, char prev) {
        if (arr.size() > k) return;

        if (sb.length() == n) {
            arr.add(sb.toString());
            return;
        }

        for (char ch = 'a'; ch <= 'c'; ch++) {
            if (prev == ch) continue;
            sb.append(ch);
            solve(sb, arr, n, k, ch);
            sb.delete(sb.length() - 1, sb.length());
        }
    }
}
