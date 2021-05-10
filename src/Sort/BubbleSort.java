package Sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,1,2,6};
        BubbleSort b = new BubbleSort();
        b.bubbleSort(nums, nums.length);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void bubbleSort(int[] nums, int n) {
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            // j 最大取值范围：[0 ~ n - 2]
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j + 1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public void bubbleSort(int[] nums) {
        int n = nums.length;
        if (n <= 1) return;
        for (int i = 0; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    swap(nums, j, j+1);
                    flag = true;
                }
            }
            if (!flag) break;
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
