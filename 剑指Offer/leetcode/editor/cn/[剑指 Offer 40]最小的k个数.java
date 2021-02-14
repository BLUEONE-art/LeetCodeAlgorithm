//输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。 
//
// 
//
// 示例 1： 
//
// 输入：arr = [3,2,1], k = 2
//输出：[1,2] 或者 [2,1]
// 
//
// 示例 2： 
//
// 输入：arr = [0,1,2,1], k = 1
//输出：[0] 
//
// 
//
// 限制： 
//
// 
// 0 <= k <= arr.length <= 10000 
// 0 <= arr[i] <= 10000 
// 
// Related Topics 堆 分治算法 
// 👍 191 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    // 利用快排思想求解
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0 || k == 0) {
            return new int[0];
        }
        // 构建快速排序方法
        // 查找的是排序后前 K 个数，对应下标就是 k - 1
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }

    public int[] quickSearch(int[] arr, int low, int high, int k) {
        // 快速排序：每次都会返回一个下标 j，将 arr 中小于 arr[j] 的数排放在其左边，大于其的放在其右边
        int j = partition(arr, low, high);
        // 如果这个 j == k，直接返回数组前 k 个数
        if (j == k) {
            return Arrays.copyOf(arr, j + 1);
        }
        // 否则根据 j 与 k 的大小接着往 arr 中 j 左边和 j 右边元素中查找
        return j > k ? quickSearch(arr, low, j - 1, k) : quickSearch(arr, j + 1, high, k);
    }

    // 快速分区：返回下标 j，让 arr 中小于 arr[j] 的数都在其左边，大于的在右边
    public int partition(int[] arr, int low, int high) {
        // 数组中最左边的数
        int leftmostNum = arr[low];
        // 初始 i，j
        int i = low, j = high + 1;
        while (true) {
            // 让 i 自加，并判断它后面的数是否比 leftmostNum 小,如果有比 leftmostNum 大的，跳出 while
            while (++i < high && arr[i] < leftmostNum);
            // 让 j 自减，并判断它前面的数是否比 leftmostNum 大,如果有比它的小的，跳出 while
            while (--j > low && arr[j] > leftmostNum);
            if (i >= j) {
                break;
            }
            // 此时找到了 low < i < j < high 情况下，arr[i] 比 leftmostNum 大，arr[j] 比 leftmostNum 小，需要交换它们的位置
            int tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
        }
        // 循环结束后 i >= j && arr[j] < arr[low]，所以要交换 j 和 low 的位置，返回 j
        arr[low] = arr[j];
        arr[j] = leftmostNum;
        return j;
    }
}
//    int[] res = new int[k];
//        Arrays.sort(arr);
//                for (int i = 0; i < res.length; i++) {
//        res[i] = arr[i];
//        }
//        return res;
//leetcode submit region end(Prohibit modification and deletion)
