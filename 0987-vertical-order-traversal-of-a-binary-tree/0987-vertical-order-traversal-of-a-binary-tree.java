class Solution {

    private void helper(TreeNode root,
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map,
        int c, int r) {

        if (root == null) return;

        map.putIfAbsent(c, new TreeMap<>());
        map.get(c).putIfAbsent(r, new PriorityQueue<>());
        map.get(c).get(r).offer(root.val);

        helper(root.left, map, c - 1, r + 1);
        helper(root.right, map, c + 1, r + 1);
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Map<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        helper(root, map, 0, 0);

        for (Map<Integer, PriorityQueue<Integer>> cols : map.values()) {
            List<Integer> colList = new ArrayList<>();

            for (PriorityQueue<Integer> pq : cols.values()) {
                while (!pq.isEmpty()) {
                    colList.add(pq.poll());
                }
            }

            res.add(colList);
        }

        return res;
    }
}