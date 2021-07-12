//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 104 
// -104 <= nums[i] <= 104 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 
// 👍 1166 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.offer(num);
            if (heap.size() > k) {
                heap.poll();
            }
        }
        return heap.peek();
    }

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    public static void quickSort(int[] nums, int low, int high) {
        if (low >= high) {
            return;
        }
        int pivot = partition(nums, low, high);
        quickSort(nums, low, pivot - 1);
        quickSort(nums, pivot + 1, high);
    }

    public static int partition(int[] nums, int low, int high) {
        int leftmostNum = nums[low];
        int left = low, right = high + 1;
        while (true) {
            while (++left < high && nums[left] < leftmostNum);
            while (--right > low && nums[right] > leftmostNum);
            if (left >= right) {
                break;
            }
            swap(nums, left, right);
        }
        nums[low] = nums[right];
        nums[right] = leftmostNum;
        return right;
    }

    public static void swap(int[] nums, int low, int high) {
        int tmp = nums[low];
        nums[low] = nums[high];
        nums[high] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
