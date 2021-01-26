//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 103 
// -109 <= nums[i] <= 109 
// -109 <= target <= 109 
// 只会存在一个有效答案 
// 
// Related Topics 数组 哈希表 
// 👍 10122 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /* 使用 HashMap 存储每个元素索引解决问题*/
    public int[] twoSum(int[] nums, int target) {
        // 创建 nums 数组中元素 --> 其对应索引 的映射
        HashMap<Integer, Integer> index = new HashMap<>();
        // 将元素和索引放入 index
        for (int i = 0; i < nums.length; i++) {
            index.put(nums[i], i);
        }
        // 核心思想：在 index 存储的元素中，如果能找到两个元素之和等于 target 并且它们的索引不同，则即为所求
        for (int i = 0; i < nums.length; i++) {
            // nums[i] + other = target
            int other = target - nums[i];
            // 若 other 也在 index 中并且 other 的索引跟 nums[i] 的索引还不一样
            if (index.containsKey(other) && index.get(other) != i) {
                return new int[]{i, index.get(other)};
            }
        }
        return new int[]{-1, -1};
    }

//    /* 先排序再使用左右指针 */
//    // 有序数组就要想到左右指针的方法
//    public int[] twoSum(int[] nums, int target) {
//        int left = 0; // 左侧最小索引
//        int right = nums.length - 1; // 搜索空间：[left, right]
//        int[] arr = Arrays.copyOfRange(nums, 0, nums.length);
//        Arrays.sort(arr);
//        while (left <= right) {
//            int sum = arr[left] + arr[right];
//            if (sum == target) {
//                int a = findIndex(left, arr, nums);
//                int b = findIndex(right, arr, nums);
//                if (a == b) {
//                    // 找到一个不在 nums 数组中的数
//                    // 此时 arr 为有序数组，arr[arr.length - 1] 表示 arr 和 nums 数组的最大值
//                    // arr[arr.length - 1] + 1 在 nums 中一定不存在
//                    nums[b] = arr[arr.length - 1] + 1;
//                    b = findIndex(right, arr, nums);
//                }
//                return new int[]{a, b};
//            } else if (sum < target) {
//                left++; // 让 left 大一点再搜索
//            } else if (sum > target) {
//                right--; // right 小一点再搜索
//            }
//        }
//        return new int[]{-1, -1};
//    }
//
//    // 找到 left 和 right 在 nums 数组中的索引
//    private int findIndex(int afterIndex, int[] arr, int[] nums) {
//        int orignalIndex = 0, i = 0;
//        while (i < nums.length) {
//            if (arr[afterIndex] == nums[i]) {
//                orignalIndex = i;
//                break;
//            }
//            i++;
//        }
//        return orignalIndex;
//    }
}
//leetcode submit region end(Prohibit modification and deletion)
