//给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[
//i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。 
//
// 
//
// 示例: 
//
// 
//输入: [1,2,3,4,5]
//输出: [120,60,40,30,24] 
//
// 
//
// 提示： 
//
// 
// 所有元素乘积之和不会溢出 32 位整数 
// a.length <= 100000 
// 
// 👍 81 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] constructArr(int[] a) {
        if (a.length == 0) return new int[0];
        // 先计算 i != j 时左下角的积的和
        int[] res = new int[a.length];
        res[0] = 1;
        for (int i = 1; i < a.length; i++) {
            res[i] = res[i - 1] * a[i - 1];
        }
        // 计算 i != j 时右上角的积的和
        int tmp = 1;
        for (int j = a.length - 2; j >= 0; j--) {
            tmp = tmp * a[j + 1];
            res[j] = res[j] * tmp;
        }
        return res;

        // 暴力解法
        int size = a.length;
        int[] res_arr = new int[size];
        int res = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                res = res * (i == j ? 1 : a[j]);
            }
            res_arr[i] = res;
            res = 1;
        }
        return res_arr;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
