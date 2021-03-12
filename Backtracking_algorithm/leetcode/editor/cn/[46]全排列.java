//给定一个 没有重复 数字的序列，返回其所有可能的全排列。 
//
// 示例: 
//
// 输入: [1,2,3]
//输出:
//[
//  [1,2,3],
//  [1,3,2],
//  [2,1,3],
//  [2,3,1],
//  [3,1,2],
//  [3,2,1]
//] 
// Related Topics 回溯算法 
// 👍 1196 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        // 回溯框架
        backtrack(0, nums);
        return res;
    }

    public void backtrack(int start, int[] nums) {
        HashSet<Integer> repeat = new HashSet<>();
        // 终止条件
        if (start == nums.length - 1) {
            // List<Integer> list1 = Arrays.stream(data).boxed().collect(Collectors.toList());
            // Arrays.stream(arr) 可以替换成IntStream.of(arr)。
            // 1.使用Arrays.stream将int[]转换成IntStream。
            // 2.使用IntStream中的boxed()装箱。将IntStream转换成Stream<Integer>。
            // 3.使用Stream的collect()，将Stream<T>转换成List<T>，因此正是List<Integer>。
            res.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
            return;
        }
        // 选择列表
        for (int i = start; i < nums.length; i++) {
            // 剪枝
            if (repeat.contains(nums[i])) {
                continue;
            }
            repeat.add(nums[i]);
            // 做选择
            swap(i, start, nums);
            backtrack(start + 1, nums);
            swap(i, start, nums);
        }
    }

    public void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
