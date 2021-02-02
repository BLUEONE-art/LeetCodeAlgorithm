//给定一个非负整数数组 nums ，你最初位于数组的 第一个下标 。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 判断你是否能够到达最后一个下标。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,1,1,4]
//输出：true
//解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1,0,4]
//输出：false
//解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 3 * 104 
// 0 <= nums[i] <= 105 
// 
// Related Topics 贪心算法 数组 
// 👍 1030 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路：判断是否能够到达最后一个下标 ==> 按照跳跃的规则，能跳的最远距离是多少？
    // ==> 如果最远距离大于数组的长度，返回 true，否则 false
    public boolean canJump(int[] nums) {
        int n = nums.length;
        // 初始化最远距离为 0
        int farthest = 0;
        // 因为最后只要 farthest >= n - 1 即可
        // 所以 i 取到 n - 2 的位置算出的 farthest 能跳到最后一格或者跳出去都满足条件
        for (int i = 0; i < n - 1; i++) {
            // 不断更新 farthest，每跳到一个新的位置，之前的 farthest 与当前的可以跳到的最远位置 i + nums[i] 进行比较
            // 两者取最优，就是最大的 farthest
            farthest = Math.max(farthest, i + nums[i]);
            // 如果最远距离就是 i 位置自己，那么就算 i + 1，自己也跳不过去，[0,2,3] 的情况
            if (farthest - i <= 0) return false;
        }
        // i 取到 n - 2 的位置算出的 farthest
        return farthest >= n - 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
