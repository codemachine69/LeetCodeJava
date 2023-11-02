package leetcode;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        for (int x : nums) {
            if (hs.contains(x)) return true;
            else hs.add(x);
        }
        return false;
    }
}
