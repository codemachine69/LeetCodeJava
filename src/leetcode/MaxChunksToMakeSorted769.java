package leetcode;

public class MaxChunksToMakeSorted769 {
    public int maxChunksToSorted(int[] arr) {
        int chunks = 0, referenceSum = 0, prefixSum = 0;

        for (int i = 0; i < arr.length; i++) {
            referenceSum += i;
            prefixSum += arr[i];
            if (referenceSum == prefixSum) chunks++;
        }

        return chunks;
    }
}
