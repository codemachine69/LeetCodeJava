package leetcode;

public class MinChairsWaitingRoom3168 {
    public int minimumChairs(String s) {
        int max = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            count = s.charAt(i) == 'E' ? count + 1 : count - 1;
            max = Math.max(max, count);
        }

        return max;
    }
}
