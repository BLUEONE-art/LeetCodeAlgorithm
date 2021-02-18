//输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。 
//
// 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。 
//
// 
//
// 示例 1： 
//
// 输入：target = 9
//输出：[[2,3,4],[4,5]]
// 
//
// 示例 2： 
//
// 输入：target = 15
//输出：[[1,2,3,4,5],[4,5,6],[7,8]]
// 
//
// 
//
// 限制： 
//
// 
// 1 <= target <= 10^5 
// 
//
// 
// 👍 213 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 有序数组(单调递增，默认从 1，2，3，4... 开始递增) ---> 双指针
    public int[][] findContinuousSequence(int target) {
        // 数组元素从 1 开始，没有 0 元素
        int left = 1, right = 2;
        List<int[]> res = new ArrayList<>();
        // 初始化 sum = left + right
        int sum = 3;
        while (left < right) {
            if (sum == target) {
                // 局部变量存放每一个可行解
                int[] ans = new int[right - left + 1];
                // 截取凑成 target 的元素放入数组
                for (int i = left; i <= right; i++) {
                    ans[i - left] = i;
                }
                res.add(ans);
            }
            if (sum < target) {
                // nums[left] + nums[left + 1] + ... + nums[right] < target, 所以要增大 right，继续求和
                right++;
                sum += right;
            } else {
                // nums[left] + nums[left + 1] + ... + nums[right] >= target, 所以要增大 left，继续求和
                sum -= left;
                left++;
            }
        }
        return res.toArray(new int[0][]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
