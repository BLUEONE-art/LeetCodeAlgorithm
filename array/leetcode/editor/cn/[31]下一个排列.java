//实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。 
//
// 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。 
//
// 必须 原地 修改，只允许使用额外常数空间。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[1,2,3]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1,1,5]
//输出：[1,5,1]
// 
//
// 示例 4： 
//
// 
//输入：nums = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 100 
// 
// Related Topics 数组 
// 👍 1095 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public void nextPermutation(int[] nums) {
        int size = nums.length;
        if (nums == null || size == 0) return;
        // 从后往前找到第一个逆序对
        int i = size - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) break;
        }
        // 此时找到 i 和 i + 1 两个索引对应的值从后往前看是逆序的
        // 想要找到下一个更大的排序，需要找到在 i + 1 ~ size - 1 范围内大于索引 i 对应值的最小值
        if (i >= 0) { // i < 0 表示从后向前看全是升序
            // 大于 nums[i] 的最小值对应的索引
            int j = binSearch(nums, i + 1, size - 1, nums[i]);
            // 交换 nums[i] 和 大于 nums[i] 的最小值
            swap(nums, i, j);
        }
        // 为了使得找到的数是大于数组字典序的最小值，让 nums[i] 后的数字排列为升序即可
        reverse(nums, i + 1, size - 1);
    }

    // nums[left, right] 逆序，查找其中 > target 的 最大下标
    private int binSearch(int[] nums, int left, int right, int target){
        while(left <= right){
            int mid = (left + right) >>> 1;
            if(nums[mid] > target){
                left = mid + 1; // 尝试再缩小区间
            }
            else{
                right = mid - 1;
            }
        }
        return right;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
