package Sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] nums = new int[]{3,5,4,1,2,6};
        InsertSort ins = new InsertSort();
        ins.insertSort(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }

    public void insertSort(int[] nums) {
        if (nums.length <= 1) return;
        for (int i = 1; i < nums.length; i++) {
            for (int j = i; j > 0; j--) {
                if (nums[j] < nums[j - 1]) {
                    swap(nums, j, j - 1);
                } else break;

            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
