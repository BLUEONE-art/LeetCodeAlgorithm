//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 814 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
//    // 现在是一定可以到达数组的最后一位，要求出到最后一位最小要跳的次数
//    // 动态规划
//    public int jump(int[] nums) {
//        // 创建备忘录放每一个子问题的结果
//        int n = nums.length;
//        // 因为从 0 到 n - 1(末尾位置) 最多走 n - 1 步，初始化要一个不在选择范围的数
//        int[] memo = new int[n];
//        Arrays.fill(memo, n);
//        return dp(memo, nums, 0);
//    }
//    // dp(nums, p)：表示从 p 位置开始跳到末尾最少用的步数为 dp(nums, p)
//    // 我们要求的就是 dp(nums, 0)：从 0 位置开始跳到末尾的最小步数
//    private int dp(int[] memo, int[] nums, int p) {
//        int n = nums.length;
//        // base case：如果 p 已经超过或等于最后一位的位置(n - 1)，需要 0 步
//        if (p >= n - 1) return 0;
//        // 如果备忘录里有结果，直接返回
//        if (memo[p] != n) {
//            return memo[p];
//        }
//        // 循环遍历递归
//        // 在 p 位置可以走 steps 步
//        int steps = nums[p];
//        // 我选择可以走 1 ~ steps 步
//        for (int i = 1; i <= steps; i++) {
//            // 递归到子问题 dp(memo, nums, p + i)
//            // 转换为从 p 跳到末尾 --> p + i 位置跳到末尾
//            int subProblem = dp(memo, nums, p + i);
//            // 找到所有可能 (p + 1 ~ steps) 中最小次数的结果存入 memo
//            memo[p] = Math.min(memo[p], subProblem + 1); // +1 表示在 p 位置跳到 p + i 算一次
//        }
//        return memo[p];
//    }

    public int jump(int[] nums) {
        // 动态规划的时候是在 p 位置计算所有可能的子问题，在子问题中选择步数最小的
        // --> 贪心算法：如果在 p 位置，下一次可以选择跳的步数就是 p + 1 ~ nums[p]
        // --> 只要我找到 1 ~ nums[p] 中下一次能跳的最远的位置，比如说 [3, 1, 4, 2]，p = 0 的时候跳一次能跳到 p = 2 的位置就好了
        int n = nums.length;
        int farthest = 0, end = 0;
        int jumps = 0;
        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + nums[i]);
            if (end == i) {
                jumps++;
                end = farthest;
            }
        }
        return jumps;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
