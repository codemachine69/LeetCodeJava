package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.stream.IntStream;

public class FairCandySwap888 {
    public int[] fairCandySwap_bs(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        int[] ans = new int[]{-1, -1};
        for(int x : aliceSizes) aliceSum += x;
        for(int x : bobSizes) bobSum += x;

        Arrays.sort(bobSizes);
        int n = bobSizes.length;

        for (int i = 0; i < aliceSizes.length; i++) {
            int l = 0, r = n - 1;
            while (l <= r) {
                int mid = l + (r - l)/2;
                if(aliceSum - aliceSizes[i] + bobSizes[mid] == bobSum - bobSizes[mid] + aliceSizes[i]) {
                    ans[0] = aliceSizes[i];
                    ans[1] = bobSizes[mid];
                    break;
                } else if (aliceSum - aliceSizes[i] + bobSizes[mid] > bobSum - bobSizes[mid] + aliceSizes[i]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
        }
        return ans;
    }

    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int aliceSum = 0, bobSum = 0;
        int[] ans = new int[]{-1, -1};
        HashSet<Integer> hs = new HashSet<>();
        for(int x : aliceSizes) { aliceSum += x; hs.add(x); }
        for(int x : bobSizes) bobSum += x;
        int diff = (aliceSum - bobSum)/2;

        for(int bob : bobSizes) {
            if(hs.contains(bob + diff)) {
                ans[0] = bob + diff;
                ans[1] = bob;
            }
        }
        return ans;
    }
}
