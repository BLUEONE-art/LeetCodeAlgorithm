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
// 👍 531 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    List<Integer> path;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        path = new ArrayList<>();
        if (n <= 0 || k <= 0) return res;
        // 框架
        backtrack(1, n, k);
        return res;
    }
    public void backtrack(int start, int len, int k) {
        // 终止条件
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 选择列表，nums[] 中没有重复的数字，是 1 ~ n
        for (int i = start; i <= len; i++) {
            // 选择
            path.add(i);
            backtrack(i + 1, len, k);
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
