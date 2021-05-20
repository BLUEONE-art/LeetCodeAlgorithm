//给你一个正整数 n ，请你找出符合条件的最小整数，其由重新排列 n 中存在的每位数字组成，并且其值大于 n 。如果不存在这样的正整数，则返回 -1 。 
//
// 注意 ，返回的整数应当是一个 32 位整数 ，如果存在满足题意的答案，但不是 32 位整数 ，同样返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 12
//输出：21
// 
//
// 示例 2： 
//
// 
//输入：n = 21
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 231 - 1 
// 
// Related Topics 字符串 
// 👍 144 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nextGreaterElement(int n) {
        int tmp = n, count = 0, res = 0;
        while (tmp != 0) {
            count++;
            tmp /= 10;
        }
        int[] nums = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            nums[i] = n % 10;
            n /= 10;
        }

        // 特判全是升序情况
        int size = count - 2;
        for (; size >= 0; size--) {
            if (nums[size] < nums[size + 1]) break;
        }
        if (size < 0) return -1;

        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            int tmp_res = res;
            res = res * 10 + nums[i];
            if (res / 10 != tmp_res) return -1;
        }
        return res;
    }

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
