package leetcode;

import java.util.ArrayList;

public class ProductOfLastKNumbers1352 {
    ArrayList<Integer> arr;

    public ProductOfLastKNumbers1352() {
        arr = new ArrayList<>();
        arr.add(1);
    }

    public void add(int num) {
        if (num == 0) {
            arr.clear();
            arr.add(1);
        } else arr.add(num * arr.get(arr.size() - 1));
    }

    public int getProduct(int k) {
        int s = arr.size();
        if (s - 1 < k) return 0;
        else return arr.get(s - 1) / arr.get(s - k - 1);
    }
}
