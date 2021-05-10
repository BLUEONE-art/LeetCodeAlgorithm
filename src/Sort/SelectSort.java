package Sort;

public class SelectSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,1,2,6};
        SelectSort s = new SelectSort();
        s.selectSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void selectSort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            // 找出 i+1 ~ nums.length - 1 中的最小值
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (min > nums[j]) {
                    min = nums[j];
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
