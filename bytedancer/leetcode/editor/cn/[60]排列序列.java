//给出集合 [1,2,3,...,n]，其所有元素共有 n! 种排列。 
//
// 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下： 
//
// 
// "123" 
// "132" 
// "213" 
// "231" 
// "312" 
// "321" 
// 
//
// 给定 n 和 k，返回第 k 个排列。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3, k = 3
//输出："213"
// 
//
// 示例 2： 
//
// 
//输入：n = 4, k = 9
//输出："2314"
// 
//
// 示例 3： 
//
// 
//输入：n = 3, k = 1
//输出："123"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 1 <= k <= n! 
// 
// Related Topics 递归 数学 
// 👍 553 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    List<String> res = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return String.valueOf(n);
        }
        boolean[] visited = new boolean[n];
        backtrack(n, 0, visited);
        int[] ans = res.stream().mapToInt(Integer::valueOf).toArray();
        Arrays.sort(ans);
        return String.valueOf(ans[k - 1]);
    }

    public void backtrack(int n, int depth, boolean[] visited) {
        if (depth == n) {
            List<String> tmp = new ArrayList<>(path);
            StringBuilder levelRes = new StringBuilder();
            for (String s : tmp) {
                levelRes.append(s);
            }
            res.add(levelRes.toString());
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                path.add((i + 1) + "");
                visited[i] = true;
                backtrack(n, depth + 1, visited);
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
