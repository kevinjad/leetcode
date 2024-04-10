class Solution {
    public List<List<Integer>> combine(int n, int k) {
        LinkedList<Integer> l = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        helper(1, n, k, l, result);
        return result;
    }

    public void helper(int i, int n, int k, LinkedList<Integer> l, List<List<Integer>> result) {
        if (l.size() == k) {
            result.add(new ArrayList<>(l));
            return;
        }

        for (int j = i; j <= n; j++) {
            l.add(j);
            helper(j + 1, n, k, l, result);
            l.removeLast();
        }
    }
}