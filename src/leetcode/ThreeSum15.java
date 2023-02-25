package leetcode;

import java.util.*;

public class ThreeSum15 {

    public List<List<Integer>> threeSum_TwoPointer(int[] nums) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int l = i + 1, r = nums.length-1;
            while (l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                if (sum < 0) l++;
                else if (sum > 0) r--;
                else {
                    ans.add(new ArrayList<>(List.of(nums[i], nums[l], nums[r])));
                    while (l < r && nums[l] == nums[l+1]) l++;
                    while (l < r && nums[r] == nums[r-1]) r--;
                    l++; r--;
                }
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSum_HashMap(int[] nums) {
        HashSet<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int target = -nums[i];
            HashSet<Integer> hs = new HashSet<>();
            for (int j = i + 1; j < nums.length; j++) {
                if (hs.contains(target - nums[j])) {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(target - nums[j]);
                    Collections.sort(temp);
                    ans.add(temp);
                } else hs.add(nums[j]);
            }
        }
        return new ArrayList<List<Integer>>(ans);
    }
}
