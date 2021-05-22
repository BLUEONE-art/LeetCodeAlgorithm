//老师想给孩子们分发糖果，有 N 个孩子站成了一条直线，老师会根据每个孩子的表现，预先给他们评分。 
//
// 你需要按照以下要求，帮助老师给这些孩子分发糖果： 
//
// 
// 每个孩子至少分配到 1 个糖果。 
// 评分更高的孩子必须比他两侧的邻位孩子获得更多的糖果。 
// 
//
// 那么这样下来，老师至少需要准备多少颗糖果呢？ 
//
// 
//
// 示例 1： 
//
// 
//输入：[1,0,2]
//输出：5
//解释：你可以分别给这三个孩子分发 2、1、2 颗糖果。
// 
//
// 示例 2： 
//
// 
//输入：[1,2,2]
//输出：4
//解释：你可以分别给这三个孩子分发 1、2、1 颗糖果。
//     第三个孩子只得到 1 颗糖果，这已满足上述两个条件。 
// Related Topics 贪心算法 
// 👍 555 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int candy(int[] ratings) {
        int len = ratings.length;
        int[] left = new int[len];
        int[] right = new int[len];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        for (int i = 1; i < len; i++) { // 左规则：右边有学生成绩大于左边，即多加一块糖
            if (ratings[i] > ratings[i - 1]) left[i] = left[i - 1] + 1;
        }
        int count = left[len - 1];
        for (int j = len - 2; j >= 0; j--) { // 右规则：左边有学生成绩大于右边，多加一块糖
            if (ratings[j] > ratings[j + 1]) {
                right[j] = right[j + 1] + 1;
            }
            count += Math.max(left[j], right[j]);
        }
        return count;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
