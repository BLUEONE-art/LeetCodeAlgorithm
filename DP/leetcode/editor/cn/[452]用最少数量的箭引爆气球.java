//在二维空间中有许多球形的气球。对于每个气球，提供的输入是水平方向上，气球直径的开始和结束坐标。由于它是水平的，所以纵坐标并不重要，因此只要知道开始和结束的横
//坐标就足够了。开始坐标总是小于结束坐标。 
//
// 一支弓箭可以沿着 x 轴从不同点完全垂直地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend， 且满足 xsta
//rt ≤ x ≤ xend，则该气球会被引爆。可以射出的弓箭的数量没有限制。 弓箭一旦被射出之后，可以无限地前进。我们想找到使得所有气球全部被引爆，所需的弓箭的
//最小数量。 
//
// 给你一个数组 points ，其中 points [i] = [xstart,xend] ，返回引爆所有气球所必须射出的最小弓箭数。 
// 
//
// 示例 1： 
//
// 
//输入：points = [[10,16],[2,8],[1,6],[7,12]]
//输出：2
//解释：对于该样例，x = 6 可以射爆 [2,8],[1,6] 两个气球，以及 x = 11 射爆另外两个气球 
//
// 示例 2： 
//
// 
//输入：points = [[1,2],[3,4],[5,6],[7,8]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：points = [[1,2],[2,3],[3,4],[4,5]]
//输出：2
// 
//
// 示例 4： 
//
// 
//输入：points = [[1,2]]
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：points = [[2,3],[2,3]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 0 <= points.length <= 104 
// points[i].length == 2 
// -231 <= xstart < xend <= 231 - 1 
// 
// Related Topics 贪心算法 排序 
// 👍 343 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 思路：将装有气球起始和结束坐标的二维数组按照结束坐标做一个升序排序，获得第一个气球的末尾坐标
    // 然后遍历二维数组，判断下一个气球的其实坐标是否大于第一个气球的末尾坐标，如果大于，计数器 +1
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        // 对每个子数组的 end 升序处理
        // 注意compare 排序中默认升序
        // 返回 1 == true 代表降序，我想调整顺序
        // 返回 -1 代表升序
        Arrays.sort(points, new Comparator<int[]>() {
            public int compare(int[] point1, int[] point2) {
                if (point1[1] > point2[1]) {
                    return 1; // 想要升序：如果 point1 第一列的值大于 point2 第一列的值，不符合升序，返回 1，调整两个数组位置
                } else if (point1[1] < point2[1]) {
                    return -1; // 如果直接就是升序，就返回 -1 即可
                } else {
                    return 0;
                }
            }
        });
        // 即使二维数组中子数组全部重合，不重合数组个数就为 1
        int count = 1;
        // 得到排序后第一个子数组的末尾索引
        int pos = points[0][1];
        // 遍历判断
        for (int[] balloon: points) {
            if (balloon[0] > pos) {
                pos = balloon[1];
                ++count;
            }
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
