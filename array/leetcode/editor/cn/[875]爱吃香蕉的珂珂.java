//珂珂喜欢吃香蕉。这里有 N 堆香蕉，第 i 堆中有 piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。 
//
// 珂珂可以决定她吃香蕉的速度 K （单位：根/小时）。每个小时，她将会选择一堆香蕉，从中吃掉 K 根。如果这堆香蕉少于 K 根，她将吃掉这堆的所有香蕉，然后
//这一小时内不会再吃更多的香蕉。 
//
// 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。 
//
// 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入: piles = [3,6,7,11], H = 8
//输出: 4
// 
//
// 示例 2： 
//
// 输入: piles = [30,11,23,4,20], H = 5
//输出: 30
// 
//
// 示例 3： 
//
// 输入: piles = [30,11,23,4,20], H = 6
//输出: 23
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 10^4 
// piles.length <= H <= 10^9 
// 1 <= piles[i] <= 10^9 
// 
// Related Topics 二分查找 
// 👍 134 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minEatingSpeed(int[] piles, int H) {
        /* 二分查找(因为寻找最小值，所以使用左侧边界框架) */
        // 求 piles 数组最大值
        int max = getMax(piles);
        // 因为暴力解法：for(int speed = 1; speed < max; speed++) speed 从 1 开始
        // 搜索空间：[left, right) = [1, max + 1)，并不包括 max + 1
        int left = 1, right = max + 1;

        while (left < right) {
            // 计算 mid，在本题相当于 speed
            int speed = (left + right) / 2;
            if (canFinish(piles, speed, H)) { // 这里包括 time <= H 的情况
                right = speed;
            } else { // time > H，加大吃香蕉速度
                left = speed + 1;
            }
        }
        return left;

//        /* 暴力解法(不通过) */
//        // 求 piles 数组最大值
//        int max = getMax(piles);
//        // 对速度由 1 根每小时遍历到 max 根每小时
//        // 只要找到满足在 H 小时内吃掉所有香蕉的最小速度，即停止遍历并返回
//        for(int speed = 1; speed < max; speed++) {
//            if (canFinish(piles, speed, H)) {
//                return speed;
//            }
//        }
//        // 否则每小时必要吃掉这堆香蕉中最大的一堆
//        return max;

    }

    private boolean canFinish(int[] piles, int speed, int H) {

        // 定义以 speed 根每小时吃完香蕉所需要的时间
        int time = 0;
        // 计算吃完所有堆香蕉花费的总时间
        for (int n : piles) {
            time += timeOf(n, speed); // 吃完一堆要花费的时间
        }
        // 如果 time <= H，返回 true，否则 false
        return time <= H;
    }

    private int timeOf(int n, int speed) {

        // n / speed：整数部分小时，如果有余数，再计算
        // n % speed：小数部分，如果大于 0，表示有余数，还需花 1h 吃完，如果等于 0，就刚好
        return (n / speed) + ((n % speed) > 0 ? 1 : 0);
    }

    private int getMax(int[] piles) {
        int max = 0;
        for (int p : piles) {
            max = Math.max(p, max);
        }
        return max;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
