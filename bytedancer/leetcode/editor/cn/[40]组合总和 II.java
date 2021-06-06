//给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用一次。 
//
// 说明： 
//
// 
// 所有数字（包括目标数）都是正整数。 
// 解集不能包含重复的组合。 
// 
//
// 示例 1: 
//
// 输入: candidates = [10,1,2,7,6,1,5], target = 8,
//所求解集为:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
// 
//
// 示例 2: 
//
// 输入: candidates = [2,5,2,1,2], target = 5,
//所求解集为:
//[
//  [1,2,2],
//  [5]
//] 
// Related Topics 数组 回溯算法 
// 👍 588 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int len = candidates.length;
        res = new ArrayList<>();
        if (len == 0) return res;

        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        helper(candidates, 0, len, target, path);
        return res;
    }

    public void helper(int[] candidates, int start, int len, int target, List<Integer> path) {
        // 终止条件
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历
        for (int i = start; i < len; i++) {
            if (target - candidates[i] < 0) break;
            if (i > start && candidates[i] == candidates[i - 1]) continue;

            path.add(candidates[i]);
            helper(candidates, i + 1, len, target - candidates[i], path);
            path.remove(path.get(path.size() - 1));
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
