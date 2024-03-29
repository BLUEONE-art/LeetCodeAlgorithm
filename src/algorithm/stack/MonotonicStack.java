package algorithm.stack;
import java.util.Stack;
import java.util.Vector;

/*
 * 找到下一个更大的元素I
 * 比如输入一个数组 nums = [2, 1, 2, 4, 3]，算法返回 [4, 2, 4, -1, -1]
 * 暴力破解方法：对每个元素后面进行扫描，找到第一个更大的元素就行了。暴力破解的时间复杂度：O(n^2)
 * 算法时间复杂度为：O(n)
 * 从整体上看：因为总共有 n 个元素，每个元素都被 push 入栈了一次，最多也会被 pop 一次，没有任何冗余操作。所以总的计算规模是和元素规模 n 成正比的。
 */
public class MonotonicStack {
    private Vector<Integer> nextGreaterElement(Vector<Integer> nums) {
        int size = nums.size();
        Vector<Integer> ans = new Vector<>(5); // 存放答案的数组
        ans.setSize(size);
        Stack<Integer> s = new Stack<>();
        for (int i = nums.size() - 1; i >= 0; i--) {
            // 倒着往栈里放
            while (!s.isEmpty() && s.peek() <= nums.get(i)) { // 判断个子高矮
                s.pop(); // 矮个子出列，反正也被挡住了
            }
            // 这个元素的身后的第一个高个
            ans.set(i, s.empty() ? -1 : s.peek());
            s.push(nums.get(i)); // 进队，接受之后的身高判断
        }
        return ans;
    }

    public static void main(String[] args) {
        MonotonicStack monotonicStack = new MonotonicStack();
        Vector<Integer> nums = new Vector<>(5);
        nums.add(2);
        nums.add(1);
        nums.add(2);
        nums.add(4);
        nums.add(3);
        System.out.println(nums.firstElement());
        System.out.println(nums.lastElement());
        Vector<Integer> res = monotonicStack.nextGreaterElement(nums);
        System.out.println(res);
    }
}
