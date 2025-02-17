package leetcode;

import java.util.HashSet;
import java.util.Set;

public class LetterTilePossibilities1079 {
    public int numTilePossibilities(String tiles) {
        Set<String> res = new HashSet<>();
        boolean[] used = new boolean[tiles.length()];
        solve("", used, res, tiles);
        return res.size() - 1;
    }

    private void solve(String curr, boolean[] used, Set<String> res, String s) {
        res.add(curr);

        for (int i = 0; i < s.length(); i++) {
            if (!used[i]) {
                used[i] = true;
                solve(curr + s.charAt(i), used, res, s);
                used[i] = false;
            }
        }
    }
}
