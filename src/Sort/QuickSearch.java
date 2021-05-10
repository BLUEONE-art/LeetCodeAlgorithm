package Sort;

public class QuickSearch {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,1,2};
        QuickSearch q = new QuickSearch();
        q.quickSearch(nums, 0, nums.length - 1);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void quickSearch(int[] nums, int low, int high) {
        if (low - high >= 0) return;
        int pivot = partition(nums, low, high);
        quickSearch(nums, low, pivot - 1);
        quickSearch(nums, pivot + 1, high);
    }

    // 快速分区
    public int partition(int[] nums, int low, int high) {
        int leftMostNum = nums[low];
        int i = low, j = high + 1;
        while (true) {
            // ++i < high <==> i < high + 1
            while (++i < high && nums[i] < leftMostNum);
            // --j > low <==> j > low + 1
            while (--j > low && nums[j] > leftMostNum);
            if (i >= j) break;
            swap(nums, i, j);
        }
        nums[low] = nums[j];
        nums[j] = leftMostNum;
        return j;
    }

    // 交换函数
    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
