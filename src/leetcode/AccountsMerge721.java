package leetcode;

import java.util.*;

public class AccountsMerge721 {

    private class DisjoinSet {
        private int[] parent;
        private int[] size;
        int numberOfComponents;

        public DisjoinSet(int n) {
            parent = new int[n];
            size = new int[n];
            numberOfComponents = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }

        public int find(int x) {
            if (x == parent[x])
                return x;

            return parent[x] = find(parent[x]);
        }

        public void union(int x, int y) {
            int parentX = find(x);
            int parentY = find(y);

            if (parentX != parentY) {
                if (size[parentX] > size[parentY]) {
                    parent[parentY] = parentX;
                } else if (size[parentY] > size[parentX]) {
                    parent[parentX] = parentY;
                } else {
                    parent[parentY] = parentX;
                    size[parentX] += 1;
                }
                numberOfComponents--;
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        HashMap<String, Integer> hm = new HashMap<>();
        int n = accounts.size();
        DisjoinSet ds = new DisjoinSet(n);

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String mail = accounts.get(i).get(j);
                if (!hm.containsKey(mail)) hm.put(mail, i);
                else ds.union(i, hm.get(mail));
            }
        }

        ArrayList<String>[] mergedMail = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            mergedMail[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String mail = entry.getKey();
            Integer node = ds.find(entry.getValue());
            mergedMail[node].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (mergedMail[i].size() == 0) continue;
            Collections.sort(mergedMail[i]);
            List<String> temp = new ArrayList<>();
            temp.add(accounts.get(i).get(0));
            for (String s : mergedMail[i]) temp.add(s);
            ans.add(temp);
        }
        return ans;
    }
}
