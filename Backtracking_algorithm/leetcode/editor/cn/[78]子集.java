//给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。 
//
// 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0]
//输出：[[],[0]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10 
// -10 <= nums[i] <= 10 
// nums 中的所有元素 互不相同 
// 
// Related Topics 位运算 数组 回溯算法 
// 👍 1044 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        backtrack(nums, 0, path, res);
        return res;
    }

    public void backtrack(int[] nums, int start, List<Integer> path, List<List<Integer>> res) {
        // 终止条件
        res.add(new ArrayList<>(path));
        // 选择列表：因为数组是无重复元素，一直往后面的元素找
        for (int i = start; i < nums.length; i++) {
            // 选择
            path.add(nums[i]);
            // 往后面找
            backtrack(nums, i + 1, path, res);
            // 撤销
            path.remove(path.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
