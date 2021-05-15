//给你一个整数数组 nums，请你将该数组升序排列。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：nums = [5,2,3,1]
//输出：[1,2,3,5]
// 
//
// 示例 2： 
//
// 输入：nums = [5,1,1,2,0,0]
//输出：[0,0,1,1,2,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 50000 
// -50000 <= nums[i] <= 50000
// 👍 286 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        if (nums.length <= 1) return nums;
        // 大顶堆
        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int num : nums) {
            q.offer(num);
        }
        int[] res = new int[nums.length];
        for (int i = nums.length - 1; i >= 0; i--) {
            res[i] = q.poll();
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
