package algorithm.stack;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Vector;

/*
 * 环形数组
 */
public class CircleNextGreatNumber {
    private Vector<Integer> nextGreaterElements(Vector<Integer> nums) {
        int n = nums.size();
        Vector<Integer> res = new Vector<>(5);
//        for (int i = 0; i < n; i++) {
//            res;
//        }
        res.setSize(5);
        Stack<Integer> s = new Stack<>();
        // 假装这个数组长度翻倍了
        for (int i = 2 * n -1; i >= 0; i--) {
            while (!s.isEmpty() && s.peek() <= nums.get(i % n))
                s.pop();
            // 利用 % 求模防止索引越界
            res.set((i % n), (s.isEmpty() ? -1 : s.peek()));
            s.push(nums.get(i % n));
        }
        return res;
    }

    // 找到目标数字的右边界
    public static int searchRight(int[] nums, int target) {
        if (nums.length == 0) return -1;
        int left = 0, right = nums.length;
        while (left < right) { // [left, right)
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            }
            else if (nums[mid] < target) {
                left = mid + 1;
            }
            else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) return -1;
        return nums[right - 1] == target ? (right - 1) : -1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5,7,7,8,8,10};
        int res = CircleNextGreatNumber.searchRight(nums, 6);
        System.out.println(res);
    }

//    public static void main(String[] args) {
//        CircleNextGreatNumber circleNextGreatNumber = new CircleNextGreatNumber();
//        Vector<Integer> nums = new Vector<>();
//        nums.add(2);
//        nums.add(1);
//        nums.add(2);
//        nums.add(4);
//        nums.add(3);
//        Vector<Integer> res = circleNextGreatNumber.nextGreaterElements(nums);
//        System.out.println(res);
//    }
}
