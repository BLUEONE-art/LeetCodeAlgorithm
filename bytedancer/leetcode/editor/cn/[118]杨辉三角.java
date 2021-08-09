//给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。 
//
// 在「杨辉三角」中，每个数是它左上方和右上方的数的和。 
//
// 
//
// 
//
// 示例 1: 
//
// 
//输入: numRows = 5
//输出: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
// 
//
// 示例 2: 
//
// 
//输入: numRows = 1
//输出: [[1]]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= numRows <= 30 
// 
// Related Topics 数组 动态规划 
// 👍 542 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> levelRes = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            // 每层第一个数
            levelRes.add(0, 1);
            for (int j = 1; j < levelRes.size() - 1; j++) {
                levelRes.set(j, levelRes.get(j) + levelRes.get(j + 1));
            }
            res.add(new ArrayList<>(levelRes));
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
