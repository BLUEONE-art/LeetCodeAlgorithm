//给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的数字可以无限制重复被选取。 
//
// 说明： 
//
// 
// 所有数字（包括 target）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1： 
//
// 输入：candidates = [2,3,6,7], target = 7,
//所求解集为：
//[
//  [7],
//  [2,2,3]
//]
// 
//
// 示例 2： 
//
// 输入：candidates = [2,3,5], target = 8,
//所求解集为：
//[
//  [2,2,2,2],
//  [2,3,3],
//  [3,5]
//] 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都是独一无二的。 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯算法 
// 👍 1343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        res = new ArrayList<>();
        if (len == 0) return res;

        Arrays.sort(candidates);
        Deque<Integer> path = new ArrayDeque<>();
        dfs(candidates, 0, len, target, path);
        return res;
    }

    public void dfs(int[] candidates, int start, int len, int target, Deque<Integer> path) {
        // 终止条件
//        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        // 所有可能的选择
        for (int i = start; i < len; i++) {
            // 剪枝
            if (target - candidates[i] < 0) break;

            // 做选择
            path.addLast(candidates[i]);
            // 递归：因为每一个元素可重复利用，下一轮起点仍是 i
            dfs(candidates, i, len, target - candidates[i], path);
            // 撤销
            path.removeLast();
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
