package leetcode;

public class FindIfDigitGameCanBeWon3232 {
    public boolean canAliceWin(int[] nums) {
        int alice = 0, bob = 0;
        for (int x : nums) {
            if (x < 10) alice += x;
            else bob += x;
        }
        return alice == bob ? false : true;
    }
}
