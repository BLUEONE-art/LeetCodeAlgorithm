//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//
// 
//
// 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 300 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 
// 👍 1077 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        // 极端情况：nums = [1,2,3,4] --> 最小消失整数：nums.length + 1 = 5，所以结果取值范围[1， len + 1]
        int len = nums.length;
        // 大于等于1小于等于len
        // 交换元素不在自己该待的位置nums[i] != i+1
        // 交换元素要被交换的地方没有被重复元素占领nums[i] = i+1 --> i = nums[i]-1 --> nums[nums[i] - 1] != nums[i]
        for (int i = 0; i < len; i++) {
            while (nums[i] >= 1 && nums[i] <= len && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
                swap(nums, nums[i] - 1, i);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) return i + 1;
        }
        return len + 1;
    }
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
