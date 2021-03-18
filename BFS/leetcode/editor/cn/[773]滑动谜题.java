//在一个 2 x 3 的板上（board）有 5 块砖瓦，用数字 1~5 来表示, 以及一块空缺用 0 来表示. 
//
// 一次移动定义为选择 0 与一个相邻的数字（上下左右）进行交换. 
//
// 最终当板 board 的结果是 [[1,2,3],[4,5,0]] 谜板被解开。 
//
// 给出一个谜板的初始状态，返回最少可以通过多少次移动解开谜板，如果不能解开谜板，则返回 -1 。 
//
// 示例： 
//
// 
//输入：board = [[1,2,3],[4,0,5]]
//输出：1
//解释：交换 0 和 5 ，1 步完成
// 
//
// 
//输入：board = [[1,2,3],[5,4,0]]
//输出：-1
//解释：没有办法完成谜板
// 
//
// 
//输入：board = [[4,1,2],[5,0,3]]
//输出：5
//解释：
//最少完成谜板的最少移动次数是 5 ，
//一种移动路径:
//尚未移动: [[4,1,2],[5,0,3]]
//移动 1 次: [[4,1,2],[0,5,3]]
//移动 2 次: [[0,1,2],[4,5,3]]
//移动 3 次: [[1,0,2],[4,5,3]]
//移动 4 次: [[1,2,0],[4,5,3]]
//移动 5 次: [[1,2,3],[4,5,0]]
// 
//
// 
//输入：board = [[3,2,4],[1,5,0]]
//输出：14
// 
//
// 提示： 
//
// 
// board 是一个如上所述的 2 x 3 的数组. 
// board[i][j] 是一个 [0, 1, 2, 3, 4, 5] 的排列. 
// 
// Related Topics 广度优先搜索 
// 👍 121 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 没拼图之前各个元素相邻的元素的索引
    int[][] neighbor = new int[][]{
            {1, 3},
            {0, 4, 2},
            {1, 5},
            {0, 4},
            {3, 1, 5},
            {4, 2}
    };
    public String swap(String new_board, int i, int j) {
        char[] chars = new_board.toCharArray();
        char tmp = chars[i];
        chars[i] = chars[j];
        chars[j] = tmp;
        return new String(chars);
    }
    public int slidingPuzzle(int[][] board) {
        int m = 2, n = 3;
        // 初始状态转字符串
        char[] chars = new char[6];
        int index = 0;
        for (int[] row:board) {
            for (int ch:row) {
                chars[index++] = (char)(ch+'0');
            }
        }
        String start = new String(chars);
        String target = "123450";
        // 防止走回头路
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.offer(start.toString());
        int steps = 0;
        // BFS 框架
        while (!q.isEmpty()) {
            int size = q.size();
            // 框架：目的将每一层可能的情况都放入队列
            for (int i = 0; i < size; i++) {
                String cur = q.poll();
                // 如果找到target
                if (cur.equals(target)) return steps;
                // 找到 0 所在的索引
                int index0 = cur.indexOf('0');
                // 0 周围对应的索引有几个，这一层就有几种情况
                for (int adj : neighbor[index0]) {
                    // 互换位置
                    String s = swap(cur, adj, index0);
                    // 防止回头
                    if (!visited.contains(s)) {
                        q.offer(s);
                        visited.add(s);
                    }
                }
            }
            steps++;
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
