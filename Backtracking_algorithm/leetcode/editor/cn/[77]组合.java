//给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。 
//
// 示例: 
//
// 输入: n = 4, k = 2
//输出:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//] 
// Related Topics 回溯算法 
// 👍 515 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 0 || k <= 0) return res;
        // 回溯框架
        List<Integer> path = new ArrayList<>();
        // start 不为 0，因为返回从 1~n 的组合
        backtrack(n, k, 1, path, res);
        return res;
    }

    public void backtrack(int n, int k, int start, List<Integer> path, List<List<Integer>> res) {
        // 终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 选择列表
        for (int i = start; i <= n; i++) {
            // 做选择
            path.add(i);
            // 回溯框架
            backtrack(n, k, i + 1, path, res);
            // 撤销选择
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
