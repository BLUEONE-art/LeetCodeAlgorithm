//地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一
//格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但
//它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？ 
//
// 
//
// 示例 1： 
//
// 输入：m = 2, n = 3, k = 1
//输出：3
// 
//
// 示例 2： 
//
// 输入：m = 3, n = 1, k = 0
//输出：1
// 
//
// 提示： 
//
// 
// 1 <= n,m <= 100 
// 0 <= k <= 20 
// 
// 👍 217 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    int m, n, k;
    boolean[][] visited;
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.visited = new boolean[m][n];
        return dfs(0, 0, 0, 0);
    }
    // 深度优先函数 dfs()：根据二维矩阵索引 i、j 以及其对应的位数和 si 和 sj 返回所有的可行解
    public int dfs(int i, int j, int si, int sj) {
        // base case：当 i、j 超出索引范围、si、sj 的和大于 k、visited[i][j] 中元素已经被访问过了，返回 0
        if (i >= m || j >= n || si + sj > k || visited[i][j]) return 0;
        visited[i][j] = true;
        // 往下搜 + 往右搜(往上和往左回溯结果)
        // (i + 1) % 10 == 0: 比如 i = 19 ==> i + 1 = 20 位数和为 2 == 1 + 9 = 10 - 8 = 2
        return 1 + dfs(i + 1, j, (i + 1) % 10 == 0 ? si - 8 : si + 1, sj) + dfs(i, j + 1, si, (j + 1) % 10 == 0 ? sj - 8 : sj + 1);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
