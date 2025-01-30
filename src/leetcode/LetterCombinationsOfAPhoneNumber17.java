package leetcode;

import java.util.*;

public class LetterCombinationsOfAPhoneNumber17 {
    Map<Character, List<String>> mp;

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return new ArrayList<>();
        }

        mp = new HashMap<>();
        mp.put('2', Arrays.asList("a", "b", "c"));
        mp.put('3', Arrays.asList("d", "e", "f"));
        mp.put('4', Arrays.asList("g", "h", "i"));
        mp.put('5', Arrays.asList("j", "k", "l"));
        mp.put('6', Arrays.asList("m", "n", "o"));
        mp.put('7', Arrays.asList("p", "q", "r", "s"));
        mp.put('8', Arrays.asList("t", "u", "v"));
        mp.put('9', Arrays.asList("w", "x", "y", "z"));

        List<String> res = new ArrayList<>();
        solve(0, digits, "", res);
        return res;
    }

    private void solve(int idx, String s, String curr, List<String> res) {
        if (idx == s.length()) {
            res.add(curr);
            return;
        }

        char currentChar = s.charAt(idx);
        List<String> letters = mp.get(currentChar);

        if (letters != null) {
            for (String letter : letters) {
                solve(idx + 1, s, curr + letter, res);
            }
        }
    }
}
