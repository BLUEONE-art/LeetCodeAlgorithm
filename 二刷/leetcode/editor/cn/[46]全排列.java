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
// 👍 1232 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<List<Integer>> res = new ArrayList<>();
    int[] path;
    public List<List<Integer>> permute(int[] nums) {
        // 框架
        path = nums;
        backtrack(0);
        return res;
    }
    public void backtrack(int start) {
        HashSet<Integer> repeat = new HashSet<>();
        // 结束条件：当start递归到最后一位数字时
        if (start == path.length - 1) {
            res.add(Arrays.stream(path).boxed().collect(Collectors.toList()));
        }
        // 选择列表:每次固定其中一位的数字，跟后面的数字做交换，交换的选择随固定的数字增多而减少
        for (int i = start; i < path.length; i++) {
            // 剪枝
            if (repeat.add(path[i])) {
                // 选择
                swap(i, start);
                backtrack(start + 1);
                // 撤销
                swap(i, start);
            }
        }
    }
    public void swap(int i, int start) {
        int tmp = path[i];
        path[i] = path[start];
        path[start] = tmp;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
