package leetcode;

public class MajorityElement169 {

    //Algorithm is based on Boyer Moore majority voting algorithm
    public int majorityElement(int[] nums) {
        int votes = 0, candidate = -1;

        for (int x : nums) {
            if (votes == 0) {
                candidate = x;
                votes = 1;
            } else {
                if (x == candidate) votes++;
                else votes--;
            }
        }

        return candidate;
    }
}
