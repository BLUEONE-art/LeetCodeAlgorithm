//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,　3,　5,　7],
//　　　　　　　　　[10,11,16,　20],
// 　　　　　　　　[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 473 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;
        while (row >= 0 && col < matrix[0].length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }

//    public boolean searchMatrix(int[][] matrix, int target) {
//        int m = matrix.length;
//        int n = matrix[0].length;
//        List<Integer> arr = new ArrayList<>();
//        for (int i = 0; i < m; i++) {
//            for (int j = 0; j < n; j++) {
//                arr.add(matrix[i][j]);
//            }
//        }
//        int[] tmp = arr.stream().mapToInt(Integer::valueOf).toArray();
//        return binarySearch(tmp, 0, m * n - 1, target);
//    }
//
//    public boolean binarySearch(int[] nums, int left, int right, int tar) {
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] == tar) {
//                return true;
//            } else if (nums[mid] < tar) {
//                left = mid + 1;
//            } else {
//                right = mid - 1;
//            }
//        }
//        return false;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
