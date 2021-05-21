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

//         if (nums.length <= 1) return nums;
//        // 大顶堆
//        Queue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
//        for (int num : nums) {
//            q.offer(num);
//        }
//        int[] res = new int[nums.length];
//        for (int i = nums.length - 1; i >= 0; i--) {
//            res[i] = q.poll();
//        }
//        return res;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] sortArray(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
        return nums;
    }

    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) return;
        int j = partition(nums, left, right);
        quickSort(nums, left, j - 1);
        quickSort(nums, j + 1, right);
    }

    public int partition(int[] nums, int left, int right) {
        int leftMostNum = nums[left];
        int i = left, j = right + 1;
        while (true) {
            while (++i < right && nums[i] < leftMostNum);
            while (--j > left && nums[j] > leftMostNum);
            if (i >= j) break;
            swap(nums, i, j);
        }
        nums[left] = nums[j];
        nums[j] = leftMostNum;
        return j;
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
