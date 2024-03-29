//假设按照升序排序的数组在预先未知的某个点上进行了旋转。 
//
// ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。 
//
// 请找出其中最小的元素。 
//
// 注意数组中可能存在重复的元素。 
//
// 示例 1： 
//
// 输入: [1,3,5]
//输出: 1 
//
// 示例 2： 
//
// 输入: [2,2,2,0,1]
//输出: 0 
//
// 说明： 
//
// 
// 这道题是 寻找旋转排序数组中的最小值 的延伸题目。 
// 允许重复会影响算法的时间复杂度吗？会如何影响，为什么？ 
// 
// Related Topics 数组 二分查找 
// 👍 245 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMin(int[] nums) {
        int count = 1;
        // 找到旋转数组中递增的最后一个元素的后一个元素的索引
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] >= 0) {
                count++;
            }
            // 找到第一个逆序数对
            else {
                break;
            }
        }
        // 此时都是顺序排序的
        if (count == nums.length) {
            return nums[0];
        }
        // 返回第一个逆序数对的数
        else {
            return nums[count];
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
