//给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。 
//
// 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。 
//
// 说明: 
//
// 
// 返回的下标值（index1 和 index2）不是从零开始的。 
// 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。 
// 
//
// 示例: 
//
// 输入: numbers = [2, 7, 11, 15], target = 9
//输出: [1,2]
//解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。 
// Related Topics 数组 双指针 二分查找 
// 👍 460 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 有序数组 --> 左右指针 */
    public int[] twoSum(int[] numbers, int target) {
        int left, right;
        // 搜索空间 [left, right]
        left = 0; right = numbers.length - 1;
        while (left <= right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) return new int[]{left + 1, right + 1};
            else if (sum < target) {
                // 让 left 增大一点，则 number[left] 也增大，sum 也会增大
                left++;
            } else if (sum > target) {
                // 让 right 减小一点，number[right] 减小，sum 也减小
                right--;
            }
        }
        return new int[]{-1, -1};
    }
}
//leetcode submit region end(Prohibit modification and deletion)
