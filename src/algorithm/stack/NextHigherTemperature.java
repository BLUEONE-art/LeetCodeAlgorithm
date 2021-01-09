package algorithm.stack;

import java.util.Stack;
import java.util.Vector;

/*
 * 输入一个存有几天天气的数组，返回一个数组，计算对于每一天，至少还需要等多少天才能等到一个更暖和的气温
 * 比如：[73, 74, 75, 71, 69, 72, 76, 73] ---> [1, 1, 4, 2, 1, 1, 0, 0]
 */
public class NextHigherTemperature {
    private Vector<Integer> nextHigherTemperature(Vector<Integer> temp) {
        int size = temp.size();
        // answer Array
        Vector<Integer> ans = new Vector<>(); // 初始化 capacity 为 10，表示 Vector 类对象的容量为 10
        ans.setSize(size);
        Stack<Integer> stack = new Stack<>(); // 存放元素索引，而不是元素
        for (int i = temp.size() - 1; i >= 0; i--) {

            while (!stack.isEmpty() && temp.get(stack.peek()) <= temp.get(i)) {
                stack.pop();
            }

            ans.set(i, stack.isEmpty() ? 0 : (stack.peek() - i)); // 得到索引间距
            stack.push(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        NextHigherTemperature a = new NextHigherTemperature();
        Vector<Integer> nums = new Vector<>();
        nums.add(73);
        nums.add(74);
        nums.add(75);
        nums.add(71);
        nums.add(69);
        nums.add(72);
        nums.add(76);
        nums.add(73);
        Vector<Integer> res = a.nextHigherTemperature(nums);
        System.out.println(res);
    }

}
