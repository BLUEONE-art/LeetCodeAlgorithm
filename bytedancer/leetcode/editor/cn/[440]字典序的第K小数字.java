//给定整数 n 和 k，找到 1 到 n 中字典序第 k 小的数字。 
//
// 注意：1 ≤ k ≤ n ≤ 109。 
//
// 示例 : 
//
// 
//输入:
//n: 13   k: 2
//
//输出:
//10
//
//解释:
//字典序的排列是 [1, 10, 11, 12, 13, 2, 3, 4, 5, 6, 7, 8, 9]，所以第二小的数字是 10。
// 
// 👍 211 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findKthNumber(int n, int k) {
        int ans = 1; // 第一个节点就是1
        k = k - 1; // 虚拟节点0，第一层只有1~9，其余从0~9
        while (k > 0) {
            int nodes = getNode(n, ans, ans + 1); // 根据n不断寻找两个前缀之间节点的数量
            if (nodes > k) { // 说明在以ans为根节点的子树中
                ans *= 10; // 接着在ans子树的子树中查找
                k -= 1; // 减去根节点的数量
            }
            else { // num <= k，ans和ans + 1两个前缀之间节点数量小于k，说明第k大的元素不在ans为根节点的子树中
                ans += 1; // 往右边相邻树中查找
                k -= nodes; // 减去前一个树中节点数量
            }
        }
        return ans;
    }

    public int getNode(int n, long profix, long next_Profix) { // 相邻两个前缀之间的节点数量
        int num = 0;
        while (profix <= n) {
            num += Math.min(n + 1, next_Profix) - profix; // n + 1，当n = 13时，前缀1和前缀2之间的节点：第一次确定’1‘这个节点，第二次确定10，11，12，13四个四个节点
            profix *= 10;
            next_Profix *= 10;
        }
        return num;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

//     public int findKthNumber(int n, int k) {
//        int curr = 1;
//        k = k - 1;
//        while (k > 0) {
//            //计算前缀之间的step数
//            int steps = getSteps(n, curr, curr + 1);
//            //前缀间距太大，需要深入一层
//            if (steps > k) {
//                curr *= 10;
//                //多了一个确定节点，继续-1
//                k -= 1;
//            }
//            //间距太小，需要扩大前缀范围
//            else {
//                curr += 1;
//                k -= steps;
//            }
//        }
//        return curr;
//    }
//
//    private int getSteps(int n, long curr, long next) {
//        int steps = 0;
//        while (curr <= n) {
//            steps += Math.min(n + 1, next) - curr;
//            curr *= 10;
//            next *= 10;
//        }
//        return steps;
//    }
