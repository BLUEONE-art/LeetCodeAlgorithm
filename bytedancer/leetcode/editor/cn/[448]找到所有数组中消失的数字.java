//给你一个含 n 个整数的数组 nums ，其中 nums[i] 在区间 [1, n] 内。请你找出所有在 [1, n] 范围内但没有出现在 nums 中的数
//字，并以数组的形式返回结果。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [4,3,2,7,8,2,3,1]
//输出：[5,6]
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,1]
//输出：[2]
// 
//
// 
//
// 提示： 
//
// 
// n == nums.length 
// 1 <= n <= 105 
// 1 <= nums[i] <= n 
// 
//
// 进阶：你能在不使用额外空间且时间复杂度为 O(n) 的情况下解决这个问题吗? 你可以假定返回的数组不算在额外空间内。 
// Related Topics 数组 哈希表 
// 👍 788 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int idx = 0;
        while (idx < nums.length) {
            // 当前元素应该出现的下标idealIdx
            int idealIdx = nums[idx] - 1;
            // 1、idx对应这idx+1，不换
            // 2、本来就是交换nums[idx]和nums[idealIdx]，如果他们相等，不必多此一举再交换
            if (nums[idx] == idx + 1 || nums[idx] == nums[idealIdx]) {
                idx++;
                continue;
            }
            int tmp = nums[idx];
            nums[idx] = nums[idealIdx];
            nums[idealIdx] = tmp;
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                res.add(i + 1);
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
