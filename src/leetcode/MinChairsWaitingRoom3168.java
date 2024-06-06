package leetcode;

public class MinChairsWaitingRoom3168 {
    public int minimumChairs(String s) {
        int max = 0, count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'E') {
                count++;
            } else {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }
}
