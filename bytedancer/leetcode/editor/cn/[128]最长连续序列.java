//给定一个未排序的整数数组 nums ，找出数字连续的最长序列（不要求序列元素在原数组中连续）的长度。 
//
// 
//
// 进阶：你可以设计并实现时间复杂度为 O(n) 的解决方案吗？ 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [100,4,200,1,3,2]
//输出：4
//解释：最长数字连续序列是 [1, 2, 3, 4]。它的长度为 4。 
//
// 示例 2： 
//
// 
//输入：nums = [0,3,7,2,5,8,4,6,0,1]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 104 
// -109 <= nums[i] <= 109 
// 
// Related Topics 并查集 数组 
// 👍 766 👎 0

//     public int longestConsecutive(int[] nums) {
//        if (nums.length < 1) return 0;
//        Arrays.sort(nums);
//        int count = 1, res = 1;
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] - nums[i - 1] == 1) {
//                count++;
//                res = Math.max(res, count);
//            }
//            else if (nums[i] - nums[i - 1] == 0){
//                count = count;
//            }
//            else {
//                count = 1;
//            }
//        }
//        return res;
//    }
//
//    public void quickSort(int[] nums, int low, int high) {
//        if (low - high >= 0) return;
//        int pivot = partition(nums, low, high);
//        quickSort(nums, low, pivot - 1);
//        quickSort(nums, pivot + 1, high);
//    }
//
//    public int partition(int[] nums, int low, int high) {
//        int leftMostNum = nums[low];
//        int i = low, j = high + 1;
//        while (true) {
//            while (++i < high && nums[i] < leftMostNum);
//            while (--j > low && nums[j] > leftMostNum);
//            if (i >= j) break;
//            swap(nums, i, j);
//        }
//        nums[low] = nums[j];
//        nums[j] = leftMostNum;
//        return j;
//    }
//
//    public void swap(int[] nums, int i, int j) {
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num); // 去重
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            int len = 0;
            while (set.contains(nums[i] + len)) {
                len++;
            }
            res = Math.max(res, len);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
