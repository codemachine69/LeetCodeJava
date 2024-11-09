package leetcode;

import java.util.HashMap;

public class WordPattern290 {
    public boolean wordPattern(String pattern, String s) {
        String[] words = s.split(" ");
        HashMap<Character, String> hm = new HashMap<>();

        if (words.length != pattern.length()) return false;

        for (int i = 0; i < words.length; i++) {
            char c = pattern.charAt(i);
            if (hm.containsKey(c)) {
                if (!hm.get(c).equals(words[i]))
                    return false;
            } else {
                if (hm.containsValue(words[i])) return false;
                hm.put(c, words[i]);
            }
        }

        return true;
    }
}
