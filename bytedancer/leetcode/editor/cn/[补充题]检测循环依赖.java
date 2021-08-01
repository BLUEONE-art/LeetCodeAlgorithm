// 给定一个依赖关系是[[0,2],[1,2],[2,3],[2,4]]
// 它们之间不存在循环依赖,可行的编译序列是[0,1,2,3,4]，也可以是[1,0,2,4,3]等
// 拓扑排序算法过程：
//
//选择图中一个入度为0的点，记录下来
//在图中删除该点和所有以它为起点的边
//重复1和2，直到图为空或没有入度为0的点

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] haveCircularDependency(int n, int[][] prerequisites) {
        // 入度矩阵
        int[] inDegrees = new int[n];
        // 图的邻接矩阵
        List<List<Integer>> adjLists = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<Integer> ans = new ArrayList<>();
        // 一维变二维
        for (int i = 0; i < n; i++) {
            adjLists.add(new ArrayList<>());
        }
        // 计算邻接矩阵
        for (int i = 0; i < prerequisites.length; i++) {
            // 起始点
            int cur = prerequisites[i][0];
            // cur -指向-> next
            int next = prerequisites[i][1];
            // 被指向的点的入度+1
            inDegrees[next]++;
            // 邻接矩阵的表示方法：记录当前节点cur指向的节点
            adjLists.get(cur).add(next);
        }
        // 第一次取出入度矩阵中入度为0的节点的下标
        for (int i = 0; i < inDegrees.length; i++) {
            if (inDegrees[i] == 0) {
                q.offer(i);
            }
        }
        // BFS
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                ans.add(cur);
                List<Integer> adjList = adjLists.get(cur);
                for (int adj : adjList) {
                    // 因为指向adj的cur被取出，所有的被cur指向的节点的入度减1
                    inDegrees[adj]--;
                    if (inDegrees[adj] == 0) {
                        q.offer(adj);
                    }
                }
            }
        }
        int[] res;
        if (ans.size() == n) {
            res = ans.stream().mapToInt(Integer::valueOf).toArray();
        } else {
            res = new int[0];
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] p = {{0, 2}, {1, 2}, {2, 3}, {2, 4}};
        int[] ans = haveCircularDependency(5, p);
        for (int an : ans) {
            System.out.println(an);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)