//传送带上的包裹必须在 D 天内从一个港口运送到另一个港口。 
//
// 传送带上的第 i 个包裹的重量为 weights[i]。每一天，我们都会按给出重量的顺序往传送带上装载包裹。我们装载的重量不会超过船的最大运载重量。 
//
// 返回能在 D 天内将传送带上的所有包裹送达的船的最低运载能力。 
//
// 
//
// 示例 1： 
//
// 输入：weights = [1,2,3,4,5,6,7,8,9,10], D = 5
//输出：15
//解释：
//船舶最低载重 15 就能够在 5 天内送达所有包裹，如下所示：
//第 1 天：1, 2, 3, 4, 5
//第 2 天：6, 7
//第 3 天：8
//第 4 天：9
//第 5 天：10
//
//请注意，货物必须按照给定的顺序装运，因此使用载重能力为 14 的船舶并将包装分成 (2, 3, 4, 5), (1, 6, 7), (8), (9), (1
//0) 是不允许的。 
// 
//
// 示例 2： 
//
// 输入：weights = [3,2,2,4,1,4], D = 3
//输出：6
//解释：
//船舶最低载重 6 就能够在 3 天内送达所有包裹，如下所示：
//第 1 天：3, 2
//第 2 天：2, 4
//第 3 天：1, 4
// 
//
// 示例 3： 
//
// 输入：weights = [1,2,3,1,1], D = 4
//输出：3
//解释：
//第 1 天：1
//第 2 天：2
//第 3 天：3
//第 4 天：1, 1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= D <= weights.length <= 50000 
// 1 <= weights[i] <= 500 
// 
// Related Topics 数组 二分查找 
// 👍 162 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shipWithinDays(int[] weights, int D) {

        // 最小的载重，因为货物不能被分割，所以最小载重就是 weight 矩阵中的最大值
        int left = getMax(weights);
        // 最大的载重就是货物重量之和，因为是搜索左侧边界，所以 + 1
        int right = getSum(weights) + 1;
        while (left < right) {
            int mid = left + (right - left) / 2; // 等价于 (left + right) / 2
            if (canFinish(weights, mid, D)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 判断 D 天内能否以 cap 吨/天 的速度运完
    private boolean canFinish(int[] weights, int cap, int D) {
        // 记录运送了多少件货物
        int i = 0;
        // 计算 D 天内运送了 i 件货物
        for (int day = 0; day < D; day++) {
            int maxCap = cap;
            while ((maxCap -= weights[i]) >= 0) {
                i++;
                // 假设计算了 D 天，若 i = weights.length
                if (i == weights.length) return true;
            }
        }
        return false;
    }

    private int getMax(int[] weights) {
        int max = 0;
        for (int w : weights) {
            max = Math.max(w, max);
        }
        return max;
    }

    private int getSum(int[] weights) {
        int sum = 0;
        for (int w : weights) {
            sum += w;
        }
        return sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
