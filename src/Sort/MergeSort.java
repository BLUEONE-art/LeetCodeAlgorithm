package Sort;

public class MergeSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,1,2};
        int[] tmp = new int[nums.length];
        MergeSort m = new MergeSort();
        m.mergeSort(nums, 0, nums.length - 1, tmp);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void mergeSort(int[] nums, int left, int right, int[] tmp) {
        if (right - left <= 0) return;
        int mid = (left + right) / 2;
        mergeSort(nums, left, mid, tmp);
        mergeSort(nums, mid + 1, right, tmp);
        int subLeft1 = left, subLeft2 = mid + 1;
        for (int i = left; i <= right; i++) {
            tmp[i] = nums[i];
        }
        for (int k = left; k <= right; k++) {
            if (subLeft1 == mid + 1) {
                nums[k] = tmp[subLeft2++];
            }
            else if (subLeft2 == right + 1 || tmp[subLeft1] <= tmp[subLeft2]) {
                nums[k] = tmp[subLeft1++];
            }
            else { // 逆序对
                nums[k] = tmp[subLeft2++];
            }
        }
    }
}
