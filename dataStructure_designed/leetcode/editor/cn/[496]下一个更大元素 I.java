//给你两个 没有重复元素 的数组 nums1 和 nums2 ，其中nums1 是 nums2 的子集。 
//
// 请你找出 nums1 中每个元素在 nums2 中的下一个比其大的值。 
//
// nums1 中数字 x 的下一个更大元素是指 x 在 nums2 中对应位置的右边的第一个比 x 大的元素。如果不存在，对应位置输出 -1 。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums1 = [4,1,2], nums2 = [1,3,4,2].
//输出: [-1,3,-1]
//解释:
//    对于 num1 中的数字 4 ，你无法在第二个数组中找到下一个更大的数字，因此输出 -1 。
//    对于 num1 中的数字 1 ，第二个数组中数字1右边的下一个较大数字是 3 。
//    对于 num1 中的数字 2 ，第二个数组中没有下一个更大的数字，因此输出 -1 。 
//
// 示例 2: 
//
// 
//输入: nums1 = [2,4], nums2 = [1,2,3,4].
//输出: [3,-1]
//解释:
//    对于 num1 中的数字 2 ，第二个数组中的下一个较大数字是 3 。
//    对于 num1 中的数字 4 ，第二个数组中没有下一个更大的数字，因此输出 -1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums1.length <= nums2.length <= 1000 
// 0 <= nums1[i], nums2[i] <= 104 
// nums1和nums2中所有整数 互不相同 
// nums1 中的所有整数同样出现在 nums2 中 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(nums1.length + nums2.length) 的解决方案吗？ 
// Related Topics 栈 
// 👍 345 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 核心思想：数组中的元素想象成一组不同身高的人，矮的人会被高的人遮住，所以只有越来越高才能被看见
    // 即下一个更大的元素，输出没被“遮住”的元素
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int [] res = new int[nums1.length];
        // 栈中用来存放“更大的数”并不断更新
        Stack<Integer> s = new Stack<>();
        // 将 nums 数组的元素倒着放入栈中
        for (int i = nums2.length - 1; i >= 0; i--) {

            // 如果栈中元素不为空，说明至少两个以上的元素进行比较得出了一个更大的数，否则 s 会一直为空、
            while (!s.isEmpty() && nums2[i] >= s.peek()) {
                // 如果新输入的树比原来 s 中存的最大数还要大，那 s 的栈顶元素可以换了
                s.pop();
            }

            map.put(nums2[i], s.isEmpty() ? -1 : s.peek());

            s.push(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
