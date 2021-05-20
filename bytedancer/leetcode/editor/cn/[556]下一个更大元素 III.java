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
        int tmp = n, size = 0, res = 0;
        while (tmp != 0) {
            size++;
            tmp /= 10;
        }
        int[] nums = new int[size];
        for (int i = size - 1; i >= 0; i--) {
            nums[i] = n % 10;
            n /= 10;
        }
        // 特判全是降序，返回-1
        int j = size - 2;
        for (; j >= 0; j--) {
            if (nums[j] < nums[j + 1]) break;
        }
        if (j < 0) return -1;

        nextPermutation(nums);
        for (int i = 0; i < nums.length; i++) {
            int last_res = res;
            res = res * 10 + nums[i];
            if (res / 10 != last_res) return -1;
        }
        return res;
    }

    public void nextPermutation(int[] nums) {
        int size = nums.length;
        if (nums == null || size == 0) return;
        // 从后往前找逆序对（前往后看是升序的）
        int i = size - 2;
        for (; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) break;
        }
        if (i >= 0) { // i < 0表示从前往后看全是升序，根本没有更大的排列了
            int j = findBiggerNum(nums, i + 1, size - 1, nums[i]); // 找到nums[i] ~ nums[size - 1]中大于nums[i]的最小值对应的索引
            swap(nums, i, j);
        }
        reverse(nums, i + 1, size - 1); // 让nums[i]后面的数保持升序，即是大于nums的最小排列
    }

    public int findBiggerNum(int[] nums, int left, int right, int tar) {
        while (left <= right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] > tar) { // 找大于tar的最小数，所以mid后面可能还有大于tar的数并且比nums[mid]小
                left = mid + 1;
            }
            else {
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
